package com.example.kotlinfeud.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.kotlinfeud.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startGame = findViewById<Button>(R.id.button_startGame)

        button_startGame.setOnClickListener {
            Toast.makeText(this,"Success", Toast.LENGTH_LONG).show()
        }
    }

}
