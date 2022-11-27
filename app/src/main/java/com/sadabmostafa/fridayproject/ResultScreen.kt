package com.sadabmostafa.fridayproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.sadabmostafa.fridayproject.databinding.ActivityResultScreenBinding

class ResultScreen : AppCompatActivity() {
    private lateinit var binding: ActivityResultScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_screen)
        binding = ActivityResultScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //creating intent for going to that activity
        val home = Intent(this, StartingScreen::class.java)
        val game = Intent(this, MainActivity::class.java)
        val extras = intent.extras
        var result = 0
        if (extras != null) {
            result = extras.getInt("result")
        }
        when (result) {
            1 -> {
                binding.result.text = getString(R.string.playerToast, "one")
            }
            2 -> {
                binding.result.text = getString(R.string.playerToast, "two")
            }
            else -> {
                binding.imageView2.visibility = View.INVISIBLE
                binding.imageView.setImageResource(R.drawable.neutral)
                binding.congo.text="Its a Draw"
                binding.won.text=""
            }
        }
        binding.backToHome.setOnClickListener{
            finish()
            startActivity(home)
        }
        binding.playAgain.setOnClickListener{
            startActivity(game)
            finish()
        }

    }
}