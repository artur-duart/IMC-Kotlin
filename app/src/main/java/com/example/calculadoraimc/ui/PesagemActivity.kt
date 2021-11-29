package com.example.calculadoraimc.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.calculadoraimc.R
import com.google.android.material.button.MaterialButton
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*

class PesagemActivity : AppCompatActivity() {

    lateinit var tvDataAtual: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesagem)
        supportActionBar!!.hide()

        tvDataAtual = findViewById(R.id.et_data_pesagem_2)

        val date = Calendar.getInstance().time

        var dateTimeFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        tvDataAtual.text = dateTimeFormat.format(date)

        var btnRegistrarPeso = findViewById<MaterialButton>(R.id.btn_registrar_novo_peso)

        btnRegistrarPeso.setOnClickListener {
            Toast.makeText(this, "Peso registrado!", Toast.LENGTH_SHORT).show()
        }
    }
}