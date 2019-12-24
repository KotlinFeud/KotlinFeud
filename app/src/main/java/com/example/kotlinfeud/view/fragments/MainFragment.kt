package com.example.kotlinfeud.view.fragments

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.kotlinfeud.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.startgame_activity.view.*

class MainFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        super.onCreateView(inflater, container, savedInstanceState)

        val theView = inflater.inflate(R.layout.startgame_activity, container, false)

        val startGame: Button = theView.findViewById(R.id.button_startGame)

        startGame.setOnClickListener {
            startGame()
        }
        return theView
    }

    private fun startGame() {
        val action = MainFragmentDirections.actionMainFragmentToQuestionsFragment()
        findNavController().navigate(action)
    }


}