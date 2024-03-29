package com.example.tictactoe

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.annotation.IntegerRes
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.core.view.setPadding
import com.example.tictactoe.R.drawable.tick
import com.example.tictactoe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener
{


    private lateinit var binding: ActivityMainBinding

    //For Locking of the Buttons

    lateinit var fillpos1:IntArray


    //For players turns

    var player1 = 0
    var player2 = 1

    //which player turn

    var activeplayer= player1

    //for game ending after one player winning

    var gameactive= true


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title="Easy"

        val exit=findViewById<Button>(R.id.btnexit)


        exit.setOnClickListener {
            finish()
        }

        //Clicklisner

        fillpos1= intArrayOf(-1,-1,-1,-1,-1,-1,-1,-1,-1)

        binding.b1.setOnClickListener(this)
        binding.b2.setOnClickListener(this)
        binding.b3.setOnClickListener(this)
        binding.b4.setOnClickListener(this)
        binding.b5.setOnClickListener(this)
        binding.b6.setOnClickListener(this)
        binding. b7.setOnClickListener(this)
        binding.b8.setOnClickListener(this)
        binding. b9.setOnClickListener(this)
    }

    //Funtion For functionalities


    @SuppressLint("ResourceType")
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onClick(v: View?)

    {
        if (!gameactive)
            return

        var buttonclicked = findViewById<ImageButton>(v!!.id)
        var clicktag = Integer.parseInt(buttonclicked.tag.toString())
        if (fillpos1[clicktag] != -1)
            return
        fillpos1[clicktag] = activeplayer

        if (activeplayer == player1)
        {
            buttonclicked.setImageResource(R.drawable.colorize)
            activeplayer = player2

           binding.screen.setText("Player-2 Turn")



        } else
        {

            buttonclicked.setImageResource(R.drawable.crosslast)
            activeplayer = player1
            binding.screen.setText("Player-1 Turn")


        }
        checkforwin()
    }

    //Funtion For Checking of Which Player Win


        private fun checkforwin() {
            var winpos = arrayOf(
                intArrayOf(0, 1, 2), intArrayOf(3, 4, 5), intArrayOf(6, 7, 8),
                intArrayOf(0, 3, 6), intArrayOf(1, 4, 7), intArrayOf(2, 5, 8), intArrayOf(0, 4, 8),
                intArrayOf(2, 4, 6)
            )
            for (i in 0 until winpos.size) {
                var v1 = winpos[i][0]
                var v2 = winpos[i][1]
                var v3 = winpos[i][2]
                if (fillpos1[v1] == fillpos1[v2] && fillpos1[v1] == fillpos1[v3]) {
                    if (fillpos1[v1] != -1)
                    // gameactive=false
                    {
                        if (fillpos1[v1] == player1) {
                           showmessage("Player-1 is winner")
                            //   screen.setText("p1 win")
                            gameactive = false
                        } else {
                            showmessage("Player-2 is winner")
                           // screen.setText("p2 win")
                            gameactive = false
                        }
                    return
                    }
                }
            }


         //For in case of Draw


            var count=0
            for (i in 0 until fillpos1.size)
                if(fillpos1[i]==-1)
            {
             count++
            }
            if(count==0)
            {
                showmessage("Match is Draw")
               // screen.setText("p2 win")
                return

            }


        }


       //Funtion For restart of the Game


   private fun showmessage(s: String)
    {
      AlertDialog.Builder(this)
          .setMessage(s)
          .setTitle("Tic Tac Toe")
          .setPositiveButton("Restart Game",DialogInterface.OnClickListener {dialog,which->
        restartgame()})
          .show()


    }

       //Funtion For restart of Game

    @SuppressLint("SetTextI18n")
    private fun restartgame() {
      fillpos1=intArrayOf(-1,-1,-1,-1,-1,-1,-1,-1,-1)
        activeplayer=player1
        gameactive=true
        binding.screen.setText("Player-1 Turn")
        binding.b1.setImageResource(0)
        binding.b2.setImageResource(0)
        binding.b3.setImageResource(0)
        binding.b4.setImageResource(0)
        binding. b5.setImageResource(0)
        binding. b6.setImageResource(0)
        binding. b7.setImageResource(0)
        binding.b8.setImageResource(0)
        binding. b9.setImageResource(0)

    }

}