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
                binding.crown.visibility = View.INVISIBLE
                binding.winingStatus.setImageResource(R.drawable.neutral)
                binding.congratulations.text=getString(R.string.draw)
                binding.wonStatus.text=""
            }
        }
        binding.backToHome.setOnClickListener{
            finish()
            startActivity(home)
        }
        binding.playAgain.setOnClickListener{
            finish()
            startActivity(game)
        }

    }
}