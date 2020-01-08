package com.example.kotlinfeud.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.navigation.fragment.findNavController
import com.example.kotlinfeud.Extensions.adjustToText
import com.example.kotlinfeud.R
import com.example.kotlinfeud.model.Game
import com.example.kotlinfeud.model.Question
import kotlinx.android.synthetic.main.question.*


class QuestionsFragment : BaseFragment() {

    //Game Views
    lateinit var radio: RadioButton
    lateinit var currentQuestion: Question
    lateinit var playerName: TextView
    lateinit var score: TextView

    //Question Views
    lateinit var tvQuestion: TextView
    lateinit var ansA: RadioButton
    lateinit var ansB: RadioButton
    lateinit var ansC: RadioButton
    lateinit var ansD: RadioButton

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
        score = theView.findViewById(R.id.gameScore)
        playerName = theView.findViewById(R.id.player_name)

        currentQuestion = viewModel.startNewGame()
        playerName.text = getString(R.string.name) + viewModel.currentPlayer.value?.name
        score.text = getString(R.string.scoreText) + viewModel.score.value.toString()
        populateQuestion(currentQuestion)

        radio = ansA
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            radio = theView.findViewById(checkedId)
        }
        btnSubmit.setOnClickListener {
            val selectedText: String = radio.text.toString()
            val answerIsCorrect = viewModel.checkAnswer(selectedText)
            if (answerIsCorrect) {
                Toast.makeText(context, "Correct!!!", Toast.LENGTH_SHORT).show()
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
        tvQuestion = theView.findViewById(R.id.tv_question)
        ansA = theView.findViewById(R.id.rb_answer1)
        ansB = theView.findViewById(R.id.rb_answer2)
        ansC = theView.findViewById(R.id.rb_answer3)
        ansD = theView.findViewById(R.id.rb_answer4)
        //set animation
        tvQuestion.startAnimation(stb)
        ansA.startAnimation(ltr)
        ansB.startAnimation(ltr2)
        ansC.startAnimation(ltr3)
        ansD.startAnimation(ltr4)
    }

    private fun gameOver() {
        viewModel.saveFinishedGame(context!!)
        val action = QuestionsFragmentDirections.actionQuestionsFragmentToGameOverFragment()
        findNavController().navigate(action)
    }

    private fun nextQuestion() {
        viewModel.incrementScore()
        currentQuestion = viewModel.getNewQuestion()
        if (viewModel.playerWon) {
            gameOver()
        }
        score.text = """${context!!.getString(R.string.scoreText)} ${viewModel.score.value}"""
        populateQuestion(currentQuestion)

    }


    private fun populateQuestion(question: Question) {
        setAnim(theView)
        tvQuestion.adjustToText(question.questionText)
        ansA.adjustToText(question.answerA!!)
        ansB.adjustToText(question.answerB!!)
        ansC.adjustToText(question.answerC!!)
        ansD.adjustToText(question.answerD!!)
    }
}
