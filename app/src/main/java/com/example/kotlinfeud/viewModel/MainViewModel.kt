package com.example.kotlinfeud.viewModel

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.kotlinfeud.model.Questions

class MainViewModel(application: Application) :AndroidViewModel(application){
    val questionList:MutableLiveData<Questions> = MutableLiveData()
    val currentQuestion:MutableLiveData<Questions> = MutableLiveData()
    val score:MutableLiveData<Int> = MutableLiveData()


    fun startGame():Questions{
        score.value = 0
        populateQuestionList()
        return getNewQuestion()
    }

    private fun getNewQuestion():Questions {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun populateQuestionList():List<View>{
        return listOf()
    }

}