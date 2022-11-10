package com.example.animcare.MainActivityFiles.MyPets.Class

import android.os.Build
import android.service.notification.ZenPolicy
import androidx.annotation.RequiresApi
import java.io.Serializable
import java.time.*

class Diagnosis: Serializable {
     private var diagnosisName: String = String()
     private var type: String = String()
     private var date: CustomDateAndTime = CustomDateAndTime()
     private var description: String = String()
     private var dateNextDiagnosis: CustomDateAndTime = CustomDateAndTime()

    constructor()
//    constructor(name: String, type: String, date: CustomDateAndTime, description: String){
//        this.name = name
//        this.type = type
//        this.date = date
//        this.description = description
//    }
//    constructor(name: String, type: String, date: CustomDateAndTime,
//                description: String, dateNextDiagnosis: CustomDateAndTime){
//        this.name = name
//        this.type = type
//        this.date = date
//        this.description = description
//        this.dateNextDiagnosis = dateNextDiagnosis
//    }
//
    fun getDiagnosisName(): String{
        return this.diagnosisName
    }
    fun getType(): String{
        return this.type
    }
    fun getDescription(): String{
        return this.description
    }
    fun getDiagnosisDate(): CustomDateAndTime{
        return this.date
    }
    fun getNextDiagnosisDate(): CustomDateAndTime{
        return this.dateNextDiagnosis
    }

    fun setDiagnosisName(diagName: String){
        this.diagnosisName = diagName
    }
    fun setType(type: String){
        this.type = type
    }
    fun setDiagnosisDate(date: CustomDateAndTime){
        this.date = date

    }
    fun setDescription(description: String){
        this.description = description
    }
    fun setNextDiagnosisDate(nextDiagnosisDate: CustomDateAndTime){
        this.dateNextDiagnosis = nextDiagnosisDate
    }





}