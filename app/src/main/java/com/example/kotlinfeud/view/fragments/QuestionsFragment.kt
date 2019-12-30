package com.example.kotlinfeud.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
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

    //delcare animation
    lateinit var stb: Animation
    lateinit var ltr: Animation
    lateinit var ltr2: Animation
    lateinit var ltr3: Animation
    lateinit var ltr4: Animation

    //the View
    lateinit var theView: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        theView = inflater.inflate(R.layout.question, container, false)

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


        setAnim(theView)



        return theView
    }

    private fun setAnim(theView: View) {
        //delcare animation
        stb = AnimationUtils.loadAnimation(context, R.anim.stb)
        ltr = AnimationUtils.loadAnimation(context, R.anim.ltr)
        ltr2 = AnimationUtils.loadAnimation(context, R.anim.ltr2)
        ltr3 = AnimationUtils.loadAnimation(context, R.anim.ltr3)
        ltr4 = AnimationUtils.loadAnimation(context, R.anim.ltr4)

        //initialize animation
        tvQuestion = theView.findViewById<TextView>(R.id.tv_question)
        ansA = theView.findViewById<TextView>(R.id.rb_answer1)
        ansB = theView.findViewById<TextView>(R.id.rb_answer2)
        ansC = theView.findViewById<TextView>(R.id.rb_answer3)
        ansD = theView.findViewById<TextView>(R.id.rb_answer4)
        //set animation
        tvQuestion.startAnimation(stb)
        ansA.startAnimation(ltr)
        ansB.startAnimation(ltr2)
        ansC.startAnimation(ltr3)
        ansD.startAnimation(ltr4)
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
        gamecounter.text =
            """${context!!.getString(R.string.scoreText)} ${viewModel.getFinalScore()}"""
        populateQuestion(currentQuestion)


    }

    private fun populateQuestion(question: Question) {
        setAnim(theView)
        tvQuestion.text = question.questionText
        ansA.text = question.answerA
        ansB.text = question.answerB
        ansC.text = question.answerC
        ansD.text = question.answerD
    }
}
