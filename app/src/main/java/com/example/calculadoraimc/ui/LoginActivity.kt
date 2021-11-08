package com.example.calculadoraimc.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.calculadoraimc.R
import com.example.calculadoraimc.utils.autenticar
import com.google.android.material.button.MaterialButton

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar!!.hide()

        val tvCriarConta = findViewById<TextView>(R.id.text_view_criar)
        val btnEntrar = findViewById<MaterialButton>(R.id.button_entrar)


        val etEmail = findViewById<EditText>(R.id.edit_text_email)
        val etSenha = findViewById<EditText>(R.id.edit_text_senha)

        btnEntrar.setOnClickListener {
            val autenticou = autenticar(etEmail.text.toString(), etSenha.text.toString(), this)

            if (autenticou) {
                val abrirDashboardActivity = Intent(this, DashboardActivity::class.java)
                startActivity(abrirDashboardActivity)
            } else {
                Toast.makeText(this, "Email ou Senha Incorretos!", Toast.LENGTH_SHORT).show()
            }
        }

        tvCriarConta.setOnClickListener {
            val abrirSignUpActivity = Intent(this, SignUpActivity::class.java)
            startActivity(abrirSignUpActivity)
        }
        
    }
}