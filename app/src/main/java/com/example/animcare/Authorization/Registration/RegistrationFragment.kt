package com.example.animcare.Authorization.Registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.animcare.Authorization.Authorization
import com.example.animcare.R
import kotlinx.android.synthetic.main.activity_authorization.*
import kotlinx.android.synthetic.main.fragment_registration.*
import java.lang.ref.ReferenceQueue

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegistrationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegistrationFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registration, container, false)
    }



    override fun onStart() {
        super.onStart()

        var bundle = requireArguments()
        var authorization = bundle.getSerializable("authorization") as Authorization

        authorization_login_registration.setOnTouchListener(myTouchListenerRegistration)
        authorization_password_registration.setOnTouchListener(myTouchListenerRegistration)
        authorization_age_registration.setOnTouchListener(myTouchListenerRegistration)
        authorization_name_registration.setOnTouchListener(myTouchListenerRegistration)
        authorization_repeat_password_registration.setOnTouchListener(myTouchListenerRegistration)


        btn_back_to_login_registration.setOnClickListener(mySetOnClickListenerForBtnBackToLoginRegistration)

        btn_register_registration.setOnClickListener(mySetOnClickListenerForBtnRegister)




    }
    private val mySetOnClickListenerForBtnRegister = View.OnClickListener {
        val bundle = requireArguments()
        var authorization = bundle.getSerializable("authorization") as Authorization
        var user =  authorization.getUser()

        val checkEmail = user.setEmail(authorization_login_registration.text.toString())
        val checkPassword = user.setPassword(authorization_password_registration.text.toString())
        val checkRepeatPassword = user.setRepeatPassword(authorization_repeat_password_registration.text.toString())
        val checkAge = user.setAge(authorization_age_registration.text.toString().toInt())
        val checkName = user.setName(authorization_name_registration.text.toString())

        if (checkEmail){
            println("Email -> poprawny")
        }else if (!checkEmail){
            println("Email -> niepoprawny")
        }
        if(checkPassword){
            println("Hasło -> poprawne")
        }else if (!checkPassword){
            println("Hasło -> niepoprawne")
        }
        if (checkRepeatPassword){
            println("RepeatPassword -> poprawne")
        }else if (!checkRepeatPassword){
            println("RepeatPassword -> niepoprawne")
        }
        if (checkName){
            println("Nazwa -> poprawne")
        }else if (!checkName){
            println("Nazwa -> niepoprawne")
        }



    }

    private val mySetOnClickListenerForBtnBackToLoginRegistration = View.OnClickListener {
        requireActivity().onBackPressed()
    }

    private val myTouchListenerRegistration = View.OnTouchListener { v, event ->
        if (MotionEvent.ACTION_UP == event!!.action){
            var authorization = requireArguments().getSerializable("authorization") as Authorization
            authorization.setGone()
        }
        false
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RegistrationFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RegistrationFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}