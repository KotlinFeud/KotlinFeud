package com.example.kotlinfeud.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Game::class,Player::class], version = 1)
abstract class GameDatabase: RoomDatabase() {
    lateinit var gameDao:GameDao
}