package com.example.kotlinfeud.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.kotlinfeud.R

class QuestionsFragment : Fragment() {

    lateinit var correctAns: String
    private var questionIndex = 0

// private val numQuestions = Math.min(((questionText.size + 1)) / 2,3)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        var theView = inflater.inflate(R.layout.question,container,false)






        // Bind this fragment class to the layout

        return theView
    }

    // Shuffles the questions and sets the question index to the first question
    //TODO("Set up the game to display the next question")
    fun setUpGame(){

    }

        fun checkAnswer(ans:String):Boolean{
            return correctAns == ans
        }
}