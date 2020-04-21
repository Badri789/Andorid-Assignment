package com.example.tictactoe

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    var activePlayer = 1
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var player1Wins = 0
    var player2Wins = 0


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setGameButtonListeners()

        reset.setOnClickListener {
            resetGame()
            player1Wins = 0
            player2Wins = 0
            player1Score.text = "Player 1: "
            player2Score.text = "Player 2: "

        }
    }

    private fun setGameButtonListeners() {
        val gameButtons = listOf(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9)
        for (item in gameButtons) {
            item.setOnClickListener{
                buttonClick(it)
            }
        }
    }

    private fun buttonClick(view: View) {
        var cellId = 0
        when(view) {
            btn1 -> cellId = 1
            btn2 -> cellId = 2
            btn3 -> cellId = 3
            btn4 -> cellId = 4
            btn5 -> cellId = 5
            btn6 -> cellId = 6
            btn7 -> cellId = 7
            btn8 -> cellId = 8
            btn9 -> cellId = 9
        }

        game(cellId, view)
    }

    private fun game(cellId: Int, view: View) {

        val button: Button = view as Button

        if (activePlayer == 1) {
            button.text = "X"
            button.setBackgroundResource(android.R.color.holo_red_light)
            player1.add(cellId)
            activePlayer = 2
        } else {
            button.text = "O"
            button.setBackgroundResource(android.R.color.holo_blue_light)
            player2.add(cellId)
            activePlayer = 1
        }

        button.isEnabled = false

        checkWinner()
    }

    @SuppressLint("SetTextI18n")
    private fun checkWinner() {
        var winner = 0

        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) winner = 1
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) winner = 2

        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) winner = 1
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) winner = 2

        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) winner = 1
        if (player2.contains(7) && player2.contains(8) && player2.contains(8)) winner = 2

        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) winner = 1
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) winner = 2

        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) winner = 1
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) winner = 2

        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) winner = 1
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) winner = 2

        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) winner = 1
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) winner = 2

        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) winner = 1
        if (player2.contains(3) && player2.contains(5) && player2.contains(7)) winner = 2

        if (winner == 1) {
            player1Wins += 1
            player1Score.text = "Player 1: "
            player1Score.text = """${player1Score.text}$player1Wins"""
            Toast.makeText(this, "Player 1 won the game", Toast.LENGTH_LONG).show()
            resetGame()
        } else if (winner == 2) {
            player2Wins += 1
            player2Score.text = "Player 2: "
            player2Score.text = """${player2Score.text}$player2Wins"""
            Toast.makeText(this, "Player 2 won the game", Toast.LENGTH_LONG).show()
            resetGame()
        } else if (player1.size + player2.size == 9) {
            Toast.makeText(this, "DRAW!!!", Toast.LENGTH_LONG).show()
            resetGame()
        }
    }

    private fun resetGame() {
        activePlayer = 1
        player1.clear()
        player2.clear()

        for (i in 1..9) {
            val selectedButton: Button =
                when(i) {
                    1 -> btn1
                    2 -> btn2
                    3 -> btn3
                    4 -> btn4
                    5 -> btn5
                    6 -> btn6
                    7 -> btn7
                    8 -> btn8
                    else -> btn9
                }

            selectedButton.text = ""
            selectedButton.setBackgroundResource(android.R.color.white)
            selectedButton.isEnabled = true
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putIntegerArrayList("player1", player1)
        outState.putIntegerArrayList("player2", player2)
        outState.putInt("activePlayer", activePlayer)
        outState.putInt("player1Wins", player1Wins)
        outState.putInt("player2Wins", player2Wins)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        player1 = savedInstanceState.getIntegerArrayList("player1")!!
        player2 = savedInstanceState.getIntegerArrayList("player2")!!
        activePlayer = savedInstanceState.getInt("activePlayer")
        player1Wins = savedInstanceState.getInt("player1Wins")
        player2Wins = savedInstanceState.getInt("player2Wins")

        for (n in player1) {
            val buttonID = resources.getIdentifier("btn$n", "id", packageName)
            val btn = findViewById<Button>(buttonID)
            btn.setBackgroundResource(android.R.color.holo_red_light)
            btn.text = "X"
            btn.isEnabled = false
        }

        for (n in player2) {
            val buttonID = resources.getIdentifier("btn$n", "id", packageName)
            val btn = findViewById<Button>(buttonID)
            btn.setBackgroundResource(android.R.color.holo_blue_light)
            btn.text = "O"
            btn.isEnabled = false
        }
    }
}


