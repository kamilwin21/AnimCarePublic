package com.example.animcare.Quizzes

import com.example.animcare.Classes.Question
import com.example.animcare.Classes.Quiz
import com.example.animcare.Classes.TruthFalsehood

object Dogs {
    var psy: Quiz = Quiz(
        "Psy",
        "Quiz ten zawiera określoną pytań z tematyki psów. " +
                "W quizie tym pokazane będą różne pytania o różnym poziomie trudności. " +
                "Trudniejsze pytania dadzą Ci więcej punktów. " +
                "Powodzenia!",
        "1",
        arrayListOf(
            Question(
                "Jaka jest długość życia?",
                "12 do 13 lat",
                "8 do 12 lat",
                "8 co 13 lat",
                "10 do 15 lat",
                "12 do 13 lat",
                "2",
                "SingleChoise"
            ),
            Question(
                "Przykładowe pytanie?",
                "dobra odpowiedź",
                "zła odpowiedź",
                "zła odpowiedź",
                "zła odpowiedź",
                "dobra odpowiedź",
                "2",
                "SingleChoise"
            ),
            Question(
                "Jaki charakter ma owczarek szetlandzki?",
                "Wesoły",
                "Ufny wobec obcych",
                "Uparty",
                "Leniwy",
                "Wesoły",
                "1",
                "SingleChoise"

            ),
            Question(
                "Jaki charakter ma owczarek szetlandzki?",
                "Wesoły",
                "Nieufny wobec obcych",
                "Żywy",
                "Leniwy",
                arrayListOf("Wesoły", "Żywy", "Nieufny wobec obcych"),
                "3",
                "MultipleChoise"

            ),
            Question(
                "Jaką wagę posiada owczarek szetlandzki?",
                "5-12 kg",
                "4-7 kg",
                "5-10 kg",
                "10-14 kg",
                "5-10 kg",
                "2",
                "SingleChoise"

            ),
            Question(
                "Ile zębów mają szczenięta?",
                "10",
                "28",
                "34",
                "40",
                "28",
                "2",
                "SingleChoise"

            ),
            Question(
                "Pytanie z wieloma odpowiedziami 1?",
                "Fałszywa odpowiedź 1",
                "Prawdziwa odpowiedź 1",
                "Fałszywa odpowiedź 1",
                "Fałszywa odpowiedź 1",
                arrayListOf("Prawdziwa odpowiedź 1"),
                "2",
                "MultipleChoise"

            ),
            Question(
                "Pytanie z wieloma odpowiedziami 21?",
                "Fałszywa odpowiedź 2",
                "Prawdziwa odpowiedź 2",
                "Fałszywa odpowiedź 2",
                "Fałszywa odpowiedź 2",
                arrayListOf("Prawdziwa odpowiedź 2"),
                "2",
                "MultipleChoise"

            ),
            Question(
                "Pytanie z wieloma odpowiedziami 3?",
                "Fałszywa odpowiedź 3",
                "Prawdziwa odpowiedź 3",
                "Fałszywa odpowiedź 3",
                "Fałszywa odpowiedź 3",
                arrayListOf("Prawdziwa odpowiedź 3"),
                "2",
                "MultipleChoise"

            ),
            Question(
                "Pytanie z wieloma odpowiedziami 4?",
                "Fałszywa odpowiedź 4",
                "Prawdziwa odpowiedź 4",
                "Fałszywa odpowiedź 4",
                "Fałszywa odpowiedź 4",
                arrayListOf("Prawdziwa odpowiedź 4"),
                "2",
                "MultipleChoise"

            ),
            Question("45% psiaków śpi w łóżku swoich właścicieli.",
                "Prawda",
                "1",
                "TrueOrFalse"
                ),
            Question("Psy mają o wiele większą ilość kubków smakowych niż ludzie.",
                "Fałsz",
                "1",
                "TrueOrFalse"
            ),
            Question("Psy posiadają większą temperaturę ciała niż człowiek.",
                "Prawda",
                "1",
                "TrueOrFalse"
            )





        )



    )

}