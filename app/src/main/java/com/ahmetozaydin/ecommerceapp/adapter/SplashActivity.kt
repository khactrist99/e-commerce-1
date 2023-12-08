package com.ahmetozaydin.ecommerceapp.adapter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.ahmetozaydin.ecommerceapp.R
import com.ahmetozaydin.ecommerceapp.view.MainActivity2

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity2::class.java))
            finish()
        }, 500) // 3000 is the delayed time in milliseconds.
    }
}