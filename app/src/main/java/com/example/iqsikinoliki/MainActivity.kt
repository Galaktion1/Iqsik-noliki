package com.example.iqsikinoliki

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var resetButton: Button

    private var firstPlayer=ArrayList<Int>()
    private var secondPlayer=ArrayList<Int>()
    var winnerPlayer=0
    private var movement= 0




    private var activePlayer=1



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

    }
    private fun init() {

        button1=findViewById(R.id.button1)
        button2=findViewById(R.id.button2)
        button3=findViewById(R.id.button3)
        button4=findViewById(R.id.button4)
        button5=findViewById(R.id.button5)
        button6=findViewById(R.id.button6)
        button7=findViewById(R.id.button7)
        button8=findViewById(R.id.button8)
        button9=findViewById(R.id.button9)
        resetButton=findViewById(R.id.resetButton)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)

    }

    override fun onClick(clickedView: View?) {

        if (clickedView is Button ) {
            var buttonId=0

            when (clickedView.id) {

                R.id.button1 -> buttonId=1
                R.id.button2 -> buttonId=2
                R.id.button3 -> buttonId=3
                R.id.button4 -> buttonId=4
                R.id.button5 -> buttonId=5
                R.id.button6 -> buttonId=6
                R.id.button7 -> buttonId=7
                R.id.button8 -> buttonId=8
                R.id.button9 -> buttonId=9

            }

            if (buttonId !=0) {
                playGame(clickedView, buttonId)

            }
        }

    }
    private fun playGame(clickedView: Button, buttonId: Int) {
        if (activePlayer==1) {
            clickedView.text="X"
            clickedView.setBackgroundColor(Color.RED)
            firstPlayer.add(buttonId)
            activePlayer=2
            movement+=1

        } else {
            clickedView.text="O"
            clickedView.setBackgroundColor(Color.GREEN)
            secondPlayer.add(buttonId)
            activePlayer=1
            movement+=1

        }
        clickedView.isEnabled=false
        check()
    }
    private fun check() {


        if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)) {
            winnerPlayer = 1

        }
        if (secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)) {
            winnerPlayer=2
        }
        if (firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)) {
            winnerPlayer = 1

        }
        if (secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)) {
            winnerPlayer=2
        }
        if (firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)) {
            winnerPlayer = 1

        }
        if (secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)) {
            winnerPlayer=2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)) {
            winnerPlayer = 1

        }
        if (secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7)) {
            winnerPlayer=2
        }
        if (firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)) {
            winnerPlayer = 1

        }
        if (secondPlayer.contains(2) && secondPlayer.contains(5) && secondPlayer.contains(8)) {
            winnerPlayer=2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)) {
            winnerPlayer = 1

        }
        if (secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)) {
            winnerPlayer=2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)) {
            winnerPlayer = 1

        }
        if (secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)) {
            winnerPlayer=2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7)) {
            winnerPlayer = 1

        }
        if (secondPlayer.contains(3) && secondPlayer.contains(5) && secondPlayer.contains(7)) {
            winnerPlayer=2
        }
        if (movement==9 && winnerPlayer!=1 && winnerPlayer!=2) {
            winnerPlayer==3
        }

        if (winnerPlayer !=0) {
            if (winnerPlayer == 1) {
                Toast.makeText(this, "X-მა მოიგო!", Toast.LENGTH_LONG).show()


            }
            if (winnerPlayer==3) {
                Toast.makeText(this, "ყაიმიაა", Toast.LENGTH_LONG).show()

            }
            else {
                Toast.makeText(this, "O-მა მოიგო!", Toast.LENGTH_LONG).show()

            }
            disableButton()



        }


    }
     private fun disableButton() {
        if (winnerPlayer==1 || winnerPlayer==2) {

            button1.isEnabled=false
            button2.isEnabled=false
            button3.isEnabled=false
            button4.isEnabled=false
            button5.isEnabled=false
            button6.isEnabled=false
            button7.isEnabled=false
            button8.isEnabled=false
            button9.isEnabled=false

        }

    }
     fun resetClick(clickedView: View) {

            button1.isEnabled=true
            button2.isEnabled=true
            button3.isEnabled=true
            button4.isEnabled=true
            button5.isEnabled=true
            button6.isEnabled=true
            button7.isEnabled=true
            button8.isEnabled=true
            button9.isEnabled=true


            button1.text=""
            button2.text=""
            button3.text=""
            button4.text=""
            button5.text=""
            button6.text=""
            button7.text=""
            button8.text=""
            button9.text=""

            button1.setBackgroundColor(Color.GRAY)
            button2.setBackgroundColor(Color.GRAY)
            button3.setBackgroundColor(Color.GRAY)
            button4.setBackgroundColor(Color.GRAY)
            button5.setBackgroundColor(Color.GRAY)
            button6.setBackgroundColor(Color.GRAY)
            button7.setBackgroundColor(Color.GRAY)
            button8.setBackgroundColor(Color.GRAY)
            button9.setBackgroundColor(Color.GRAY)

            winnerPlayer=0
            activePlayer=1

            firstPlayer.clear()
            secondPlayer.clear()


        }


    }












