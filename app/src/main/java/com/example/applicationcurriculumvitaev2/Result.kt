package com.example.applicationcurriculumvitaev2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import org.w3c.dom.Text

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_NAME = "Name"
private const val ARG_AGE = "Age"
private const val ARG_EMAIL = "Email"
private const val ARG_Gender = "Gender"


/**
 * A simple [Fragment] subclass.
 * Use the [test.newInstance] factory method to
 * create an instance of this fragment.
 */

class Result : Fragment() {
    // TODO: Rename and change types of parameters
    private var name_string: String? = null
    private var age_string: String? = null
    private var gender_string: String? = null
    private var mail_string: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name_string = it.getString(ARG_NAME)
            age_string = it.getString(ARG_AGE)
            mail_string = it.getString(ARG_EMAIL)
            gender_string = it.getString(ARG_Gender)
        }
    }

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_result, container, false)
        // Inflate the layout for this fragment
        val nameText = v.findViewById<TextView>(R.id.Name)
        val ageText = v.findViewById<TextView>(R.id.yearsold)
        val emailText = v.findViewById<TextView>(R.id.email)
        val genderText = v.findViewById<TextView>(R.id.gender)
        if (arguments != null) {
            name_string = requireArguments().getString(ARG_NAME)
            gender_string = requireArguments().getString(ARG_Gender)
            mail_string = requireArguments().getString(ARG_EMAIL)
            age_string = requireArguments().getString(ARG_AGE)
        }
        nameText.text = "Hello ! my name is ${name_string}"
        ageText.text = "I have ${age_string} years old"
        emailText.text = "my email ${mail_string}"
        genderText.text = "and I am a ${gender_string}"

        return v
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment result.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(
            param1: String?,
            param2: String?,
            param3: String?,
            param4: String?
        ) = Result().apply {

            arguments = Bundle().apply {
                putString(ARG_NAME, param1)
                putString(ARG_AGE, param2)
                putString(ARG_EMAIL, param3)
                putString(ARG_Gender, param4)
            }
        }
    }


}