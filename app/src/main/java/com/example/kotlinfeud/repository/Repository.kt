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
<<<<<<< HEAD
//        val questionE = Question(
//            "",
//            "",
//            "",
//            "",
//            "",
//            ""
//        )
=======
        val questionE = Question(
            "What does 'SDK' stand for?",
            "Standard Development Kit",
            "Software Development Kit",
            "Standard Device Kit",
            "Software Device Kit",
            "Software Development Kit"

        )
        val questionF = Question(
            "What testing framework do you use to test UI?",
            "Expresso",
            "Latte",
            "Mockito",
            "Mimosa",
            "Expresso"

        )
        val questionG = Question(
            "What testing framework do you use to test logic?",
            "Expresso",
            "Latte",
            "Mockito",
            "Mimosa",
            "Mockito"
        )
        val questionH= Question(
            "What testing framework do you use to test logic?",
            "Expresso",
            "Latte",
            "Mockito",
            "Mimosa",
            "Mockito"
        )
        val questionI= Question(
            "How many different stages of activity lifecycle?",
            "5",
            "6",
            "7",
            "8",
            "7"
        )
        val questionJ= Question(
            "How many different types of intents are there?",
            "1",
            "2",
            "3",
            "4",
            "2"
        )
        val questionK= Question(
            " Is a support library that allows you to bind UI components in your layouts to data sources in your app?",
            "Retrofit",
            "RxJava",
            "Data Binding",
            "UI Binding",
            "Data Binding"
        )
        val questionL= Question(
            " Is a support library that allows you to bind UI components in your layouts to data sources in your app?",
            "Retrofit",
            "RxJava",
            "Data Binding",
            "UI Binding",
            "Data Binding"
        )
        val questionM= Question(
            "Var is what?",
            "Immutable",
            "Static",
            "Nullable",
            "Mutable",
            "Mutable"
        )
        val questionN= Question(
            "Val is what?",
            "Immutable",
            "Static",
            "Nullable",
            "Mutable",
            "Immutable"
        )
        val questionO= Question(
            "Kotlin is developed by?",
            "Google",
            "Jetbrains",
            "Microsoft",
            "Adobe",
            "Jetbrains"
        )
        val questionP= Question(
            "Which of the following is used to handle null exceptions in Kotlin?",
            "Range",
            "Sealed Class",
            "Elvis Operator",
            "Lambda function",
            "Elvis Operator"
        )
        val questionQ= Question(
            "Which file extension is used to save Kotlin files?",
            ".java",
            ".kot",
            ".kt or .kts",
            ".android",
            ".kt or kts"
        )
        val questionR= Question(
            "All classes in Kotlin classes are by default?",
            "public",
            "final",
            "sealed",
            "sealed",
            "final"
        )
        val questionS= Question(
            "All classes in Kotlin classes are by default?",
            "public",
            "final",
            "sealed",
            "sealed",
            "final"
        )
        val questionT= Question(
            "Which keyword is used by classes to implement an interface?",
            "import",
            "implements",
            "instance of",
            "abstract",
            "implements"
        )
        val questionU= Question(
            "Which method is used in thread class to start the execution of the thread?",
            "public void start()",
            "public void run()",
            "public void execute()",
            "public void launch()",
            "public void ()"
        )
        val questionV= Question(
            "Which class cannot be instantiated?",
            "Abstract class",
            "Static class",
            "Both A&B",
            "None of the above",
            "Abstract class"
        )
        val questionW= Question(
            "Which is a non-static method having the same name as its class?",
            "Field",
            "Method",
            "Constructor",
            "None of the above",
            "Constructor"
        )
        val questionX= Question(
            "Which mechanism is provided to handle the runtime errors so that normal flow of the application can be maintained?",
            "Exception Handling",
            "String Handling",
            "Event Handling",
            "None of the above",
            "Exception Handling"
        )
        val questionY= Question(
            "Which Which field cannot be changed after the object has been constructed?",
            "Static field",
            "Non-static field",
            "Final field",
            "Naming field",
            "Final field"
        )
        val questionZ= Question(
            "In Which the access modifier means that the field can be accessed by all the classes in your app?",
            "private",
            "public",
            "package",
            "protected",
            "public"
        )





>>>>>>> master

        questionlist.add(questionA)
        questionlist.add(questionB)
        questionlist.add(questionC)
        questionlist.add(questionD)
        questionlist.add(questionE)
        questionlist.add(questionF)
        questionlist.add(questionG)
        questionlist.add(questionH)
        questionlist.add(questionI)
        questionlist.add(questionJ)
        questionlist.add(questionK)
        questionlist.add(questionM)
        questionlist.add(questionN)
        questionlist.add(questionO)
        questionlist.add(questionP)
        questionlist.add(questionQ)
        questionlist.add(questionR)
        questionlist.add(questionS)
        questionlist.add(questionT)
        questionlist.add(questionU)
        questionlist.add(questionV)
        questionlist.add(questionW)
        questionlist.add(questionX)
        questionlist.add(questionY)
        questionlist.add(questionZ)


        return questionlist

    }

    //TOdo make a function to add a new game to the database
    //Todo make a function to retrieve a list of all games played
    //Todo make a function to remove a game from the database

    //Todo make a function to make a player object
    //Todo make a function to save a player object
    //Todo make a function to edit a player object
    //Todo make a functio to delete a player object

    //Todo make a function to save a game object
    //Todo make a function to delete a game object
    //Todo make a function to pair a game object with a player object.

}