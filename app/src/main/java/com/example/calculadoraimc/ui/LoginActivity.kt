package com.example.calculadoraimc.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.calculadoraimc.R
import com.google.android.material.button.MaterialButton

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar!!.hide()

        val tvCriarConta = findViewById<TextView>(R.id.text_view_criar)
        val btnEntrar = findViewById<MaterialButton>(R.id.button_entrar)

        tvCriarConta.setOnClickListener {
            val abrirSignUpActivity = Intent(this, SignUpActivity::class.java)
            startActivity(abrirSignUpActivity)
        }

        btnEntrar.setOnClickListener {
            val abrirDashboardActivity = Intent(this, DashboardActivity::class.java)
            startActivity(abrirDashboardActivity)
        }
    }
}