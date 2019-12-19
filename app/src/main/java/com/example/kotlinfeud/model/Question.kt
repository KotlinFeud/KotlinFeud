package com.example.kotlinfeud.model

<<<<<<< HEAD:app/src/main/java/com/example/kotlinfeud/model/Questions.kt
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.kotlinfeud.R
import java.time.Instant
import java.util.zip.Inflater

class Questions: Fragment() (
=======
class Question (
>>>>>>> master:app/src/main/java/com/example/kotlinfeud/model/Question.kt
    var questionText: String,
    var answerA: String?,
    var answerB: String?,
    var answerC: String?,
    var answerD: String?,
<<<<<<< HEAD:app/src/main/java/com/example/kotlinfeud/model/Questions.kt
    var correctAns: String = ""


private var questionIndex = 0
// private val numQuestions = Math.min(((questionText.size + 1)) / 2,3)

override fun onCreateView(inflater: LayoutInflater,container: ViewGroup),
            savedInstant: Bundle?): View? {

    val binding = DataBindingUtil.inflate<FragmentGameBinding>(
            inflater, R.layout.question,container,false)

    // Shuffles the questions and sets the question index to the first question
    randomizeQuestions()

    // Bind this fragment class to the layout
    binding.Questions = this


}

)
=======
    var correctAns: String
){
    fun checkAnswer(ans:String):Boolean{
        return correctAns == ans
    }
}
>>>>>>> master:app/src/main/java/com/example/kotlinfeud/model/Question.kt
