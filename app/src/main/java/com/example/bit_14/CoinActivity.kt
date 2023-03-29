package com.example.bit_14

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bit_14.databinding.ActivityCoinBinding
import com.example.bit_14.databinding.ActivityMainBinding

class CoinActivity : AppCompatActivity() {
    lateinit var binding: ActivityCoinBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCoinBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}