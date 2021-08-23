package com.example.calculadoraimc

fun calcularImc(peso: Int, altura: Double) : Double {
    return  peso / (altura * altura)
}