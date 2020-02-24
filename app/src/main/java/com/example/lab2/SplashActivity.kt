package com.example.lab2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Thread() {
            Thread.sleep(500)
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }.start()
    }

    override fun onRestart() {
        super.onRestart()

        finish()
    }
}
