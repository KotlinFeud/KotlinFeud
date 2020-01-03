package com.example.kotlinfeud.view.fragments

import android.annotation.SuppressLint
import android.os.AsyncTask
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import androidx.loader.app.LoaderManager
import androidx.loader.content.Loader
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinfeud.R
import com.example.kotlinfeud.loaders.GameLoader

class GameOverFragment : BaseFragment(), LoaderManager.LoaderCallbacks<GameLoader> {

    companion object {
        fun newInstance(): GameOverFragment {
            return GameOverFragment()
        }
    }

    lateinit var btnNo: Button
    lateinit var btnYes: Button
    lateinit var rvLeaderboard:RecyclerView

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val theView = inflater.inflate(R.layout.fragment_game_over, container, false)

        initializeViews(theView)
        startAnimation(theView)
        fillLeaderBoard(theView)


        return theView
    }

    private fun fillLeaderBoard(theView: View) {
        //Use the game loader class to load a list of  games from database asynchronously

        val leaderBoardTask =object : AsyncTask<Unit,Unit,Unit>(){
            override fun doInBackground(vararg p0: Unit?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }

    }

    private fun initializeViews(theView: View) {
        //initialize score
        val scoreView: TextView = theView.findViewById(R.id.tv_score)
        //declare buttons
        btnNo = theView.findViewById(R.id.btnNo)
        btnYes = theView.findViewById(R.id.btnYes)


        scoreView.text =
            """${context!!.getString(R.string.scoreText)} ${viewModel.getFinalScore()}"""
        btnNo.setOnClickListener { backHome() }
        btnYes.setOnClickListener { startNewGame() }
    }

    private fun startAnimation(theView: View) {
        //initialized animation views
        val game_over = theView.findViewById<TextView>(R.id.tvGameOver1)

        val s_core = theView.findViewById<TextView>(R.id.tv_score)
        val p_again = theView.findViewById<TextView>(R.id.tv_playAgain)

        //declare animation
        val stb = AnimationUtils.loadAnimation(context, R.anim.stb)
        val btt1 = AnimationUtils.loadAnimation(context, R.anim.btt)
        val btt2 = AnimationUtils.loadAnimation(context, R.anim.btt2)

        //set animation
        game_over.startAnimation(stb)
        s_core.startAnimation(btt1)
        p_again.startAnimation(btt2)
    }

    private fun backHome() {
        val action = GameOverFragmentDirections.actionGameOverFragmentToMainFragment()
        findNavController().navigate(action)
    }

    private fun startNewGame() {
        val action = GameOverFragmentDirections.actionGameOverFragmentToQuestionsFragment()
        findNavController().navigate(action)
    }

    override fun onCreateLoader(id: Int, args: Bundle?): Loader<GameLoader> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onLoadFinished(loader: Loader<GameLoader>, data: GameLoader?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onLoaderReset(loader: Loader<GameLoader>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}