package com.example.kotlinfeud.model

import androidx.room.*

@Dao
interface GameDao {
    @Query("Select * from Game order by score desc")
    fun getAllGamesPlayed():List<Game>

    @Query("Select * from Game where playerId = :targetPlayer")
    fun getGamesPlayedByPlayer(targetPlayer:Int):List<Game>

    @Query("Select * from Player where id = :playerId")
    fun getPlayerData(playerId:Int):Player

    @Insert
    fun saveNewGame(newGame:Game)

    @Insert
    fun saveNewPlayer(player: Player)

    @Update
    fun updatePlayer(player: Player)

    @Delete
    fun removeGame(gameId:Int)

    fun removePlayer(player: Player)


}