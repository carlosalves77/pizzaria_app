package com.carlosdev.pizzariaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.carlosdev.pizzariaapp.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    supportActionBar?.hide()

    }
}