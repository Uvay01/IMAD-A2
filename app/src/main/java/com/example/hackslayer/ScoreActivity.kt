package com.example.hackslayer

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ScoreActivity : AppCompatActivity() {


    private val TAG = "ScoreActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_score)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Log.d(TAG, "Final score screen loaded up")

        // hooking up the views from xml
        val tvFinalScore = findViewById<TextView>(R.id.tvFinalScore)
        val tvScoreMessage = findViewById<TextView>(R.id.tvScoreMessage)
        val tvReviewAnswers = findViewById<TextView>(R.id.tvReviewAnswers)
        val btnReview = findViewById<Button>(R.id.btnReview)

        // linking the restart button
        val btnRestart = findViewById<Button>(R.id.btnRestart)

        val finalScore = intent.getIntExtra("FINAL_SCORE", 0)
        Log.i(TAG, "Got the score: $finalScore")

        // updating the text to show their score out of 5
        tvFinalScore.text = "$finalScore / 5"

        // checking the score to see what message to give them
        if (finalScore == 5) {
            tvScoreMessage.text = "Master Hacker! You know your stuff."
            tvScoreMessage.setTextColor(android.graphics.Color.parseColor("#9ECE6A"))
        } else if (finalScore >= 3) {
            tvScoreMessage.text = "Not bad! But be careful what you read online."
        } else {
            tvScoreMessage.text = "Stay Safe Online! Don't believe everything you see."
            tvScoreMessage.setTextColor(android.graphics.Color.parseColor("#F7768E"))
        }

        // what to do when they click review
        btnReview.setOnClickListener {
            Log.d(TAG, "clicked review answers")

            // show the hidden text block with all the answers
            tvReviewAnswers.visibility = View.VISIBLE

            // turn off the button so they don't keep clicking it
            btnReview.isEnabled = false
        }

        // what to do when they click play again
        btnRestart.setOnClickListener {
            Log.i(TAG, "clicked play again. restarting the app.")

            // create an intent to go all the way back to the main welcome screen
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            // finish this screen so they can't hit back and return to their old score
            finish()
        }
    }
}