package com.example.gorjeta

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.CompoundButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gorjeta.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {


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

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.num_people,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        binding.spinnerNumberOfPeople.adapter = adapter

        var numOfPeopleSelected = 0
        binding.spinnerNumberOfPeople.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    numOfPeopleSelected = position
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

            }


        binding.btnDone.setOnClickListener {
            val totalTableTemp = binding.tieTotal.text


            if (totalTableTemp?.isEmpty() == true) {
                Snackbar.make(binding.tieTotal, "Preencha todos os campos", Snackbar.LENGTH_LONG)
                    .show()

            } else {
                val totalTable: Float = totalTableTemp.toString().toFloat()
                val nPeople: Int = numOfPeopleSelected


                val totalTemp = totalTable
                val tips = totalTemp * percentage / 100
                val totalWithTips = totalTemp + tips

                val intent = Intent(this, SumaryActivity::class.java)
                intent.apply {
                    putExtra("totalTable", totalTable)
                    putExtra("nPeople", numOfPeopleSelected)
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
        binding.tvResult.text = ""
        binding.tieTotal.setText("")
        binding.rdOptionOne.isChecked = false
        binding.rdOptionTwo.isChecked = false
        binding.rdOptionThree.isChecked = false

    }
}

