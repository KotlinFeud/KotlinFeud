package com.example.kotlinfeud.viewModel

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.kotlinfeud.model.Question

class MainViewModel(application: Application) : AndroidViewModel(application) {
    val questionList: MutableLiveData<Question> = MutableLiveData()
    val currentQuestion: MutableLiveData<Question> = MutableLiveData()
    val score: MutableLiveData<Int> = MutableLiveData()


    fun startNewGame(): Question {
        score.value = 0
        populateQuestionList()
        return getNewQuestion()
    }

    private fun getNewQuestion(): Question {

        val q1= Question(
            "Who do u love?",
            "Santa Clause",
            "Easter Bunny",
            "Anyone who feeds me",
            "Not a soul in the world",
            "Not a soul in the world")



        return q1
    }


    fun populateQuestionList(): List<View> {

        return listOf()
    }

}