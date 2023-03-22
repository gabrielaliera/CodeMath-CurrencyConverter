package com.example.codemath_currencyconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.codemath_currencyconverter.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val yenToUSD : Double = 132.44  // 132.44 yen to 1 USD

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            //Get user input
            val userYen = binding.userYen.text.toString().toDouble()
            val userWithdrawFee = binding.userWithdrawFee.text.toString().toDouble()
            val userAtmFee = binding.userATMFee.text.toString().toDouble()

            //Calculate total cost in USD
            val total = calculateCost(userYen, userAtmFee, userWithdrawFee)

            //Format to currency $0.00
            val currencyTotal : String = NumberFormat.getCurrencyInstance().format(total)

            //Set currency to totalCostUSD textView
            binding.totalCostUSD.text = currencyTotal
            }
        }

    private fun calculateCost(yen: Double = 0.0, atmFee: Double= 10.0, withdrawFee: Double = 5.00) : Double {
        val convertToUSD : Double = (yen + atmFee ) / yenToUSD
        return  convertToUSD + withdrawFee
    }
}