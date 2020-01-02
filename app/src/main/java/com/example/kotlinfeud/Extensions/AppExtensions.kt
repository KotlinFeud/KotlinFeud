package com.example.kotlinfeud.Extensions

import android.widget.TextView

fun TextView.adjustToText(answerText: String) {
    when (answerText.length) {
        in 0..10 -> {
            this.textSize = 20f
        }
        in 10..20 -> {
            this.textSize = 18f
        }
        else -> {
            this.textSize = 16f
        }
    }

    this.text = answerText
}