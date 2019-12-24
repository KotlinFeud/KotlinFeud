package com.example.kotlinfeud.viewModel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.kotlinfeud.model.Question
import com.example.kotlinfeud.repository.Repository

class MainViewModel(application: Application) : AndroidViewModel(application) {
    val questionList: MutableLiveData<ArrayList<Question>> = MutableLiveData()
    val currentQuestion: MutableLiveData<Question> = MutableLiveData()
    var questionIndex = 0
    var score: MutableLiveData<Int> = MutableLiveData()
    var playerWon:Boolean = false


    fun startNewGame(): Question {
        score.value = 0
        populateQuestionList()
        return getNewQuestion()
    }

    fun getNewQuestion(): Question {
        if(questionIndex>= questionList.value!!.size){
            playerWon = true
            currentQuestion.value = Question("","","","","","")
        }else{
            currentQuestion.value = questionList.value!![questionIndex++]
        }
        return currentQuestion.value!!
    }

    fun checkAnswer(ans:String):Boolean{
        return currentQuestion.value?.correctAns == ans
    }

    fun getFinalScore():Int{
        return score.value!!
    }


    private fun populateQuestionList(): ArrayList<Question> {
        questionList.value = Repository.getGameQuestions()
        return questionList.value!!
    }

    fun incrementScore() {
        score.value = score.value!!.plus(1)
    }

}