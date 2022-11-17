package com.example.animcare.Authorization

import java.io.Serializable
import java.util.regex.Pattern

class User: Serializable {
    private var email: String = String()
    private var password: String = String()
    private var repeatPassword: String = String()
    private var uid: String = String()
    private var name: String = String()
    private var age: Int = 0

    constructor()

    fun setEmail(email: String): Boolean{
        var emailCorrectness = emailCorrectness(email)

        return when(emailCorrectness){
            true -> {
                this.email = email
                true
            }
            false -> {
                false
            }

        }
    }
    fun setRepeatPassword(repeatPassword: String): Boolean{
        return when(passwordCorrectness(repeatPassword)){
            true -> {
                this.repeatPassword = repeatPassword
                true
            }
            false -> {
                false
            }
        }
    }

    fun setPassword(password: String): Boolean{
        var passwordCorrectness = passwordCorrectness(password)

        return when(passwordCorrectness){
            true -> {
                this.password = password
                true
            }
            false -> {
                false
            }
        }
    }
    fun setUid(uid: String){
        this.uid = uid
    }
    fun setName(name: String): Boolean{
        var correctness = nameCorrectness(name)
        return when(correctness){
            true -> {
                this.name = name
                true
            }
            false -> {
                false
            }
        }
    }
    fun setAge(age: Int){
        this.age = age
    }

    fun getRepeatPassword(): String{
        return this.repeatPassword
    }

    fun getEmail(): String{
        return this.email
    }
    fun getPassword(): String{
        return this.password
    }
    fun getUid():String{
        return this.uid
    }
    fun getName(): String{
        return this.name
    }
    fun getAge(): Int{
        return this.age
    }

    private fun nameCorrectness(name: String): Boolean{
        var pattern = Pattern.compile("[A-Z]{1}[a-z]+")
        var manager = pattern.matcher(name)
        var matches = manager.matches()
        return when(matches){
            true -> {
                true

            }
            false -> {
                false
            }
        }
    }

    private fun emailCorrectness(email: String): Boolean{
        var pattern = Pattern.compile("[\\w]+@[\\w]+\\.[\\w]+")
        var matcher = pattern.matcher(email)
        var matches = matcher.matches()

        return when(matches){
            true -> {
                true
            }
            false -> {
                false
            }

        }

    }
    private fun passwordCorrectness(password: String): Boolean{
        var pattern = Pattern.compile("[\\d[a-z]+]{9,}+")
        var matcher = pattern.matcher(password)
        var matches = matcher.matches()

        return when(matches){
            true -> {
                true
            }
            false -> {
                false
            }

        }

    }



}