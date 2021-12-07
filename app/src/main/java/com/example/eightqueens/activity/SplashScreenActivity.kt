package com.example.eightqueens.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.eightqueens.R
import java.lang.Exception

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        setBackgroundSecond()
    }

    fun setBackgroundSecond() {
        handler = Handler()
        handler.postDelayed({
            val inte = Intent(this, MainActivity::class.java)
            startActivity(inte)
        }, 2000)
    }
}
