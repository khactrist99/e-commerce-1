package com.ahmetozaydin.ecommerceapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.ahmetozaydin.ecommerceapp.R


class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        val backButton: Button = findViewById(R.id.backButton)

        backButton.setOnClickListener {
            finish()
        }
    }
}