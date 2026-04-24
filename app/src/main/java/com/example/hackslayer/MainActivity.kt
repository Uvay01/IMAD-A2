package com.example.hackslayer

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    // tag for my logs so I can filter them easily
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // default edge to edge stuff from android studio
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // logging that the first screen loaded up fine
        Log.d(TAG, "onCreate: Welcome screen is running")

        // linking the start button from the xml layout
        val btnStart = findViewById<Button>(R.id.btnStart)

        // what to do when the start button is clicked
        btnStart.setOnClickListener {
            Log.i(TAG, "Start button got clicked. going to questions now.")

            // making an intent to move to the next screen
            val intent = Intent(this, QuestionActivity::class.java)
            startActivity(intent)
        }
    }
}