package com.example.kotlinfeud.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinfeud.R
import com.example.kotlinfeud.Utils.inflate
import com.example.kotlinfeud.model.Game
import com.example.kotlinfeud.model.Player
import com.example.kotlinfeud.view.activities.MainActivity
import com.example.kotlinfeud.view.fragments.GameOverFragment

class LeaderboardAdapter(var gameList: List<Game>, var playerList: List<Player>) :
    RecyclerView.Adapter<LeaderboardAdapter.LeaderboardViewHolder>() {

    lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeaderboardViewHolder {
        context = parent.context
        return LeaderboardViewHolder(parent.inflate(R.layout.game_item))
    }

    override fun getItemCount(): Int = gameList.size


    override fun onBindViewHolder(holder: LeaderboardViewHolder, position: Int) =
        holder.setUpData(position)


    inner class LeaderboardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setUpData(position: Int) {
            val thisGame = gameList[position]

            val playerName: TextView = itemView.findViewById(R.id.tv_playerName)
            val playerScore: TextView = itemView.findViewById(R.id.tv_playerScore)

            val player = getPlayerFromList(thisGame.playerId)
            playerName.text = player.name
            playerScore.text = thisGame.score.toString()
        }
    }

    lateinit var player: Player
    private fun getPlayerFromList(playerId: Int): Player {
        playerList.forEach {
            if (it.id == playerId)
                player =it

        }
        /*else {
            (context as MainActivity).viewModel.getPlayerInfo(playerId, context)
        }*/

        return player
    }

    interface leaderBoardListener {
        fun loadPlayerInfo(player: Player)
    }


}

