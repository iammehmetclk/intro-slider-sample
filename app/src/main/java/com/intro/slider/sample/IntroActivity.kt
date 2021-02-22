package com.intro.slider.sample

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        val sharedPreferences: SharedPreferences =
            applicationContext.getSharedPreferences("app_pref", 0)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putBoolean("is_first", false)
        editor.apply()

        val skipButton: TextView = findViewById(R.id.skip_button)
        skipButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
        val viewPager2: ViewPager2 = findViewById(R.id.view_pager_2)
        val adapter = ScreenAdapter(
            listOf(FirstScreen(), SecondScreen(), ThirdScreen()),
            supportFragmentManager,
            lifecycle
        )
        viewPager2.adapter = adapter
        val tabLayout: TabLayout = findViewById(R.id.tab_layout)
        TabLayoutMediator(tabLayout, viewPager2) { _, _ -> }.attach()

        val nextButton: ImageView = findViewById(R.id.next_button)
        nextButton.setOnClickListener {
            viewPager2.currentItem += 1
        }
        val previousButton: ImageView = findViewById(R.id.previous_button)
        previousButton.setOnClickListener {
            viewPager2.currentItem -= 1
        }
    }

    class FirstScreen : Fragment(R.layout.first_screen)
    class SecondScreen : Fragment(R.layout.second_screen)
    class ThirdScreen : Fragment(R.layout.third_screen)
}