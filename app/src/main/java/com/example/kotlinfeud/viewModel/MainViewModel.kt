package com.example.kotlinfeud.viewModel

import android.app.Application
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
        return questionList.value!![questionIndex]
    }

    fun checkAnswer(ans:String):Boolean{
        return if(currentQuestion.value?.correctAns == ans){
            score.value!!+ 1
            true
        }else{
            false
        }
    }


    private fun populateQuestionList(): ArrayList<Question> {
        questionList.value = Repository.getGameQuestions()
        return questionList.value!!
    }

}