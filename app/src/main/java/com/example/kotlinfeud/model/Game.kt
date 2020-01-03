package com.example.kotlinfeud.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Game(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var playerId: Int,
    var score: Int
) {
    fun incrementScore() {
        score++
    }

    fun displayEndResult():String {
        return "Final Score: $score by player with Id = $playerId"
    }
}