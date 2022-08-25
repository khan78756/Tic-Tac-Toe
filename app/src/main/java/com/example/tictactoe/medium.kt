package com.example.tictactoe

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.tictactoe.databinding.ActivityMediumBinding

class medium : AppCompatActivity(), View.OnClickListener{

    private lateinit var binding: ActivityMediumBinding

    //For Locking of the Buttons

    lateinit var fillpos:IntArray

    //For players turns

    var player1 = 0
    var player2 = 1

    //which player turn

    var activeplayer= player1

    //for game ending after one player winning

    var gameactive= true



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMediumBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title="Medium"


        binding.btnexit.setOnClickListener {
            finish()
        }


        //Clicklisner

        fillpos= intArrayOf(-1,-1,-1,-1,-1,-1,-1,-1,-1,
                            -1,-1,-1,-1,-1,-1,-1,-1,-1,
                            -1,-1,-1,-1,-1,-1,-1,-1,-1,
                            -1,-1,-1,-1,-1,-1,-1,-1,-1)

        binding.b1.setOnClickListener(this)
        binding.b2.setOnClickListener(this)
        binding.b3.setOnClickListener(this)
        binding.b4.setOnClickListener(this)
        binding.b5.setOnClickListener(this)
        binding.b6.setOnClickListener(this)
        binding.b7.setOnClickListener(this)
        binding.b8.setOnClickListener(this)
        binding.b9.setOnClickListener(this)
        binding.b10.setOnClickListener(this)
        binding.b11.setOnClickListener(this)
        binding.b12.setOnClickListener(this)
        binding.b13.setOnClickListener(this)
        binding.b14.setOnClickListener(this)
        binding.b15.setOnClickListener(this)
        binding.b16.setOnClickListener(this)
        binding.b17.setOnClickListener(this)
        binding.b18.setOnClickListener(this)
        binding.b19.setOnClickListener(this)
        binding.b20.setOnClickListener(this)
        binding.b21.setOnClickListener(this)
        binding.b22.setOnClickListener(this)
        binding.b23.setOnClickListener(this)
        binding.b24.setOnClickListener(this)
        binding.b25.setOnClickListener(this)
        binding.b26.setOnClickListener(this)
        binding.b27.setOnClickListener(this)
        binding.b28.setOnClickListener(this)
        binding.b29.setOnClickListener(this)
        binding.b30.setOnClickListener(this)
        binding.b31.setOnClickListener(this)
        binding.b32.setOnClickListener(this)
        binding.b33.setOnClickListener(this)
        binding.b34.setOnClickListener(this)
        binding.b35.setOnClickListener(this)
        binding.b36.setOnClickListener(this)




    }

    @SuppressLint("ResourceType", "SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onClick(v: View?) {
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

            binding.screen.setText("Player-2 Turn")

        } else
        {
            buttonclicked.setText("x")
            activeplayer = player1
            binding.screen.setText("Player-1 Turn")

        }
        checkforwin()
    }

    private fun checkforwin() {
        var winpos = arrayOf(
            intArrayOf(0, 1, 2,3), intArrayOf(1,2, 3, 4), intArrayOf(2,3,4,5),
            intArrayOf(6, 7, 8,9), intArrayOf(7,8, 9, 10), intArrayOf(8,9,10,11),
            intArrayOf(12, 13, 14,15), intArrayOf(13,14, 15,16), intArrayOf(14,15,16,17),
            intArrayOf(18, 19, 20,21), intArrayOf(19,20, 21,22), intArrayOf(20,21,22,23),
            intArrayOf(24, 25, 26,27), intArrayOf(25,26, 27,28), intArrayOf(26,27,28,29),
            intArrayOf(30, 31, 32,33), intArrayOf(31,32, 33,34), intArrayOf(32,33,34,35),


            intArrayOf(0, 6, 12,18), intArrayOf(6,12, 18,24), intArrayOf(12,18,24,30),
            intArrayOf(1, 7, 13,19), intArrayOf(7,13, 19,25), intArrayOf(13,19,25,31),
            intArrayOf(2, 8, 14,20), intArrayOf(8,14, 20,26), intArrayOf(14,20,26,32),
            intArrayOf(3, 9, 15,21), intArrayOf(9,15, 21,27), intArrayOf(15,21,27,33),
            intArrayOf(4, 10, 16,22), intArrayOf(10,16, 22,28), intArrayOf(16,22,28,34),
            intArrayOf(5, 11, 17,23), intArrayOf(11,17, 23,29), intArrayOf(17,23,29,35),


            intArrayOf(12, 19, 26,33), intArrayOf(6,13, 20,27), intArrayOf(13,20,27,34),
            intArrayOf(0, 7, 14,21), intArrayOf(7,14, 21,28), intArrayOf(14,21,28,35),
            intArrayOf(1, 8, 15,22), intArrayOf(8,15, 22,29), intArrayOf(2,9,16,23),


            intArrayOf(3, 8, 13,18), intArrayOf(4,9, 14,19), intArrayOf(9,14,19,24),
            intArrayOf(5, 10, 15,20), intArrayOf(10,15,20,25), intArrayOf(15,20, 25,30),
            intArrayOf(11, 16,21,26), intArrayOf(16,21,26,31), intArrayOf(17,22, 27,32),



            intArrayOf(7, 8,9,10), intArrayOf(13,14,15,16),
            intArrayOf(19,20, 21,22),intArrayOf(25,26, 27,28),
            intArrayOf(7, 13,19,25), intArrayOf(8,14,20,26),
            intArrayOf(9,15, 21,27),intArrayOf(10,16, 22,28)

            )

        for (i in 0 until winpos.size) {
            var v1 = winpos[i][0]
            var v2 = winpos[i][1]
            var v3 = winpos[i][2]
            var v4 = winpos[i][3]
            if (fillpos[v1] == fillpos[v2] && fillpos[v1] == fillpos[v3] && fillpos[v1] == fillpos[v4] ) {
                if (fillpos[v1] != -1)
                // gameactive=false
                {
                    if (fillpos[v1] == player1) {
                        showmessage("Player-1 is winner")
                        gameactive = false
                    } else {
                        showmessage("Player-2 is winner")
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
            return

        }
    }
                      //end checkforwin function

    //Funtion For restart of the Game


    private fun showmessage(s: String)
    {
        AlertDialog.Builder(this)
            .setMessage(s)
            .setTitle("Tic Tac Toe")
            .setPositiveButton("Restart Game", DialogInterface.OnClickListener { dialog, which->
                restartgame()})
            .show()
    }

    //Funtion For restart of Game

    private fun restartgame() {
        fillpos=intArrayOf(-1,-1,-1,-1,-1,-1,-1,-1,-1,
                           -1,-1,-1,-1,-1,-1,-1,-1,-1,
                           -1,-1,-1,-1,-1,-1,-1,-1,-1,
                           -1,-1,-1,-1,-1,-1,-1,-1,-1)
        activeplayer=player1
        gameactive=true
        binding.screen.setText("Player-1 Turn")
        binding.b1.setText("")
        binding.b2.setText("")
        binding.b3.setText("")
        binding.b4.setText("")
        binding.b5.setText("")
        binding.b6.setText("")
        binding.b7.setText("")
        binding.b8.setText("")
        binding.b9.setText("")
        binding.b10.setText("")
        binding.b11.setText("")
        binding.b12.setText("")
        binding.b13.setText("")
        binding.b14.setText("")
        binding.b15.setText("")
        binding.b16.setText("")
        binding.b17.setText("")
        binding.b18.setText("")
        binding.b19.setText("")
        binding.b20.setText("")
        binding.b21.setText("")
        binding.b22.setText("")
        binding.b23.setText("")
        binding.b24.setText("")
        binding.b25.setText("")
        binding.b26.setText("")
        binding.b27.setText("")
        binding.b28.setText("")
        binding.b29.setText("")
        binding.b30.setText("")
        binding.b31.setText("")
        binding.b32.setText("")
        binding.b33.setText("")
        binding.b34.setText("")
        binding.b35.setText("")
        binding.b36.setText("")

    }
}