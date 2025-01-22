package com.example.gorjeta

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gorjeta.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var percentage: Int = 0
        var numOfPeopleSelected = 0


        binding.btnDone.setOnClickListener {
            val totalTableTemp = binding.tieTotal.text
            val numPeopleTemp = binding.tieNumPeople.text
            val percentageTemp = binding.tiePorcentagem.text

            if (totalTableTemp?.isEmpty() == true ||
                numPeopleTemp?.isEmpty() == true ||
                percentageTemp?.isEmpty() == true
                ) {
                Snackbar.make(binding.tieTotal, "Preencha todos os campos", Snackbar.LENGTH_LONG)
                    .show()

            } else {
                val totalTable: Float = totalTableTemp.toString().toFloat()
                val nPeople: Int = numPeopleTemp.toString().toInt()
                val percentage: Int =  percentageTemp.toString().toInt()
                val totalTemp = totalTable / nPeople
                val tips = totalTemp * percentage / 100
                val totalWithTips = totalTemp + tips

                val intent = Intent(this, SumaryActivity::class.java)
                intent.apply {
                    putExtra("totalTable", totalTable)
                    putExtra("nPeople", nPeople)
                    putExtra("percentage", percentage)
                    putExtra("totalAmount", totalWithTips)
                }
                clean()
                startActivity(intent)


            }

            binding.btnClean.setOnClickListener {
                clean()
            }
        }

    }

    private fun clean() {
        binding.tieTotal.setText("")


    }
}

