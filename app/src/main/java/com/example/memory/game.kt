package com.example.memory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlin.system.exitProcess
import com.example.memory.R.drawable.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_game.*


class game : AppCompatActivity(), View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val End=findViewById<Button>(R.id.end)
        End.setOnClickListener(this)

        //list of 16 images
        val images: MutableList<Int> = mutableListOf(sigma, dchi, ford, furth, kappa, sponsel, taylor, tke, sigma, dchi, ford, furth, kappa, sponsel, taylor, tke)
        //shuffling the list of images each time the play button is hit
        images.shuffle()
        val buttons = arrayOf(b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16)

        val card = trine
        var clicked = 0
        var flip = false
        var previous = -1

        //iterate through for each button
        for(i in 0..15)
        {
            //set back of card to trine logo
            buttons[i].setImageResource(card)
            buttons[i].setTag("card")

            //set on click listener for all 16 buttons
            buttons[i].setOnClickListener{
                //sets button image to image in list when clicked
                if(buttons[i].getTag() == "card" && !flip)
                {
                    buttons[i].setImageResource(images[i])
                    buttons[i].setTag(images[i])
                    if(clicked == 0)
                    {
                        previous = i
                    }
                    clicked++
                }
                //reclick a button to set it back to trine image
                else if(buttons[i].getTag().equals(images[i]))
                {
                    buttons[i].setImageResource(card)
                    buttons[i].setTag("card")
                    clicked--
                }
                if (clicked == 2)
                {
                    flip = true
                    //if two images are equal you can no longer click them
                    if(buttons[i].getTag() == buttons[previous].getTag())
                    {
                        buttons[i].isClickable = false
                        buttons[previous].isClickable = false
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

    override fun onClick(v: View)
    {

        when(v.id)
        {
            //ends the game, takes back to main screen to play again
            R.id.end ->
            {
                this@game.finish()
                exitProcess(0)
            }
        }
    }
}