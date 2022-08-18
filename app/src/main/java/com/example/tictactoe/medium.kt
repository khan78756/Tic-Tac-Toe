package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.tictactoe.databinding.ActivityMediumBinding

class medium : AppCompatActivity() {

    private lateinit var binding: ActivityMediumBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMediumBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title="Medium"


        binding.btnexit.setOnClickListener {
            finish()
        }



    }
}