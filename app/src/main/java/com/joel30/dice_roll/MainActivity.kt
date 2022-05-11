package com.joel30.dice_roll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //find the button in the layout
        val rollButton: Button = findViewById(R.id.button)
        //set onclick listener
        rollButton.setOnClickListener{rollDice()}
        //do a roll dice when the app starts
        rollDice()
    }
   // roll the dice and update the screen with a result
    private fun rollDice(){
        // creates a new dice object with 6 sides and rolls it
        val dice =Dice(6)
       val diceRoll=dice.roll()
       //find image view in the layout
       val diceImage:ImageView=findViewById(R.id.imageView)
       //determine which drawable resource id to use best on the dice roll use // using when else statement
       val drawableResource = when(diceRoll){
           1 ->R.drawable.dice_1
           2 ->R.drawable.dice_2
           3 ->R.drawable.dice_3
           4 ->R.drawable.dice_4
           5 ->R.drawable.dice_5
           else ->R.drawable.dice_6
       }
       //update the image view with the correct drawable resource id
       diceImage.setImageResource(drawableResource)
       //update the content description
       diceImage.contentDescription =diceRoll.toString()

    }
    //dice with a fixed number of sides
    class Dice(private val numSides :Int){
        fun roll():Int{
            //do a random dice roll return the result
            return(1..numSides).random()
        }
    }
}