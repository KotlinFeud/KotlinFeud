package com.example.kotlinfeud.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Game(
    var playerId: Int,
    var score: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}