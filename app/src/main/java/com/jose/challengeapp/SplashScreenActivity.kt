package com.jose.challengeapp

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View

class SplashScreenActivity : AppCompatActivity() {

    private val segundos = 3
    private val millisecons = segundos * 500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        starLaunchSplash()
    }

    private fun starLaunchSplash() {
        fullScreenMode()
        startCount()
    }

    fun fullScreenMode() {
        val uiOptions = window.decorView.systemUiVisibility
        var newUiOptions = uiOptions
        val isImmersiveModeEnabled = uiOptions or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY == uiOptions
        if (Build.VERSION.SDK_INT >= 14) {
            newUiOptions = newUiOptions xor View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        }
        if (Build.VERSION.SDK_INT >= 16) {
            newUiOptions = newUiOptions xor View.SYSTEM_UI_FLAG_FULLSCREEN
        }
        if (Build.VERSION.SDK_INT >= 18) {
            newUiOptions = newUiOptions xor View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        }
        window.decorView.systemUiVisibility = newUiOptions
    }

    private fun startCount() {
        object : CountDownTimer(millisecons.toLong(), 800) {
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() {
                val homeIntent = Intent(this@SplashScreenActivity, InhabitantsActivity::class.java)
                this@SplashScreenActivity.startActivity(homeIntent)
                this@SplashScreenActivity.finish()
            }
        }.start()
    }
}
