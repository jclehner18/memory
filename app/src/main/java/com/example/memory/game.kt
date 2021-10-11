package com.example.memory


import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.util.*
import kotlin.system.exitProcess
import com.example.memory.R.drawable.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_game.*

@SuppressLint("SetTextI18n")
class game : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val End=findViewById<Button>(R.id.end)
        End.setOnClickListener(this)

        val images: MutableList<Int> = mutableListOf(sigma, dchi, ford, furth, kappa, sponsel, taylor, tke) //add tke image
        val buttons = arrayOf(b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16)

        val card = trine //import trine logo
        var clicked = 0
        var flip = false
        var checked = -1
        images.shuffle()
        for(i in 0..15)
        {
            buttons[i].setBackgroundResource(card)
            buttons[i].text = " "
            buttons[i].setOnClickListener{
                if(buttons[i].text == " " && !flip)
                {
                    buttons[i].setBackgroundResource(images[i])
                    buttons[i].setText(images[i])
                    if(clicked == 0)
                    {
                        checked = i
                    }
                    clicked++
                }
                else if(buttons[i].text !in "card")
                {
                    buttons[i].setBackgroundResource(card)
                    buttons[i].text=" "
                    clicked--
                }
                if (clicked == 2)
                {
                    flip = true
                    if(buttons[i].text == buttons[checked].text)
                    {
                        buttons[i].isClickable = false
                        buttons[checked].isClickable = false
                        flip = false
                        clicked = 0
                    }
                }
                else if (clicked ==0)
                {
                    flip = false
                }
            }
        }
    }

    override fun onClick(v:View)
    {

        when(v.id)
        {
            R.id.end ->
            {
                this@game.finish()
                exitProcess(0)
            }
        }
    }
}