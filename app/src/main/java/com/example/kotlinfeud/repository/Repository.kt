package com.example.kotlinfeud.repository

import com.example.kotlinfeud.model.Question

object Repository {
    lateinit var questionlist: ArrayList<Question>
    fun getGameQuestions(): ArrayList<Question> {
        questionlist = ArrayList()

        val questionA = Question(
            "Designed to store and manage data in lifecycle, allowing data to survive configuration changes",
            "Live Data",
            "Life Cycle",
            "View Model",
            "Data Management",
            "View Model"
        )
        val questionB = Question(
            "What does MVVM Stand For?",
            "Model View View Module",
            "Module View View Module",
            "Module View View Model",
            "Model View View Model",
            "Model View View Model"
        )
        val questionC = Question(
            "What does MVP Stand for",
            "Model View Preventer",
            "Model View Presenter",
            "Model View Pretender",
            "Module View Presenter",
            "Model View Presenter"
        )
        val questionD = Question(
            "In Jetpack, which category of component is ViewModel under?",
            "Foundation",
            "UI",
            "Architecture",
            "Animation",
            "Architecture"
        )
//        val questionE = Question(
//            "",
//            "",
//            "",
//            "",
//            "",
//            ""
//        )

        questionlist.add(questionA)
        questionlist.add(questionB)
        questionlist.add(questionC)
        questionlist.add(questionD)
        return questionlist
    }

}