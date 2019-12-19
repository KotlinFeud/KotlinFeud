package com.example.kotlinfeud.model

class Question (
    var questionText: String,
    var answerA: String?,
    var answerB: String?,
    var answerC: String?,
    var answerD: String?,
    var correctAns: String
){
    fun checkAnswer(ans:String):Boolean{
        return correctAns == ans
    }
}
