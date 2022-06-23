package com.ramo.cryptocurrency.core.ext

import android.annotation.SuppressLint
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
fun Date.toFormattedText(format: String): String {
    val sdf = SimpleDateFormat(format)
    return try {
        sdf.format(this)
    } catch (pe: ParseException) {
        ""
    }
}