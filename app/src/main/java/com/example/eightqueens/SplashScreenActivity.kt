package com.example.eightqueens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import java.lang.Exception

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        setBackgroundSecond()
    }
    fun setFirstBackground() {
        val backgroundThread = object : Thread() {
            override fun run() {
                try {
                    Thread.sleep(4000)
                    val inte = Intent(baseContext, MainActivity::class.java)
                    startActivity(inte)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
        backgroundThread.start()
    }
    fun setBackgroundSecond() {
        handler = Handler()
        handler.postDelayed({
            val inte = Intent(this, MainActivity::class.java)
            startActivity(inte)
        }, 4000)
    }
}
