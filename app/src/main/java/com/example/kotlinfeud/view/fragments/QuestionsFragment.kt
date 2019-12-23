package com.example.kotlinfeud.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import com.example.kotlinfeud.R
import kotlinx.android.synthetic.main.question.*


class QuestionsFragment : BaseFragment() {

    lateinit var radio: RadioButton
    lateinit var correctAns: String
    private var questionIndex = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        var theView = inflater.inflate(R.layout.question, container, false)

        val question = viewModel.startNewGame()



        tv_question.text = question.questionText
        rb_answer1.text = question.answerA
        rb_answer2.text = question.answerB
        rb_answer3.text = question.answerC
        rb_answer4.text = question.answerD

        // Get radio group selected item using on checked change Listener
        radio_group.setOnCheckedChangeListener { group, checkedId ->
            radio = theView.findViewById(checkedId)
        }

        // Get radio group selected status and text using button click event
        btn_submit.setOnClickListener {
            //This is what happens when the button gets clicked
            // Get the checked radio button id from radio group
            var selectedText: String = radio.text.toString()
            var answerIsCorrect = viewModel.checkAnswer(selectedText)
            if(answerIsCorrect)
                nextQuestion()
            else
                    gameOver()
        }


return theView
}

fun gameOver() {

}
fun nextQuestion(){

}
}
