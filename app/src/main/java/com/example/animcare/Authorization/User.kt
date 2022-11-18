package com.example.animcare.Authorization

import android.content.Context
import android.text.BoringLayout
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.animcare.R
import kotlinx.android.synthetic.main.fragment_registration.*
import java.io.Serializable
import java.util.regex.Pattern

class User: Serializable {
    private var email: String = String()
    private var password: String = String()
    private var repeatPassword: String = String()
    private var uid: String = String()
    private var name: String = String()
    private var age: Int = 0
    private var dataStatusValidationLogin: Boolean = false
    private var dataStatusValidationPassword: Boolean = false
    private var dataStatusValidationRepeatPassword: Boolean = false
    private var dataStatusValidationName: Boolean = false
    private var dataStatusValidationAge: Boolean = false
    private var context: Context? = null

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
    fun setAge(age: String): Boolean{
        var correctness = false
        if (age.isNullOrEmpty()){
            correctness = false
        }else{
            correctness = ageCorrectness(age.toInt())
        }
        return when(correctness){
            true -> {
                this.age = age.toInt()
                true
            }
            false -> { false }
        }
    }
    fun setContext(context: Context){
        this.context = context
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
    fun getContext(): Context{
        return this.context!!
    }

    private fun getDataStatusValidation(): Boolean{

        return if (dataStatusValidationLogin && dataStatusValidationPassword && dataStatusValidationRepeatPassword &&
            dataStatusValidationName && dataStatusValidationAge){
            dataStatusValidationPassword == dataStatusValidationRepeatPassword

        }else{
            false
        }
    }
    fun register(){
        when(getDataStatusValidation()){
            true -> {
                Toast.makeText(this.context, "Pomyślnie zalogowano", Toast.LENGTH_SHORT).show()
            }
            false -> {
                Toast.makeText(this.context, "Błąd rejestracji", Toast.LENGTH_SHORT).show()

            }
        }
    }


    fun registrationDataValidation(requireContext: Context, checkEmail: Boolean,
        checkPassword: Boolean, checkRepeatPassword: Boolean, checkName: Boolean, checkAge: Boolean,
                                   authorization_login_registration: EditText,
                                    authorization_password_registration: EditText,
                                   authorization_repeat_password_registration: EditText,
                                   authorization_name_registration: EditText,
                                   authorization_age_registration: EditText
                                   ){


        when(checkEmail){
            true -> {
                println("Email -> poprawny")
                authorization_login_registration.background = ContextCompat.getDrawable(requireContext, R.drawable.green_border)
                dataStatusValidationLogin= true
            }
            false -> {
                println("Email -> niepoprawny")
                authorization_login_registration.background = ContextCompat.getDrawable(requireContext, R.drawable.red_border)
                dataStatusValidationLogin = false
            }
        }
        when(checkPassword){
            true -> {
                println("Password -> poprawny")
                authorization_password_registration.background = ContextCompat.getDrawable(requireContext, R.drawable.green_border)
                dataStatusValidationPassword = true


            }
            false -> {
                println("Password -> niepoprawny")
                authorization_password_registration.background = ContextCompat.getDrawable(requireContext, R.drawable.red_border)
                dataStatusValidationPassword = false

            }

        }
        when(checkRepeatPassword){
            true -> {
                println("RepeatPassword -> poprawny")
                authorization_repeat_password_registration.background = ContextCompat.getDrawable(requireContext, R.drawable.green_border)
                dataStatusValidationRepeatPassword = true
                if (this.repeatPassword == this.password){
                    authorization_repeat_password_registration.background = ContextCompat.getDrawable(requireContext, R.drawable.green_border)
                    dataStatusValidationRepeatPassword = true
                }else {
                    authorization_repeat_password_registration.background = ContextCompat.getDrawable(requireContext, R.drawable.red_border)
                    dataStatusValidationRepeatPassword = false
                }

            }
            false -> {
                println("RepeatPassword -> niepoprawny")
                authorization_repeat_password_registration.background = ContextCompat.getDrawable(requireContext, R.drawable.red_border)
                dataStatusValidationRepeatPassword = false
            }

        }
        when(checkName) {
            true -> {
                println("Name -> poprawny")
                authorization_name_registration.background =
                    ContextCompat.getDrawable(requireContext, R.drawable.green_border)
                dataStatusValidationName = true
            }
            false -> {
                println("Name -> niepoprawny")
                authorization_name_registration.background =
                    ContextCompat.getDrawable(requireContext, R.drawable.red_border)
                dataStatusValidationName = false
            }
        }

        when(checkAge){
            true -> {
                println("Age -> poprawny")
                authorization_age_registration.background =
                    ContextCompat.getDrawable(requireContext, R.drawable.green_border)
                dataStatusValidationAge = true

            }
            false -> {
                println("Age -> niepoprawny")
                authorization_age_registration.background =
                    ContextCompat.getDrawable(requireContext, R.drawable.red_border)
                dataStatusValidationAge = false

            }
        }

    }

    private fun ageCorrectness(age: Int): Boolean{
        var pattern = Pattern.compile("[0-9]+")
        val matcher = pattern.matcher(age.toString())
        return when(matcher.matches()){
            true -> { true }
            false -> { false }
        }
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