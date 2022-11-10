package com.example.animcare

import android.graphics.Color
import java.io.Serializable

object ImportantSettings: Serializable {

    //==============================================================================================
    //Ustawienia Quizu
    //==============================================================================================

        //Ustawiene koloru tekstu w widoku(View)
        val textColor: Int = Color.WHITE


        //Ustawienie koloru tła po wciśnięciu na dany element(View)
        val backgroundColorOnClick: Int = Color.parseColor("#8EC5AD")


        //Ustawienie losuje ilość pytań, która będzie losowana na dany quiz użytkownika.
        val numberQuestionOnQuiz: Int = 6

        //Czas podczas, którego użytkownik będzie musiał dokonać wyboru odpowiedzi.
        // time = timePerQuestion / 1000 -> 6000 / 1000 = 6 sek.
        val timePerQuestion: Long = 20000

        //Kolor tła po zaznaczeniu checkboxa w module quizu.
        val textBackgroundColor: Int = Color.parseColor("#ABF1D2")

        //Ustawienie szybkości napełniania się progressBarów w summaryFragment oraz SummaryDetailedFragment
        val sleepInSummaryFragment: Long = 20

        val sleepInSummaryDetailedFragment: Long = 20

        //Kolor, który jest ustawiony we wszystkich nagłównach aktywności oraz fragmentów(Tytuł)
        val color = Color.parseColor("#8EC5AD")

    //==============================================================================================
}
