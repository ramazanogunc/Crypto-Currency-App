package com.ramo.cryptocurrency.core.ext

import java.text.NumberFormat
import java.util.*


fun Double.toCurrencyString(currency: Currency): String {
    val format: NumberFormat = NumberFormat.getCurrencyInstance()
    format.currency = currency
    return format.format(this)
}