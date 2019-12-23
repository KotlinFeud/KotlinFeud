package com.example.kotlinfeud.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import com.example.kotlinfeud.R
import com.example.kotlinfeud.model.Question
import kotlinx.android.synthetic.main.question.*


class QuestionsFragment : BaseFragment() {

    lateinit var radio: RadioButton
    lateinit var currentQuestion: Question

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val theView = inflater.inflate(R.layout.question, container, false)

        currentQuestion = viewModel.startNewGame()
        populateQuestion(currentQuestion)

        radio_group.setOnCheckedChangeListener { group, checkedId ->
            radio = theView.findViewById(checkedId)
        }
        btn_submit.setOnClickListener {
            //This is what happens when the button gets clicked
            // Get the checked radio button id from radio group
            val selectedText: String = radio.text.toString()
            val answerIsCorrect = viewModel.checkAnswer(selectedText)
            if (answerIsCorrect)
                nextQuestion()
            else
                gameOver()
        }

        
        return theView
    }

    private fun gameOver() {

    }

    private fun nextQuestion() {
        currentQuestion = viewModel.getNewQuestion()
        populateQuestion(currentQuestion)
    }
    private fun populateQuestion(question: Question) {
        tv_question.text = question.questionText
        rb_answer1.text = question.answerA
        rb_answer2.text = question.answerB
        rb_answer3.text = question.answerC
        rb_answer4.text = question.answerD
    }
}
