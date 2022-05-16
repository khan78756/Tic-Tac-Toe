package com.example.tictactoe

import android.content.DialogInterface
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.annotation.IntegerRes
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity(), View.OnClickListener
{
    lateinit var b1:Button
    lateinit var b2:Button
    lateinit var b3:Button
    lateinit var b4:Button
    lateinit var b5:Button
    lateinit var b6:Button
    lateinit var b7:Button
    lateinit var b8:Button
    lateinit var b9:Button
    lateinit var screen:TextView
    lateinit var turnX:TextView

    //For Locking of the Buttons

    lateinit var fillpos:IntArray


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
        setContentView(R.layout.activity_main)

        //for get Id
        b1=findViewById(R.id.b1)
        b2=findViewById(R.id.b2)
        b3=findViewById(R.id.b3)
        b4=findViewById(R.id.b4)
        b5=findViewById(R.id.b5)
        b6=findViewById(R.id.b6)
        b7=findViewById(R.id.b7)
        b8=findViewById(R.id.b8)
        b9=findViewById(R.id.b9)
        screen=findViewById(R.id.screen)
        turnX=findViewById(R.id.turnX)

        turnX.setTextColor(Color.GREEN)
        screen.setTextColor(Color.MAGENTA)
        //Clicklisner

        fillpos= intArrayOf(-1,-1,-1,-1,-1,-1,-1,-1,-1)

        b1.setOnClickListener(this)
        b2.setOnClickListener(this)
        b3.setOnClickListener(this)
        b4.setOnClickListener(this)
        b5.setOnClickListener(this)
        b6.setOnClickListener(this)
        b7.setOnClickListener(this)
        b8.setOnClickListener(this)
        b9.setOnClickListener(this)
    }

    //Funtion For functionalities


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onClick(v: View?)

    {
        if (!gameactive)
            return

        var buttonclicked = findViewById<Button>(v!!.id)
        var clicktag = Integer.parseInt(buttonclicked.tag.toString())
        if (fillpos[clicktag] != -1)
            return
        fillpos[clicktag] = activeplayer

        if (activeplayer == player1)
        {
            buttonclicked.setText("0")
            activeplayer = player2

            screen.setText("Player-2 Turn")
            buttonclicked.setTextColor(Color.MAGENTA)

        } else
        {
            buttonclicked.setText("x")
            activeplayer = player1
            screen.setText("Player-1 Turn")
            buttonclicked.setTextColor(Color.MAGENTA)

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
                if (fillpos[v1] == fillpos[v2] && fillpos[v1] == fillpos[v3]) {
                    if (fillpos[v1] != -1)
                    // gameactive=false
                    {
                        if (fillpos[v1] == player1) {
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
            for (i in 0 until fillpos.size)
                if(fillpos[i]==-1)
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

    private fun restartgame() {
      fillpos=intArrayOf(-1,-1,-1,-1,-1,-1,-1,-1,-1)
        activeplayer=player1
        gameactive=true
           screen.setText("Player-1 Turn")
           b1.setText("")
           b2.setText("")
           b3.setText("")
           b4.setText("")
           b5.setText("")
           b6.setText("")
           b7.setText("")
           b8.setText("")
           b9.setText("")
    }

}