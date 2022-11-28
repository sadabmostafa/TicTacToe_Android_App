package com.sadabmostafa.fridayproject

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sadabmostafa.fridayproject.databinding.ActivityStartingScreenBinding

class StartingScreen : AppCompatActivity() {
    private lateinit var binding: ActivityStartingScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartingScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.singlePlayer.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}