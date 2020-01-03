package com.example.kotlinfeud.loaders

import android.content.Context
import androidx.loader.content.AsyncTaskLoader
import com.example.kotlinfeud.model.Game
import com.example.kotlinfeud.view.activities.MainActivity

class GameLoader(context: Context) : AsyncTaskLoader<List<Game>>(context) {

    var gameList: List<Game> = listOf()

    override fun loadInBackground(): List<Game>? {

        if (gameList.isEmpty()) {
            gameList = (context as MainActivity).viewModel.getAllGames(context)
        }
        return gameList
    }

    override fun deliverResult(data: List<Game>?) {
        if(isReset){
            return
        }

        //Hold reference to old data
        var oldGameList:List<Game>? = gameList
        val gameList = data

        if(isStarted){
            super.deliverResult(data)
        }

        if(oldGameList != data){
            oldGameList = null
        }

    }

    override fun onStartLoading() {
        forceLoad()
    }

}