package com.ahmetozaydin.ecommerceapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.ahmetozaydin.ecommerceapp.R


class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        val backButton: Button = findViewById(R.id.searchButton)
        val userinput: EditText = findViewById(R.id.userinput)
        backButton.setOnClickListener {
            var input = userinput.text.toString()
            Log.d("MainActivity2", input)
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("userInput", input)
            startActivity(intent)
        }
    }
}