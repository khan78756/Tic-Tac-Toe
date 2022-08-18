package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tictactoe.databinding.ActivityMain3Binding
import com.example.tictactoe.databinding.ActivityMainBinding

class MainActivity3 : AppCompatActivity() {

    private lateinit var binding: ActivityMain3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)


        //=====================================================================//


        binding.btneasy.setOnClickListener {
            Intent(this, MainActivity::class.java).also {
                startActivity(it)
            }
        }


        //======================================================================//


        binding.btnmedium.setOnClickListener {
            Intent(this, medium::class.java).also {
                startActivity(it)
            }
        }



        //===========================================================================//




        binding.btnquit.setOnClickListener {
            finish()
        }





    }

}
