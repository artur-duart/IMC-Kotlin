package com.example.calculadoraimc.utils

import android.content.Context

//fun calcularImc(peso: Int, altura: Double) : Double {
//    return  peso / (altura * altura)
//}

fun calcularImc(context: Context) : Double {

    val arquivo = context.getSharedPreferences("usuario", Context.MODE_PRIVATE)

    val pesos = arquivo.getString("pesagem", "")!!.split(";").toTypedArray()

    val pesoAtual = pesos.last().toString()

    val altura = arquivo.getFloat("altura", 0.0f)

    return  (pesoAtual / (altura * altura)).toDouble()
}

fun calcularNcd(): Double {
    return 0.0
}