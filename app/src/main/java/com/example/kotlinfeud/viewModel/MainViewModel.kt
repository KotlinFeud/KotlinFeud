package com.example.kotlinfeud.viewModel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.kotlinfeud.model.Game
import com.example.kotlinfeud.model.Player
import com.example.kotlinfeud.model.Question
import com.example.kotlinfeud.repository.Repository
import com.example.kotlinfeud.view.activities.MainActivity

class MainViewModel(application: Application) : AndroidViewModel(application) {
    //General game Variables
    var gameList: MutableLiveData<List<Game>> = MutableLiveData()
    var playerList: MutableLiveData<List<Player>> = MutableLiveData()
    var currentPlayer: MutableLiveData<Player> = MutableLiveData()
    var searchedPlayer: MutableLiveData<Player> = MutableLiveData()
    lateinit var currentGame: Game

    //In-game Variables
    val questionList: MutableLiveData<ArrayList<Question>> = MutableLiveData()
    val currentQuestion: MutableLiveData<Question> = MutableLiveData()
    var questionIndex = 0
    var score: MutableLiveData<Int> = MutableLiveData()
    var playerWon: Boolean = false

    fun setUpGame(context: Context) {
        setUpObservables(context)
    }

    private fun setUpObservables(context: Context) {
        questionList.value = Repository.getGameQuestions()
        Repository.getGameDao(context).getAllGamesPlayed().observe(context as MainActivity,
            Observer {
                gameList.value = it
            })
        Repository.getGameDao(context).getAllPlayers().observe(context,
            Observer {
                playerList.value = it
            })
    }


    //region Game play functions
    fun startNewGame(): Question {
        score.value = 0
        populateQuestionList()
        return getNewQuestion()
    }

    fun getNewQuestion(): Question {
        if (questionIndex >= questionList.value!!.size) {
            playerWon = true
            currentQuestion.value = Question("", "", "", "", "", "")
        } else {
            currentQuestion.value = questionList.value!![questionIndex++]
        }
        return currentQuestion.value!!
    }

    fun checkAnswer(ans: String): Boolean {
        return currentQuestion.value?.correctAns == ans
    }

    fun getFinalScore(): Int {
        return score.value!!
    }

    private fun populateQuestionList(): ArrayList<Question> {
        questionList.value = Repository.getGameQuestions()
        return questionList.value!!
    }

    fun incrementScore() {
        score.value = score.value?.plus(1)
    }
    //endregion


    //region All point to the Repository functions with the same name

    //Todo make a function to save a game object
    fun saveFinishedGame(context: Context) {
        val game = Game(currentPlayer.value!!.id, score.value!!)
        Repository.getGameDao(context).saveNewGame(game)
    }

    //Todo make a function to delete a game object
    fun removeGame(context: Context, game: Game) {
        Repository.getGameDao(context).removeGame(game)
    }
    //Todo make a function to pair a game object with a player object.


    //Complete make a function to retrieve a list of all games played -> LiveData

    fun getAllPlayers(): List<Player>? {
        return playerList.value
    }

    fun getGamesFromPlayer(context: Context, playerId: Int) {
        Repository.getGameDao(context).getGamesPlayedByPlayer(playerId)
    }

    fun getPlayerInfo(playerId: Int, context: Context): Player {

        playerList.value?.forEach {
            if (it.id == playerId) {
                searchedPlayer.value = it
            }
        }

        Repository.getGameDao(context).getPlayerData(playerId)
            .observe(context as MainActivity,
                Observer {
                    searchedPlayer.value = it
                })
        return searchedPlayer.value!!
    }

    fun setCurrentPlayer(player: Player) {
        currentPlayer.value = player
    }

    //Todo make a function to make a player object
    fun createNewPlayer(name: String): Player {
        return Player(name, 0)
    }

    //Todo make a function to save a player object
    fun saveNewPlayer(context: Context, player: Player) {
        Repository.getGameDao(context).saveNewPlayer(player)
    }

    //Todo make a function to update a player object
    fun editPlayer(context: Context, player: Player) {
        Repository.getGameDao(context).updatePlayer(player)
    }

    //Todo make a function to delete a player object
    fun removePlayer(context: Context, player: Player) {
        Repository.getGameDao(context).removePlayer(player)
    }
    //endregion
}