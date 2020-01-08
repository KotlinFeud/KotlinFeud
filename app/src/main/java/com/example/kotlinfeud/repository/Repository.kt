package com.example.kotlinfeud.repository

import android.content.Context
import androidx.room.Room
import com.example.kotlinfeud.model.GameDao
import com.example.kotlinfeud.model.GameDatabase
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
        val questionH = Question(
            "What testing framework do you use to test logic?",
            "Expresso",
            "Latte",
            "Mockito",
            "Mimosa",
            "Mockito"
        )
        val questionI = Question(
            "How many different stages of activity lifecycle?",
            "5",
            "6",
            "7",
            "8",
            "7"
        )
        val questionJ = Question(
            "How many different types of intents are there?",
            "1",
            "2",
            "3",
            "4",
            "2"
        )
        val questionK = Question(
            " Is a support library that allows you to bind UI components in your layouts to data sources in your app?",
            "Retrofit",
            "RxJava",
            "Data Binding",
            "UI Binding",
            "Data Binding"
        )
        val questionL = Question(
            " Is a support library that allows you to bind UI components in your layouts to data sources in your app?",
            "Retrofit",
            "RxJava",
            "Data Binding",
            "UI Binding",
            "Data Binding"
        )
        val questionM = Question(
            "Var is what?",
            "Immutable",
            "Static",
            "Nullable",
            "Mutable",
            "Mutable"
        )
        val questionN = Question(
            "Val is what?",
            "Immutable",
            "Static",
            "Nullable",
            "Mutable",
            "Immutable"
        )
        val questionO = Question(
            "Kotlin is developed by?",
            "Google",
            "Jetbrains",
            "Microsoft",
            "Adobe",
            "Jetbrains"
        )
        val questionP = Question(
            "Which of the following is used to handle null exceptions in Kotlin?",
            "Range",
            "Sealed Class",
            "Elvis Operator",
            "Lambda function",
            "Elvis Operator"
        )
        val questionQ = Question(
            "Which file extension is used to save Kotlin files?",
            ".java",
            ".kot",
            ".kt or .kts",
            ".android",
            ".kt or .kts"
        )
        val questionR = Question(
            "All classes in Kotlin classes are by default?",
            "Public",
            "Final",
            "Sealed",
            "Private",
            "Final"
        )
        val questionS= Question(
            "What is a service in android?",
            "Runs background operations with UI interaction",
            "Runs background operations without UI interaction",
            "Both A and B",
            "None of the above",
            "runs background operations without UI interaction"
        )
        val questionT = Question(
            "Which keyword is used by classes to implement an interface?",
            "Import",
            "Implements",
            "Instance of",
            "Abstract",
            "Implements"
        )
        val questionU = Question(
            "Which method is used in thread class to start the execution of the thread?",
            "Public void start()",
            "Public void run()",
            "Public void execute()",
            "Public void launch()",
            "Public void ()"
        )
        val questionV = Question(
            "Which class cannot be instantiated?",
            "Abstract class",
            "Static class",
            "Both A&B",
            "None of the above",
            "Abstract class"
        )
        val questionW = Question(
            "Which is a non-static method having the same name as its class?",
            "Field",
            "Method",
            "Constructor",
            "None of the above",
            "Constructor"
        )
        val questionX = Question(
            "Which mechanism is provided to handle the runtime errors so that normal flow of the application can be maintained?",
            "Exception Handling",
            "String Handling",
            "Event Handling",
            "None of the above",
            "Exception Handling"
        )
        val questionY= Question(
            "Which field cannot be changed after the object has been constructed?",
            "Static field",
            "Non-static field",
            "Final field",
            "Naming field",
            "Final field"
        )
        val questionZ = Question(
            "In Which the access modifier means that the field can be accessed by all the classes in your app?",
            "Private",
            "Public",
            "Package",
            "Protected",
            "Public"
        )
        val questionA1= Question(
            "What are Kotlin \n coroutines?",
            "That's how the automatically generated methods hashCode() and equals() in data classes are called",
            "It's Kotlin's term for class methods",
            "These functions which accept other functions as arguments or return them",
            "They provide asynchronous code without thread blocking",
            "They provide asynchronous code without thread blocking"
        )
        val questionA2= Question(
            "What is the correct way to declare a variable of integer type in Kotlin?",
            "let i = 42",
            "var i : int = 42",
            "var i : Int = 42",
            "int i = 42",
            "var i : int = 42"
        )
        val questionA3= Question(
            "What does the !! operator do?",
            "It converts any value to a non-null type and throws an exceptions if the value is in fact null",
            "It's the modulo operator in Kotlin, similar to Java's %",
            "It compares two values for identify rather than equality",
            "All of the above",
            "It converts any value to a non-null type and throws an exception if the the value is in fact null"
        )
        val questionA4= Question(
            "A GUI: ",
            "uses buttons, menus, and icons",
            "should be easy for a user to manipulate",
            "stands for Graphic User Interaction",
            "Both A and D",
            "Both A and D"
        )
        val questionA5= Question(
            "An object is composed of:",
            "properties",
            "methods",
            "events",
            "All of the above",
            "All of the above"
        )
        val questionA6= Question(
            "Official IDE released for android development is called?",
            "Eclipse",
            "Net Beans",
            "Android Studio",
            "Java",
            "Android Studio"
        )
        val questionA7= Question(
            "What is an activity in Android?",
            "Activity performs the actions on the screen",
            "Manage the Application content",
            "Screen UI",
            "None of the above",
            "Activity performs the actions on the screen"
        )
        val questionA8= Question(
            "What is the difference between margin and padding in android layout",
            "Margin is specifying the extra left on all four sides in layout",
            "Padding is used to offset the content of a view by specific px or dp",
            "Both A and B",
            "None of the above",
            "Both A and B"
        )
        val questionA9= Question(
            "What is the use of content provider in android?",
            "To send the data from an application to another application",
            "To store the data in a database",
            "To share the data between applications",
            "None of the above",
            "To share the data between applications"
        )
        val questionA10= Question(
            "What is the application class in android?",
            "A class that can create only an object",
            "Anonymous",
            "Java class",
            "Base class for all classes",
            "Base class for all classes"
        )
        val questionA11= Question(
            "What is contained within the manifest xml file?",
            "The permissions the app requires",
            "The list of strings use in the app",
            "The source code",
            "None of the above",
            "The permissions the app requires"
        )
        val questionA12= Question(
            "What is contained within the Layout xml file?",
            "Orientations and layouts that specify what the display looks like",
            "The permissions required by the app",
            "The strings used in the app",
            "The code which is compiled to run the app",
            "Orientations and layouts that specify what the display looks like"
        )
        val questionA13= Question(
            "To create an emulator, you need an AVD, What does it stand for?",
            "Android Virtual Display",
            "Android Virtual Device",
            "Active Virtual Device",
            "Application Virtual Display",
            "Android Virtual Device"
        )
        val questionA14= Question(
            "Which file specifies the layout of your screen",
            "Layout file",
            "Manifest file",
            "Strings XML",
            "R file",
            "Layout file"
        )
        val questionA15= Question(
            "Which file specifies the layout of your screen",
            "Layout file",
            "Manifest file",
            "Strings XML",
            "R file",
            "Layout file"
        )
        val questionA16= Question(
            "When an activity doesn't exist in memory it is in",
            "Starting state",
            "Running state",
            "Loading state",
            "Inexistent state",
            "Starting state"
        )
        val questionA17= Question(
            "When an activity doesn't exist in memory it is in",
            "Starting state",
            "Running state",
            "Loading state",
            "Inexistent state",
            "Starting state"
        )
        val questionA18= Question(
            "When an activity doesn't exist in memory it is in",
            "Starting state",
            "Running state",
            "Loading state",
            "Inexistent state",
            "Starting state"
        )
        val questionA19= Question(
            "Which of the following is NOT a state in the lifecycle of a service",
            "Starting",
            "Running",
            "Destroyed",
            "Paused",
            "Paused"
        )
        val questionA20= Question(
            "Intents: ",
            "Are messages that are sent among major building blocks",
            "Trigger activities to being, services to start or stop, or broadcast",
            "Are asynchronous",
            "All of these",
            "All of these"
        )
        val questionA21= Question(
            "When the activity is not in focus, but still visible on the screen it is in?",
            "Running state",
            "Paused state",
            "Stopped state",
            "Destroyed state",
            "Paused State"
        )
        val questionA22= Question(
            "What built-in database is Android shipped with?",
            "SQLite",
            "Apache",
            "MySQL",
            "Oracle",
            "SQLite"
        )
        val questionA23= Question(
            "Status data will be exposed to the rest of the Android system via:",
            "Intents",
            "A content provider",
            "Network receivers",
            "Altering permissions",
            "A content provider"
        )
        val questionA24= Question(
            "Updates your current local working branch with all new commits from the corresponding remote branch on GitHub",
            "Git commit",
            "Git fetch",
            "Git pull",
            "Git push",
            "Git pull "
        )

        questionlist.add(questionA1)
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
        questionlist.add(questionL)
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

        questionlist.add(questionA2)
        questionlist.add(questionA3)
        questionlist.add(questionA4)
        questionlist.add(questionA5)
        questionlist.add(questionA6)
        questionlist.add(questionA7)
        questionlist.add(questionA8)
        questionlist.add(questionA9)
        questionlist.add(questionA10)
        questionlist.add(questionA11)
        questionlist.add(questionA12)
        questionlist.add(questionA13)
        questionlist.add(questionA14)
        questionlist.add(questionA15)
        questionlist.add(questionA16)
        questionlist.add(questionA17)
        questionlist.add(questionA18)
        questionlist.add(questionA19)
        questionlist.add(questionA20)
        questionlist.add(questionA21)
        questionlist.add(questionA22)
        questionlist.add(questionA23)
        questionlist.add(questionA24)


        questionlist.shuffle()

        return questionlist

    }

    //COMPLETE make a function to retrieve a list of all games played
    fun getGameDao(context: Context): GameDao {
        return Room.databaseBuilder(context, GameDatabase::class.java, "GameDB")
            .allowMainThreadQueries()
            .build()
            .gameDao
    }

}