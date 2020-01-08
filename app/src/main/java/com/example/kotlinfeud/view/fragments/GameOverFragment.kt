package com.example.kotlinfeud.view.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowId
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinfeud.R
import com.example.kotlinfeud.adapters.LeaderboardAdapter
import com.example.kotlinfeud.repository.Repository

class GameOverFragment : BaseFragment() {

    companion object {
        fun newInstance(): GameOverFragment {
            return GameOverFragment()
        }
    }

    lateinit var btnNo: Button
    lateinit var btnYes: Button
    lateinit var rvLeaderboard: RecyclerView

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val theView = inflater.inflate(R.layout.fragment_game_over, container, false)
        initializeViews(theView)
        startAnimation(theView)
        return theView
    }

    private fun getPlayerInfo(playerId: Int) {
        Repository.getGameDao(context!!).getPlayerData(playerId).observe(this, Observer {
            rvLeaderboard.adapter
        })
    }


    private fun initializeViews(theView: View) {
        //initialize score
        val scoreView: TextView = theView.findViewById(R.id.tv_score)
        //declare buttons
        btnNo = theView.findViewById(R.id.btnNo)
        btnYes = theView.findViewById(R.id.btnYes)
        rvLeaderboard = theView.findViewById(R.id.rv_leaderboard)

        val itemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        rvLeaderboard.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvLeaderboard.addItemDecoration(itemDecoration)

        val leaderAdapter = LeaderboardAdapter(
            viewModel.gameList.value!!,
            viewModel.playerList.value!!
        )
        rvLeaderboard.adapter = leaderAdapter


        scoreView.text =
            """${context!!.getString(R.string.scoreText)} ${viewModel.getFinalScore()}"""
        btnNo.setOnClickListener { backHome() }
        btnYes.setOnClickListener { startNewGame() }
    }

    private fun startAnimation(theView: View) {
        //initialized animation views
        val game_over = theView.findViewById<TextView>(R.id.tvGameOver1)

        val s_core = theView.findViewById<TextView>(R.id.tv_score)
        val p_again = theView.findViewById<TextView>(R.id.tv_playAgain)

        //declare animation
        val stb = AnimationUtils.loadAnimation(context, R.anim.stb)
        val btt1 = AnimationUtils.loadAnimation(context, R.anim.btt)
        val btt2 = AnimationUtils.loadAnimation(context, R.anim.btt2)

        //set animation
        game_over.startAnimation(stb)
        s_core.startAnimation(btt1)
        p_again.startAnimation(btt2)
    }

    private fun backHome() {
        val action = GameOverFragmentDirections.actionGameOverFragmentToMainFragment()
        findNavController().navigate(action)
    }

    private fun startNewGame() {
        val action = GameOverFragmentDirections.actionGameOverFragmentToQuestionsFragment()
        findNavController().navigate(action)
    }

}