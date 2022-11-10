package com.example.animcare.MainActivityFiles.Fragments.QuizFragmentFiles

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.animcare.Classes.Quiz
import com.example.animcare.MainActivityFiles.Fragments.QuizFragmentFiles.QuizActivityFiles.MultipleChoiseFragment
import com.example.animcare.MainActivityFiles.Fragments.QuizFragmentFiles.QuizActivityFiles.SingleChoiceFragment
import com.example.animcare.MainActivityFiles.Fragments.QuizFragmentFiles.SummaryQuizFiles.SummaryDetailedFragment
import com.example.animcare.R
import kotlinx.android.synthetic.main.activity_quiz.*

class QuizActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

       // fragmentContainerViewQuizAcivity.isVisible = true
        //bottomNav.isVisible = false

        supportActionBar?.title = "Quiz"

        //Fragments for bottom navigation in summary quiz
        val summaryFragment = SummaryFragment()
        val summaryDetailedFragment = SummaryDetailedFragment()

        //Fragments for Menu navigation
        val quizDetailsFragment = QuizDetailsFragment()

        val quizType = intent.getStringExtra("DetailesOfQuiz").toString()

        val args = Bundle()
        args.putString("DetailesOfQuiz", quizType)
        quizDetailsFragment.arguments = args
        goToFragment(quizDetailsFragment)

//        bottomNav.setOnItemSelectedListener {
//          when(it.itemId){
//              R.id.general -> {
//                   // Toast.makeText(applicationContext, "Kliknięto GENERAL",Toast.LENGTH_SHORT).show()
//                  loadFragmentForBottomNavigation(summaryFragment)
//              }
//              R.id.detailed -> {
//                  Toast.makeText(applicationContext, "Kliknięto DETAILED",Toast.LENGTH_SHORT).show()
//                  loadFragmentForBottomNavigation(summaryDetailedFragment)
//              }
//              R.id.finish -> {
//                  Toast.makeText(applicationContext, "Kliknięto FINISH",Toast.LENGTH_SHORT).show()
//              }
//
//          }
//            true
//
//        }







    }





    private fun goToFragment(fragment: Fragment){
        var backName = fragment.javaClass.name
        val manager = supportFragmentManager
       // var fragmentsInBackStack = manager.popBackStackImmediate(backName,0)
            val fragmentTransaction = manager.beginTransaction()
                .replace(R.id.fragmentContainerViewQuizAcivity, fragment)
            fragmentTransaction.commit()


    }

}