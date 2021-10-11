package com.example.memory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView


import kotlin.system.exitProcess

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Exit=findViewById<Button>(R.id.Exit)
        Exit.setOnClickListener(this)

        val Play= findViewById<Button>(R.id.Play)
        Play.setOnClickListener{val intent = Intent(this, game::class.java)
        startActivity(intent)}

    }

    override fun onClick(v: View)
    {
        val tv=findViewById<TextView>(R.id.textView)
        when(v.id)
        {
            R.id.Exit ->
            {
                this@MainActivity.finish()
                exitProcess(0)
            }
        }
    }
}