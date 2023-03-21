package com.example.codemath_currencyconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.codemath_currencyconverter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    private val YEN_TO_USD:Double = 0.0076
    private val yen get() = binding.userYen.text.toString().toDouble()
    private val withdrawFee get() =binding.userWithdrawFee.text.toString().toDouble()

    private val atmFee get() = binding.userATMFee.text.toString().toDouble()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun calculateCost(): Double {
        val convertToUSD = yen * atmFee * YEN_TO_USD
        val total = convertToUSD + withdrawFee

        return total
    }

    fun showResult(view:  View){
        val result = calculateCost()
    }
}