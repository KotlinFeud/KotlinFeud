package com.example.kotlinfeud.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import com.example.kotlinfeud.R

class MainFragment : BaseFragment(){

    val PLAYER_LIST_TAG = "Player List"
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        super.onCreateView(inflater, container, savedInstanceState)

        val theView = inflater.inflate(R.layout.startgame_activity, container, false)

        val startGame: Button = theView.findViewById(R.id.button_startGame)

        startGame.setOnClickListener {
            showSelectPlayerDialog()
        }

        //Declared Animation
        val ttb = AnimationUtils.loadAnimation(context,R.anim.ttb)
        val btt = AnimationUtils.loadAnimation(context,R.anim.btt)
        val btt2 = AnimationUtils.loadAnimation(context,R.anim.btt2)
        val btt3 = AnimationUtils.loadAnimation(context,R.anim.btt3)

        val h_title = theView.findViewById<TextView>(R.id.tv_kotlinFued)
        val d_descrb = theView.findViewById<TextView>(R.id.tv_descrb1)
        val d_descrb2 = theView.findViewById<TextView>(R.id.tv_descrb2)
        val d_descrb3= theView.findViewById<TextView>(R.id.tv_descrb3)

        // Set Animation

        h_title.startAnimation(ttb)
        d_descrb.startAnimation(btt)
        d_descrb2.startAnimation(btt2)
        d_descrb3.startAnimation(btt3)
        return theView
    }

    private fun showSelectPlayerDialog(){
        val selectPlayerDialog = SelectPlayerDialog()
        selectPlayerDialog.show(fragmentManager!!, PLAYER_LIST_TAG)
    }




}