package com.example.kotlinfeud.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
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
    lateinit var score: TextView

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
        score = theView.findViewById((R.id.gamecounter))

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

        //delcare animation
        val stb = AnimationUtils.loadAnimation(context,R.anim.stb)
        val ltr = AnimationUtils.loadAnimation(context,R.anim.ltr)
        val ltr2 = AnimationUtils.loadAnimation(context,R.anim.ltr2)
        val ltr3 = AnimationUtils.loadAnimation(context,R.anim.ltr3)
        val ltr4 = AnimationUtils.loadAnimation(context,R.anim.ltr4)

        //initialize animation
        val tv_q = theView.findViewById<TextView>(R.id.tv_question)
        val ans1 = theView.findViewById<TextView>(R.id.rb_answer1)
        val ans2 = theView.findViewById<TextView>(R.id.rb_answer2)
        val ans3 = theView.findViewById<TextView>(R.id.rb_answer3)
        val ans4 = theView.findViewById<TextView>(R.id.rb_answer4)

        //set animation
        tv_q.startAnimation(stb)
        ans1.startAnimation(ltr)
        ans2.startAnimation(ltr2)
        ans3.startAnimation(ltr3)
        ans4.startAnimation(ltr4)

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
        gamecounter.text = """${context!!.getString(R.string.scoreText)} ${viewModel.getFinalScore()}"""
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
