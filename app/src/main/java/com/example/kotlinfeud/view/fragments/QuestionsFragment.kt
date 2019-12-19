package com.example.kotlinfeud.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kotlinfeud.R
import kotlinx.android.synthetic.main.question.*
import kotlinx.android.synthetic.main.question.view.*

class QuestionsFragment : BaseFragment() {

    lateinit var correctAns: String
    private var questionIndex = 0

// private val numQuestions = Math.min(((questionText.size + 1)) / 2,3)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        var theView = inflater.inflate(R.layout.question, container, false)

        val question =viewModel.startNewGame()



        tv_question.text = question.questionText
        rb_answer1.text = question.answerA
        rb_answer2.text = question.answerB
        rb_answer3.text = question.answerC
        rb_answer4.text = question.answerD

        btn_submit.setOnClickListener {
            //This is what happens when the button gets clicked

        }


        return theView
    }

    // Bind this fragment class to the layout
    fun onClickButton(v: View) {
    }


    // Shuffles the questions and sets the question index to the first question
    //TODO("Set up the game to display the next question")
    fun setUpGame() {

    }

    fun checkAnswer(ans: String): Boolean {
        return correctAns == ans
    }
}