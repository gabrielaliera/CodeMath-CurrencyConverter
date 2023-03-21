package com.example.codemath_currencyconverter

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import com.example.codemath_currencyconverter.databinding.ActivityMainBinding
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    private val yenTOusd : Double = 0.0076
   // private val userYen get() = binding.userYen.text.toString().toDouble()
   // private val userWithdrawFee get() =binding.userWithdrawFee.text.toString().toDouble()
  //  private val userAtmFee get() = binding.userATMFee.text.toString().toDouble()
    //private val yen : EditText= binding.userYen
    //private val withdrawFee : EditText = binding.userWithdrawFee
    //private val atmFee : EditText = binding.userATMFee
 // private val totalCost = binding.totalCostUSD.text.toString().toDouble()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener{
            calculateCost()
            //Log.e("Gaby","click button")
            //val currentCost = calculateCost(userYen, userWithdrawFee, userAtmFee)
           // binding.totalCostUSD.setText(currentCost.toString())
        }

      // EditText inputYen = findViewById(R.id.user_yen)

     //  val inputWithdrawFee: EditText = findViewById(R.id.user_withdraw_fee)
       //val inputATMFee: EditText = findViewById(R.id.user_ATM_fee)
     //  val totalCost : EditText= findViewById(R.id.totalCostUSD)

        //Setup the text change listener
//        binding.userYen.addTextChangedListener(object : TextWatcher {
//            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
//                // Fires right as the text is being changed (even supplies the range of text)
//            }
//
//            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
//                // Fires right before text is changing
//            }
//
//            override fun afterTextChanged(s: Editable) {
//                // Fires right after the text has changed
//                var currentCost = calculateCost();
//                binding.totalCostUSD.setText(s.toString())
//            }
//        })

    }
    private fun calculateCost(yen: Double = 0.0, atmFee: Double= 10.0, withdrawFee: Double = 5.00) {
        val userYen: Double = binding.userYen.text.toString().toDouble()
        val userWithdrawFee: Double = binding.userWithdrawFee.text.toString().toDouble()
        val userAtmFee : Double = binding.userATMFee.text.toString().toDouble()

        val convertToUSD = userYen * userAtmFee * yenTOusd
        val total = convertToUSD + userWithdrawFee
        binding.totalCostUSD.text = total.toString()
    }



}