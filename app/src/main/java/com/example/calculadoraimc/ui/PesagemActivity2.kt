package com.example.calculadoraimc.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import com.example.calculadoraimc.R
import com.google.android.material.button.MaterialButton
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*

class PesagemActivity2 : AppCompatActivity() {
    lateinit var tvDataPesoAtual: TextView
    lateinit var etNovoPeso: EditText
    lateinit var spinnerNivel: Spinner
    lateinit var btnSalvarPeso: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesagem2)
        supportActionBar!!.hide()

        tvDataPesoAtual = findViewById(R.id.et_data_pesagem_2)
        etNovoPeso = findViewById(R.id.et_peso_pesagem_2)
        spinnerNivel = findViewById(R.id.spinner_atividade)
        btnSalvarPeso = findViewById(R.id.btn_registrar_peso)

        val date = Calendar.getInstance().time

        var dateTimeFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        tvDataPesoAtual.text = dateTimeFormat.format(date)

        btnSalvarPeso.setOnClickListener {
            Toast.makeText(this, "Peso registrado!", Toast.LENGTH_SHORT).show()

            val arquivo = getSharedPreferences("usuario", Context.MODE_PRIVATE)
            val pesagem = arquivo.getString("pesagem", "")
            val dataPesagem = arquivo.getString("data_pesagem", "")
            val nivel = arquivo.getString("nivel", "")

            val editor = arquivo.edit()
            editor.putString("pesagem", "$pesagem;${etNovoPeso.text}")
            editor.putString("data_pesagem", "$dataPesagem;${LocalDate.now()}")
            editor.putString("nivel", "$nivel;${spinnerNivel.selectedItemPosition}")
            editor.apply()
        }
    }
}