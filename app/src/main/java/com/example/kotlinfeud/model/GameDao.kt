package com.example.kotlinfeud.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*

@Dao
interface GameDao {
    @Query("Select * from Game order by score desc")
    fun getAllGamesPlayed(): LiveData<List<Game>>

    @Query("Select * from Game where playerId = :targetPlayer")
    fun getGamesPlayedByPlayer(targetPlayer: Int): LiveData<List<Game>>

    @Query("Select * from Player where id = :playerId")
    fun getPlayerData(playerId: Int): LiveData<Player>

    @Query("Select * from Player")
    fun getAllPlayers(): LiveData<List<Player>>

    @Insert
    fun saveNewGame(newGame: Game)

    @Insert
    fun saveNewPlayer(player: Player)

    @Update
    fun updatePlayer(player: Player)

    @Delete
    fun removeGame(game: Game)

    @Delete
    fun removePlayer(player: Player)


}