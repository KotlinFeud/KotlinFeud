package com.example.kotlinfeud.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.fragment.findNavController
import com.example.kotlinfeud.R
import com.example.kotlinfeud.model.Question
import kotlinx.android.synthetic.main.question.*


class QuestionsFragment : BaseFragment() {

    lateinit var radio: RadioButton
    lateinit var currentQuestion: Question

    //Question Views
    lateinit var tvQuestion: TextView
    lateinit var ansA: TextView
    lateinit var ansB: TextView
    lateinit var ansC: TextView
    lateinit var ansD: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val theView = inflater.inflate(R.layout.question, container, false)

        val radioGroup: RadioGroup = theView.findViewById(R.id.radio_g)
        val btnSubmit: Button = theView.findViewById(R.id.btn_submit)

        tvQuestion = theView.findViewById(R.id.tv_question)
        ansA = theView.findViewById(R.id.rb_answer1)
        ansB = theView.findViewById(R.id.rb_answer2)
        ansC = theView.findViewById(R.id.rb_answer3)
        ansD = theView.findViewById(R.id.rb_answer4)

        currentQuestion = viewModel.startNewGame()
        populateQuestion(currentQuestion)

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            radio = theView.findViewById(checkedId)
        }
        btnSubmit.setOnClickListener {
            val selectedText: String = radio.text.toString()
            val answerIsCorrect = viewModel.checkAnswer(selectedText)
            if (answerIsCorrect) {
                Toast.makeText(context, "Correct!!!", Toast.LENGTH_SHORT).show()
                viewModel.incrementScore()
                nextQuestion()
            } else {
                gameOver()
            }
        }
        return theView
    }

    private fun gameOver() {
        val action = QuestionsFragmentDirections.actionQuestionsFragmentToGameOverFragment()
        findNavController().navigate(action)
    }

    private fun nextQuestion() {
        currentQuestion = viewModel.getNewQuestion()
        if (viewModel.playerWon) {
            gameOver()
        }
        populateQuestion(currentQuestion)
    }

    private fun populateQuestion(question: Question) {
        tvQuestion.text = question.questionText
        ansA.text = question.answerA
        ansB.text = question.answerB
        ansC.text = question.answerC
        ansD.text = question.answerD
    }
}
