package com.example.kotlinfeud.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Game::class,Player::class], version = 2, exportSchema = false)
abstract class GameDatabase: RoomDatabase() {
    abstract val gameDao:GameDao
}