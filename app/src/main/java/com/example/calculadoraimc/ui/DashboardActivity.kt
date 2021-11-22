package com.example.calculadoraimc.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.calculadoraimc.R
import com.example.calculadoraimc.utils.calcularIdade
import com.example.primeiroapp.utils.convertBase64ToBitmap


class DashboardActivity : AppCompatActivity() {

    lateinit var tvNome: TextView
    lateinit var tvProfissao: TextView
    lateinit var tvImc: TextView
    lateinit var tvNcd: TextView
    lateinit var tvPeso: TextView
    lateinit var tvIdade: TextView
    lateinit var tvAltura: TextView
    lateinit var ivPerfil: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        supportActionBar!!.hide()

        val cvPesarAgora = findViewById<CardView>(R.id.cv_pesar)

        cvPesarAgora.setOnClickListener {
            val abrirPesagemActivity = Intent(this, PesagemActivity::class.java)
            startActivity(abrirPesagemActivity )
        }

        tvNome = findViewById(R.id.tv_nome)
        tvNcd = findViewById(R.id.tv_ncd)
        tvPeso = findViewById(R.id.tv_peso)
        tvProfissao = findViewById(R.id.tv_profissao)
        tvAltura = findViewById(R.id.tv_altura)
        tvIdade = findViewById(R.id.tv_idade)
        tvImc = findViewById(R.id.tv_imc)
        ivPerfil = findViewById(R.id.iv_foto_perfil_dashboard)

        carregarDashboard()
    }
    private fun carregarDashboard() {
        val arquivo =
            getSharedPreferences(
                "usuario", MODE_PRIVATE)

        tvNome.text = arquivo.getString("nome", "")
        tvProfissao.text = arquivo.getString("profissao", "")
        tvAltura.text = arquivo.getFloat("altura", 0.0f).toString()
        tvIdade.text = calcularIdade(arquivo.getString("dataNascimento", "")!!).toString()

        val bitmap = convertBase64ToBitmap(arquivo.getString("fotoPerfil", "")!!)
        ivPerfil.setImageBitmap(bitmap)

    }
}