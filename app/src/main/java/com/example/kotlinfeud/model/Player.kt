package com.example.kotlinfeud.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Player(
    @PrimaryKey
    var id:Int,
    var name:String,
    var highscore:Int
)