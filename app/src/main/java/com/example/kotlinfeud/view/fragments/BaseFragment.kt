package com.example.kotlinfeud.view.fragments

import android.content.Context
import androidx.fragment.app.Fragment
import com.example.kotlinfeud.view.activities.MainActivity
import com.example.kotlinfeud.viewModel.MainViewModel

open class BaseFragment : Fragment() {

    lateinit var viewModel: MainViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = (context as MainActivity).viewModel
    }
}