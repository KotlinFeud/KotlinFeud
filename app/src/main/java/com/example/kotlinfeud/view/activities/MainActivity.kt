package com.example.kotlinfeud.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ReportFragment
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import com.example.kotlinfeud.R
import com.example.kotlinfeud.view.fragments.GameOverFragment
import com.example.kotlinfeud.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         viewModel = ViewModelProviders.of(this)
           .get(MainViewModel::class.java)


    }

}



