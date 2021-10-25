package com.example.calculadoraimc.ui

import android.app.DatePickerDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.example.calculadoraimc.R
import com.example.calculadoraimc.model.Usuario
import com.example.calculadoraimc.utils.convertStringToLocalDate
import java.time.LocalDate
import java.util.*

class SignUpActivity : AppCompatActivity() {

    lateinit var editEmail: EditText
    lateinit var editSenha: EditText
    lateinit var editNome: EditText
    lateinit var editProfissao: EditText
    lateinit var editAltura: EditText
    lateinit var editDataNascimento : EditText
    lateinit var radioGroupSexo : RadioGroup
    lateinit var radioButtonFem : RadioButton
    lateinit var radioButtonMasc : RadioButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        supportActionBar!!.title = "Perfil"

        editEmail = findViewById(R.id.et_email)
        editSenha = findViewById(R.id.et_senha)
        editNome = findViewById(R.id.et_nome)
        editProfissao = findViewById(R.id.et_profissao)
        editAltura = findViewById(R.id.et_altura)
        editDataNascimento = findViewById(R.id.et_data)
        radioGroupSexo = findViewById<RadioGroup>(R.id.rg_sexo)
        radioButtonFem = findViewById<RadioButton>(R.id.rb_feminino)
        radioButtonMasc = findViewById<RadioButton>(R.id.rb_masculino)

        // Criando um calendário
        val calendario = Calendar.getInstance()

        // Determinando os dados (dia, mês e ano) do calendário
        val ano = calendario.get(Calendar.YEAR)
        val mes = calendario.get(Calendar.MONTH)
        val dia = calendario.get(Calendar.DAY_OF_MONTH)

        // Abrindo o componente DatePicker
        val etDataNascimento = findViewById<EditText>(R.id.et_data)

        etDataNascimento.setOnClickListener {
            val dp = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, _ano, _mes, _dia ->
                etDataNascimento.setText("$_dia/${_mes + 1}/$_ano")
            }, ano, mes, dia)

            dp.show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        if(validarCampos()) {
            // Criar o objeto usuario
            val nascimento = convertStringToLocalDate(editDataNascimento.text.toString())

            val usuario = Usuario(
                1,
                editNome.text.toString(),
                editEmail.text.toString(),
                editSenha.text.toString(),
                0,
                editAltura.text.toString().toDouble(),
                LocalDate.of(
                    nascimento.year,
                    nascimento.monthValue,
                    nascimento.dayOfMonth
                ),
                editProfissao.text.toString(),
                if (radioButtonFem.isChecked){
                    'F'
                } else {
                    'M'
                }
            )

            // Salvar o registro
            // em um SharedPreferences.

            // A instrução abaixo irá criar um
            // arquivo SharedPreferences se não existir.
            // Se existir, ele será aberto para edição.

            val dados = getSharedPreferences("usuario", Context.MODE_PRIVATE)

            // Vamos criar o objeto que permitirá a
            // edição dos dados do arquivo SharedPreferences

            val editor = dados.edit()
            editor.putInt("id", usuario.id)
            editor.putString("nome", usuario.nome)
            editor.putString("email", usuario.email)
            editor.putString("senha", usuario.senha)
            editor.putInt("peso", usuario.peso)
            editor.putFloat("altura", usuario.altura.toFloat())
            editor.putString("dataNascimento", usuario.dataNascimento.toString())
            editor.putString("profissao", usuario.profissao)
            editor.putString("sexo", usuario.sexo.toString())
            editor.apply()
        }

        Toast.makeText(this, "Usuário cadastrado!", Toast.LENGTH_SHORT).show()
        
        return true;
    }

    fun validarCampos() : Boolean
    {
        var validos = true

        if (editEmail.text.isEmpty())
        {
            editEmail.error = "O Email é obrigatório"
            validos = false
        }
        if (editSenha.text.isEmpty())
        {
            editSenha.error = "A Senha é obrigatória"
            validos = false
        }
        if (editNome.text.isEmpty())
        {
            editNome.error = "O Nome é obrigatório"
            validos = false
        }
        if (editAltura.text.isEmpty())
        {
            editAltura.error = "A Altura é obrigatória"
            validos = false
        }
        if (editProfissao.text.isEmpty())
        {
            editProfissao.error = "A Profissão é obrigatória"
            validos = false
        }
        if (editDataNascimento.text.isEmpty())
        {
            editDataNascimento.error = "A Data de nascimento é obrigatória"
            validos = false
        }
        if (!radioButtonFem.isChecked && !radioButtonMasc.isChecked)
        {
            Toast.makeText(this, "Escolha uma opção", Toast.LENGTH_SHORT).show()
            validos = false
        }


        return validos
    }
}