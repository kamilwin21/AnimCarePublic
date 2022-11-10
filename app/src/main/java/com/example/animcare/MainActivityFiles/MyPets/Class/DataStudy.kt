package com.example.animcare.MainActivityFiles.MyPets.Class

import android.os.Build
import androidx.annotation.RequiresApi
import java.io.Serializable
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
@RequiresApi(Build.VERSION_CODES.O)
data class DataStudy(
    var name: String = "",
    var date: CustomDateAndTime = CustomDateAndTime(),
    var doctor: Doctor = Doctor(),
    var cost: Int = 0,
    var description: String = "",
    var symptoms: ArrayList<String> = arrayListOf(),
    var diagnosis: String = "",
    var clinic: Clinic = Clinic()

): Serializable {

}