package com.example.currencyexchanage.utils

import java.text.DecimalFormat

class HelperMethods {
    companion object{
        fun roundTwoDecimals(d: Double): Double {
            val twoDForm = DecimalFormat("#.##")
            return twoDForm.format(d).toDouble()
        }
    }
}