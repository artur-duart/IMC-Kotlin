package com.example.calculadoraimc.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.calculadoraimc.R
import com.example.calculadoraimc.repository.PesagemRepository
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
    lateinit var cvHistorico: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        supportActionBar!!.hide()

        val cvPesarAgora = findViewById<CardView>(R.id.cv_pesar)

        cvPesarAgora.setOnClickListener {
            val abrirPesagemActivity = Intent(this, PesagemActivity2::class.java)
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
        cvHistorico = findViewById(R.id.cv_historico)

        cvHistorico.setOnClickListener {
            // val pesagemRepository = PesagemRepository(this)
            // val listaPesagem = pesagemRepository.getListaPesagem()

            //for (p in listaPesagem) {
                //Log.i ("xpto", "${p.dataPesagem} - ${p.peso}")
            //}

            val abrirHistoricoActivity = Intent(this, HistoricoActivity::class.java)
            startActivity(abrirHistoricoActivity)
        }

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