package com.example.kotlinfeud.view.fragments

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.kotlinfeud.R
import com.example.kotlinfeud.model.Player
import com.example.kotlinfeud.view.activities.MainActivity
import com.example.kotlinfeud.viewModel.MainViewModel
import java.lang.ClassCastException

class SelectPlayerDialog : DialogFragment() {
    lateinit var viewModel: MainViewModel
    lateinit var playerList: ArrayList<Player>
    lateinit var passedContext: Context

    lateinit var listener: SelectPlayerListener

    val selectionList: ArrayList<CharSequence> = ArrayList()
    override fun onAttach(context: Context) {
        super.onAttach(context)
        passedContext = context
        try {
            listener = (context as SelectPlayerListener)
        } catch (e: ClassCastException) {
            throw  ClassCastException("$context must implement AddPlayerListener")
        }
        viewModel = (context as MainActivity).viewModel


    }

    interface SelectPlayerListener {
        fun confirmPlayer(player: Player)
        fun createNewPlayer()
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        playerList = viewModel.getAllPlayers() as ArrayList<Player>
        selectionList.add("New Player")
        playerList.forEach {
            selectionList.add(it.name)
        }

        val adapter =
            ArrayAdapter(passedContext, android.R.layout.simple_list_item_1, selectionList)

        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle(R.string.selectPlayer)
            builder.setAdapter(adapter) { dialogInterface: DialogInterface, i: Int ->
                when (i) {
                    0 -> {
                        Toast.makeText(context, "Creating new Player", Toast.LENGTH_SHORT).show()
                        listener.createNewPlayer()
                    }
                    else -> {
                        Toast.makeText(context,"${playerList[i-1].name} was chosen",Toast.LENGTH_SHORT).show()
                        listener.confirmPlayer(playerList[i-1])
                    }
                }
            }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be Null!!")
    }
}