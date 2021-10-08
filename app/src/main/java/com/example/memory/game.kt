package com.example.memory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.*
import kotlin.system.exitProcess

class game : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val End=findViewById<Button>(R.id.end)
        End.setOnClickListener(this)

        val buttons = arrayOf( //array of buttons for our 'cards'
            findViewById<Button>(R.id.b1),
            findViewById<Button>(R.id.b2),
            findViewById<Button>(R.id.b3),
            findViewById<Button>(R.id.b4),
            findViewById<Button>(R.id.b5),
            findViewById<Button>(R.id.b6),
            findViewById<Button>(R.id.b7),
            findViewById<Button>(R.id.b8),
            findViewById<Button>(R.id.b9),
            findViewById<Button>(R.id.b10),
            findViewById<Button>(R.id.b11),
            findViewById<Button>(R.id.b12),
            findViewById<Button>(R.id.b13),
            findViewById<Button>(R.id.b14),
            findViewById<Button>(R.id.b15),
            findViewById<Button>(R.id.b16)
        )
        for (button in buttons) //allows setOnClickListener for each button in the array
        {
            button.setOnClickListener(this)
        }



    }


    override fun onClick(v:View)
    {
        val tv=findViewById<TextView>(R.id.textView)
        when(v.id)
        {
            R.id.end ->
            {
                this@game.finish()
                exitProcess(0)
            }

            R.id.b1 ->
            {
                //Collections.shuffle(buttons)
            }


        }
    }


}