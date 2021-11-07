package com.example.primeiroapp.utils

import android.graphics.Bitmap
import java.io.ByteArrayOutputStream
import java.util.*

fun encodeImage(bm: Bitmap): String? {
    val baos = ByteArrayOutputStream()
    bm.compress(Bitmap.CompressFormat.JPEG, 100, baos)
    val b = baos.toByteArray()
//    Base64.encodeToString(baos.toByteArray(), Base64.DEFAULT)
    return Base64.getEncoder().encodeToString(b)
}