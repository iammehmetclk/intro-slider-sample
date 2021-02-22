package com.intro.slider.sample

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPreferences: SharedPreferences = applicationContext.getSharedPreferences("app_pref", 0)
        var isFirst: Boolean = sharedPreferences.getBoolean("is_first", true)
        isFirst = true //remove this line in real application

        if (isFirst) startActivity(Intent(this, IntroActivity::class.java))
        else startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}