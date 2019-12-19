package com.example.kotlinfeud.viewModel

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.kotlinfeud.model.Question
import com.example.kotlinfeud.repository.Repository

class MainViewModel(application: Application) : AndroidViewModel(application) {
    val questionList: MutableLiveData<ArrayList<Question>> = MutableLiveData()
    val currentQuestion: MutableLiveData<Question> = MutableLiveData()
    val questionIndex = 0
    var score: MutableLiveData<Int> = MutableLiveData()


    fun startNewGame(): Question {
        score.value = 0
        populateQuestionList()
        return getNewQuestion()
    }

    private fun getNewQuestion(): Question {
        val question = questionList.value!![questionIndex]
        return question
    }

    fun checkAnswer(ans:String):Boolean{
        if(currentQuestion.value?.correctAns == ans){
            score.value!!+ 1
            return true
        }else{
            return false
        }
    }


    private fun populateQuestionList(): ArrayList<Question> {
        questionList.value = Repository.getGameQuestions()
        return questionList.value!!
    }

}