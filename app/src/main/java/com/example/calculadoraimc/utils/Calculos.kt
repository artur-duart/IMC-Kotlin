package com.example.calculadoraimc.utils

fun calcularImc(peso: Int, altura: Double) : Double {
    return  peso / (altura * altura)
}