package com.example.kotlinfeud.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Player(
    var name:String,
    var highscore:Int
){
    @PrimaryKey(autoGenerate = true)
    var id:Int=0
}