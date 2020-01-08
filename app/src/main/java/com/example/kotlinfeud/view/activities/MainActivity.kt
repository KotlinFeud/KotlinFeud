package com.example.kotlinfeud.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.kotlinfeud.R
import com.example.kotlinfeud.model.Player
import com.example.kotlinfeud.view.fragments.AddPlayerDialog
import com.example.kotlinfeud.view.fragments.SelectPlayerDialog
import com.example.kotlinfeud.view.fragments.MainFragmentDirections
import com.example.kotlinfeud.viewModel.MainViewModel

class MainActivity : AppCompatActivity(),
    SelectPlayerDialog.SelectPlayerListener,
    AddPlayerDialog.AddPlayerListener {

    private val NEW_PLAYER_TAG: String = "New Player"
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this)[MainViewModel::class.java]
        viewModel.setUpGame(this)
    }


    //Methods for selecting players
    override fun confirmPlayer(player: Player) {
        viewModel.setCurrentPlayer(player)
        startGame()
    }

    override fun createNewPlayer() {
        val addPlayerDialog = AddPlayerDialog()
        addPlayerDialog.show(supportFragmentManager,NEW_PLAYER_TAG)
    }

    override fun startGame() {
        val action = MainFragmentDirections.actionMainFragmentToQuestionsFragment()
        findNavController(R.id.nav_host_fragment).navigate(action)
    }


}



