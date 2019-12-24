package com.example.kotlinfeud.view.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.kotlinfeud.R
import kotlinx.android.synthetic.main.fragment_game_over.*
import kotlinx.android.synthetic.main.fragment_game_over.view.*

class GameOverFragment : BaseFragment() {

    companion object {
        fun newInstance(): GameOverFragment {
            return GameOverFragment()
        }
    }

    lateinit var btnNo:Button
    lateinit var btnYes:Button

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val theView =  inflater.inflate(R.layout.fragment_game_over,container,false)

        val scoreView:TextView = theView.findViewById(R.id.tv_score)
        scoreView.text = """${context!!.getString(R.string.scoreText)} ${viewModel.getFinalScore()}"""

        btnNo = theView.findViewById(R.id.btnNo)
        btnYes = theView.findViewById(R.id.btnYes)

        btnNo.setOnClickListener {
            backHome()
        }

        btnYes.setOnClickListener {
            startNewGame()
        }



        return theView
    }

    fun backHome(){
        val action = GameOverFragmentDirections.actionGameOverFragmentToMainFragment()
        findNavController().navigate(action)
    }

    fun startNewGame(){
        val action = GameOverFragmentDirections.actionGameOverFragmentToQuestionsFragment()
        findNavController().navigate(action)
    }
}