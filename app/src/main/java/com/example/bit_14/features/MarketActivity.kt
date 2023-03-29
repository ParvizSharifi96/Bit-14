package com.example.bit_14.features

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bit_14.databinding.ActivityMarketBinding

class MarketActivity : AppCompatActivity() {
    lateinit var binding: ActivityMarketBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMarketBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.layoutToolbar.toolbar.title = "Bit-14"

    }
}