package com.example.kotlinfeud.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val theView =  inflater.inflate(R.layout.fragment_game_over,container,false)

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
        //TODO Use navigation component to go to home screen
    }

    fun startNewGame(){
        //TODO Use navigation component to go to first question
    }
}