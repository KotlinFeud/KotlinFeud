package com.example.kotlinfeud.viewModel

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class MainViewModel(application: Application) :AndroidViewModel(application){
    val questionList:MutableLiveData<View> = MutableLiveData()
    val currentQuestion:MutableLiveData<View> = MutableLiveData()
    val score:MutableLiveData<Int> = MutableLiveData()


    fun startGame():String{
        score.value = 0
        populateQuestionList()
        return getNewQuestion()
    }

    private fun getNewQuestion():String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun populateQuestionList():List<View>{
        return listOf()
    }

}