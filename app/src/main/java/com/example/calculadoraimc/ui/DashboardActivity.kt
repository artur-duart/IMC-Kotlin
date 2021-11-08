package com.example.calculadoraimc.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.calculadoraimc.R
import com.example.primeiroapp.utils.convertBase64ToBitmap


class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        supportActionBar!!.hide()

        val cvPesarAgora = findViewById<CardView>(R.id.cv_pesar)

        cvPesarAgora.setOnClickListener {
            val abrirMainActivity = Intent(this, MainActivity::class.java)
            startActivity(abrirMainActivity )
        }

        val ivPerfil = findViewById<ImageView>(R.id.iv_foto_perfil_dashboard)
        val tvNome = findViewById<TextView>(R.id.tv_nome)
        val tvProfissao = findViewById<TextView>(R.id.tv_profissao)
        val tvImc = findViewById<TextView>(R.id.tv_imc)
        val tvNcd = findViewById<TextView>(R.id.tv_ncd)
        val tvIdade = findViewById<TextView>(R.id.tv_idade)
        val tvPeso = findViewById<TextView>(R.id.tv_peso)
        val tvAltura = findViewById<TextView>(R.id.tv_altura)

        val arquivo = getSharedPreferences("usuario", Context.MODE_PRIVATE)
        val nome = arquivo.getString("nome", "")
        val profissao = arquivo.getString("profissao", "")
        val altura = arquivo.getFloat("altura", 0.00F)
        val dtNascimento = arquivo.getString("dataNascimento", "")

        tvNome.setText(nome.toString())
        tvProfissao.setText(profissao.toString())
        tvAltura.setText(altura.toString())

//        val bitmap = convertBase64ToBitmap(arquivo.getString("fotoPerfil", ""))
//        ivPerfil.setImageBitmap(bitmap)

    }
}