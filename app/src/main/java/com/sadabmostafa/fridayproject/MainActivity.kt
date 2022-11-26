package com.sadabmostafa.fridayproject

import android.content.Intent

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.sadabmostafa.fridayproject.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var playerSelector = 1
    private var roundCounter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //selecting starting player
        selectStartingPlayer()
        //button working
        binding.button3.visibility = View.INVISIBLE
        binding.button3.isClickable = false
        binding.ZeroZero.setOnClickListener {
            callChangeButton(binding.ZeroZero)
        }
        binding.ZeroOne.setOnClickListener {
            callChangeButton(binding.ZeroOne)
        }
        binding.ZeroTwo.setOnClickListener {
            callChangeButton(binding.ZeroTwo)
        }
        binding.OneZero.setOnClickListener {
            callChangeButton(binding.OneZero)
        }
        binding.OneOne.setOnClickListener {
            callChangeButton(binding.OneOne)
        }
        binding.OneTwo.setOnClickListener {
            callChangeButton(binding.OneTwo)
        }
        binding.TwoZero.setOnClickListener {
            callChangeButton(binding.TwoZero)
        }
        binding.TwoOne.setOnClickListener {
            callChangeButton(binding.TwoOne)
        }
        binding.TwoTwo.setOnClickListener {
            callChangeButton(binding.TwoTwo)
        }
        //reset button
        binding.button3.setOnClickListener {
            finish()
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }
    }

    private fun selectStartingPlayer() {

        if ((0..1).random() == 0) {
            binding.result.text = getString(R.string.player_2)
            playerSelector = 2
            makeInvisible(View.VISIBLE, View.INVISIBLE)
        } else {
            makeInvisible(View.INVISIBLE, View.VISIBLE)
            binding.result.text = getString(R.string.player_1)
        }
    }

    private fun makeInvisible(x: Int, y: Int) {
        Log.v("MainActivity","Its X from MakeInvisible $x")
        Log.v("MainActivity","Its Y from MakeInvisible $y")
        binding.player2Activated.visibility = x
        binding.player1Activated.visibility = y
    }

    private fun callChangeButton(button: Button) {
        roundCounter++
        if (playerSelector == 1) {
            binding.result.text = getString(R.string.player_2)
            changeButton("X", 2, button)
            makeInvisible(View.VISIBLE, View.INVISIBLE)
        } else {
            binding.result.text =getString(R.string.player_1)
            changeButton("O", 1, button)
            makeInvisible(View.INVISIBLE, View.VISIBLE)
        }
        if (winningLogic(getString(R.string.xSymbol)) == getString(R.string.xSymbol)) {
            binding.result.text = getString(R.string.whoWon, "1")
            lockButton()
            Log.v("MainActivity", "X won")
        } else if (winningLogic(getString(R.string.oSymbol)) == getString(R.string.oSymbol)) {
            binding.result.text = getString(R.string.whoWon, "2")
            lockButton()
            Log.v("MainActivity", "0 won")
        } else Log.v("MainActivity", "continue playing")
        if (roundCounter == 9) {
            Log.v("MainActivity", "Current Turn Number $roundCounter")
            binding.result.text = getString(R.string.draw)
            binding.button3.visibility = View.VISIBLE
            binding.button3.isClickable = true
        }
    }

    private fun lockButton() {
        binding.button3.visibility = View.VISIBLE
        binding.button3.isClickable = true
        changeButton("-", playerSelector, binding.ZeroZero)
        changeButton("-", playerSelector, binding.ZeroOne)
        changeButton("-", playerSelector, binding.ZeroTwo)
        changeButton("-", playerSelector, binding.OneZero)
        changeButton("-", playerSelector, binding.OneOne)
        changeButton("-", playerSelector, binding.OneTwo)
        changeButton("-", playerSelector, binding.TwoZero)
        changeButton("-", playerSelector, binding.TwoOne)
        changeButton("-", playerSelector, binding.TwoTwo)
    }

    private fun changeButton(CrossOrZero: String, PlayerNo: Int, button: Button) {

        if(button.isClickable){
            button.isClickable = false
            button.text = CrossOrZero
            playerSelector = PlayerNo
        }
    }

    private fun winningLogic(value: String): String {
        if (binding.ZeroZero.text == value && binding.ZeroOne.text == value && binding.ZeroTwo.text == value) {
            return value
        } else if (binding.OneZero.text == value && binding.OneOne.text == value && binding.OneTwo.text == value) {
            return value
        } else if (binding.TwoZero.text == value && binding.TwoOne.text == value && binding.TwoTwo.text == value) {
            return value
        } else if (binding.ZeroZero.text == value && binding.OneZero.text == value && binding.TwoZero.text == value) {
            return value
        } else if (binding.ZeroOne.text == value && binding.OneOne.text == value && binding.TwoOne.text == value) {
            return value
        } else if (binding.ZeroTwo.text == value && binding.OneTwo.text == value && binding.TwoTwo.text == value) {
            return value
        } else if (binding.ZeroZero.text == value && binding.OneOne.text == value && binding.TwoTwo.text == value) {
            return value
        } else if (binding.ZeroTwo.text == value && binding.OneOne.text == value && binding.TwoZero.text == value) {
            return value
        } else return "Continue"
    }
}
