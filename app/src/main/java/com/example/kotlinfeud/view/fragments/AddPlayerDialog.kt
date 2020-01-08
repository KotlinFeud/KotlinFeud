package com.example.kotlinfeud.view.fragments

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.example.kotlinfeud.R
import com.example.kotlinfeud.view.activities.MainActivity
import com.example.kotlinfeud.viewModel.MainViewModel

class AddPlayerDialog : DialogFragment() {
    lateinit var viewModel: MainViewModel
    lateinit var listener: AddPlayerListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = (context as MainActivity).viewModel
        listener = context
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity.let {
            val builder = AlertDialog.Builder(it)

            val view = LayoutInflater.from(context).inflate(R.layout.new_player_name, null)
            builder.setView(view)
                .setPositiveButton("Let's Play!") { dialogInterface, i ->
                    val playerName =
                        view.findViewById<EditText>(R.id.et_playerName).text.toString()
                    val newPlayer = viewModel.createNewPlayer(playerName)
                    viewModel.saveNewPlayer(context!!, newPlayer)
                    viewModel.setCurrentPlayer(newPlayer)
                    listener.startGame()
                }

            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    interface AddPlayerListener {
        fun startGame()
    }

}