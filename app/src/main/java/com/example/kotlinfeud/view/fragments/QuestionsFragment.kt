package com.example.kotlinfeud.view.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.kotlinfeud.R

class QuestionsFragment : Fragment() {

    private var questionIndex = 0
// private val numQuestions = Math.min(((questionText.size + 1)) / 2,3)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup),
    savedInstant: Bundle?): View?
    {

        val binding = DataBindingUtil.inflate<FragmentGameBinding>(
            inflater, R.layout.question, container, false
        )

        // Shuffles the questions and sets the question index to the first question
        randomizeQuestions()

        // Bind this fragment class to the layout
        binding.Questions = this


    }

    var correctAns: String
    ){
        fun checkAnswer(ans:String):Boolean{
            return correctAns == ans
        }
}