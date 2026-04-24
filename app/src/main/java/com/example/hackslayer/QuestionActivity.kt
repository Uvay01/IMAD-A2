package com.example.hackslayer

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class QuestionActivity : AppCompatActivity() {

    private val TAG = "QuestionActivity"

    // keeping track of which question we are on and the user's score
    private var currentIndex = 0
    private var score = 0

    // putting all the statements in an array so it's easy to loop through
    private val statements = arrayOf(
        "Putting a wet phone in rice fixes the water damage.",
        "Pressing CTRL + Shift + T reopens your last closed browser tab.",
        "Incognito mode hides your IP address from websites.",
        "Pressing the spacebar scrolls down a webpage.",
        "More megapixels always means a better smartphone camera."
    )

    // the actual answers matching the statements above (true is hack, false is myth)
    private val answers = arrayOf(false, true, false, true, false)

    // declaring my UI variables here
    private lateinit var tvQuestionNumber: TextView
    private lateinit var tvStatement: TextView
    private lateinit var tvFeedback: TextView
    private lateinit var btnHack: Button
    private lateinit var btnMyth: Button
    private lateinit var btnNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        Log.d(TAG, "Question screen started up")

        // finding all the views by their IDs from the layout
        tvQuestionNumber = findViewById(R.id.tvQuestionNumber)
        tvStatement = findViewById(R.id.tvStatement)
        tvFeedback = findViewById(R.id.tvFeedback)
        btnHack = findViewById(R.id.btnHack)
        btnMyth = findViewById(R.id.btnMyth)
        btnNext = findViewById(R.id.btnNext)

        // shows the first question right away when the screen opens
        displayQuestion()

        // hack button logic
        btnHack.setOnClickListener {
            Log.i(TAG, "they picked hack")

            checkAnswer(true)
        }

        // myth button logic
        btnMyth.setOnClickListener {
            Log.i(TAG, "they picked myth")
            // Notice we removed the sound effect from here too!
            checkAnswer(false)
        }

        // next button logic
        btnNext.setOnClickListener {
            Log.i(TAG, "clicked next question")

            // move to the next index in our array
            currentIndex++

            // check if we still have questions left to show
            if (currentIndex < statements.size) {
                displayQuestion()
            } else {
                // done with all questions, move to the score screen
                Log.d(TAG, "game over. sending them to score screen with score: $score")

                val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("FINAL_SCORE", score)
                startActivity(intent)
                finish()
            }
        }
    }

    // method to play a specific sound effect that we pass to it
    private fun playSoundEffect(soundId: Int) {
        val mediaPlayer = MediaPlayer.create(this, soundId)
        mediaPlayer.start()

        // letting the memory go after the sound finishes playing
        mediaPlayer.setOnCompletionListener { mp ->
            mp.release()
        }
    }

    // method to update the screen with the current question info
    private fun displayQuestion() {
        tvQuestionNumber.text = "Question ${currentIndex + 1} of ${statements.size}"
        tvStatement.text = statements[currentIndex]
        tvFeedback.text = "" // clear out the old right/wrong message

        // hide next button until they answer, and enable the hack/myth buttons again
        btnNext.visibility = View.INVISIBLE
        btnHack.isEnabled = true
        btnMyth.isEnabled = true
    }

    // method to see if they got it right
    private fun checkAnswer(userChoice: Boolean) {
        val correctAnswer = answers[currentIndex]

        // lock the buttons so they can't answer twice on the same question
        btnHack.isEnabled = false
        btnMyth.isEnabled = false

        if (userChoice == correctAnswer) {
            // got it right! add to score
            score++
            Log.d(TAG, "Right answer. score is $score")
            tvFeedback.text = "Correct! You nailed it."
            tvFeedback.setTextColor(android.graphics.Color.parseColor("#9ECE6A"))

            playSoundEffect(R.raw.wrong)

        } else {
            // got it wrong
            Log.d(TAG, "Wrong answer.")
            if (correctAnswer) {
                tvFeedback.text = "Wrong! That's actually a real Hack."
            } else {
                tvFeedback.text = "Wrong! That's just an urban Myth."
            }
            tvFeedback.setTextColor(android.graphics.Color.parseColor("#F7768E"))

            playSoundEffect(R.raw.correct)
        }

        // show the next button now that they answered
        btnNext.visibility = View.VISIBLE
    }
}