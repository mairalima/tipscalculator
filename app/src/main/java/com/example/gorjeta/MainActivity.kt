package com.example.gorjeta

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnClean: Button = findViewById(R.id.btn_clean)
        val btnDone: Button = findViewById(R.id.btn_done)
        val edtTotal: TextInputEditText = findViewById(R.id.tie_total)
        val edtNumPeople: TextInputEditText = findViewById(R.id.tie_num_people)

        btnClean.setOnClickListener {
            println("Maira " + edtTotal.text)
            println("Maira" + edtNumPeople.text)
        }


    }
}
