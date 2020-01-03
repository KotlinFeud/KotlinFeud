package com.example.kotlinfeud.model

data class Question(
    var questionText: String,
    var answerA: String?,
    var answerB: String?,
    var answerC: String?,
    var answerD: String?,
    var correctAns: String = ""
)