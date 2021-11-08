package com.example.primeiroapp.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.ByteArrayOutputStream
import android.util.Base64
import java.util.*

fun encodeImage(bm: Bitmap): String? {
    val baos = ByteArrayOutputStream()
    bm.compress(Bitmap.CompressFormat.JPEG, 100, baos)
    val b = baos.toByteArray()
//    Base64.encodeToString(baos.toByteArray(), Base64.DEFAULT)
    return Base64.getEncoder().encodeToString(b)
}

fun convertBase64ToBitmap(base64Image: String) : Bitmap {

    val imageBytes = Base64.decode(base64Image, Base64.DEFAULT)
    return BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
}

//Preciso mudar o nome do arquivo
//Mudar o método de conversão para base64
//Mudar também o que der erro na Signup Activity