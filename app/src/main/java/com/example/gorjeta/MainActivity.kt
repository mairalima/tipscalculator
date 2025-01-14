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

        binding.rdOptionOne.setOnCheckedChangeListener { _, isChecked ->
            println("Maira: $isChecked")

        }

        binding.rdOptionTwo.setOnCheckedChangeListener { _, isChecked ->
            println("Maira: $isChecked")

        }

        binding.rdOptionThree.setOnCheckedChangeListener { _, isChecked ->
            println("Maira: $isChecked")

        }


        binding.btnClean.setOnClickListener {
            println("Maira " + binding.tieTotal.text)
            println("Maira" + binding.tieNumPeople.text)
        }


    }
}
