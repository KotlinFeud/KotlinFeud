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



    //region Game play functions
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
    //endregion

    //Todo change the start game function to create a new game each time
    //Todo make a function to retrieve a list of all games played


    //region All point to the Repository functions with the same name
    //Todo make a function to make a player object
    //Todo make a function to save a player object
    //Todo make a function to edit a player object
    //Todo make a functio to delete a player object

    //Todo make a function to save a game object
    //Todo make a function to delete a game object
    //Todo make a function to pair a game object with a player object.
    //endregion
}