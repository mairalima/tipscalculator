package com.example.gorjeta

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.CompoundButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gorjeta.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    // valor total da conta
    // numero de pessoas
    //porcentagem da gorjeta
    //10%, 15%  ou 20%
    //Calcular
    //Limpar
    //Recuperar as views do layout
    // find by view by id
    //ViewBinding

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var percentage: Int = 0
        binding.rdOptionOne.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                percentage = 10
            }
        }
        binding.rdOptionTwo.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    percentage = 15
                }
        }

        binding.rdOptionThree.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    percentage = 20
                }
        }
        binding.btnClean.setOnClickListener {
                println("Maira " + binding.tieTotal.text)
                println("Maira" + binding.tieNumPeople.text)
            }

        binding.btnDone.setOnClickListener {
                val totalTable: Float = binding.tieTotal.text.toString().toFloat()
                val nPeople: Float = binding.tieNumPeople.text.toString().toFloat()

                val totalTemp = totalTable / nPeople
                val tips = totalTemp * percentage / 100
                val totalWithTips = totalTemp + tips
                println("Maira" + totalWithTips)

            }

        }
    }

