package com.example.animcare.MainActivityFiles.MyPets.Class

import android.os.Build
import androidx.annotation.RequiresApi
import java.io.Serializable
import java.time.LocalDate
import java.time.LocalTime
import java.time.ZoneId
import java.time.ZonedDateTime

class CustomDateAndTime: Serializable {
    var day: String = String()
    var dayOfWeek: String = String()
    var month: String = String()
    var monthValue: String = String()
    var year: String = String()
    var hour: String = String()
    var minutes: String = String()
    var seconds: String = String()
    var zonedId: String = String()

    constructor()

    constructor(day: String,dayOfWeek: String, month:String,monthValue: String, year: String,
                hour: String, minutes: String, seconds: String, zonedId: String
                ){
        this.day = day
        this.dayOfWeek = dayOfWeek
        this.month = month
        this.monthValue = monthValue
        this.year = year
        this.hour = hour
        this.minutes = minutes
        this.seconds = seconds
        this.zonedId = zonedId
    }




}