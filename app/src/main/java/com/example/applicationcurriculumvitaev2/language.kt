package com.example.applicationcurriculumvitaev2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox

private const val ARG_ARABIC = "Arabic"
private const val ARG_FRENCH = "French"
private const val ARG_ENGLISH = "English"

class language : Fragment() {

    private var arabicstate = false
    private var frenchstate = false
    private var englishstate = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            arabicstate = it.getBoolean(ARG_ARABIC)
            frenchstate = it.getBoolean(ARG_FRENCH)
            englishstate = it.getBoolean(ARG_ENGLISH)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_language, container, false)
        // Inflate the layout for this fragment
        val CB_arabic = view.findViewById<CheckBox>(R.id.checkBox_arabic)
        val CB_french = view.findViewById<CheckBox>(R.id.checkbox_french)
        val CB_english = view.findViewById<CheckBox>(R.id.checkBox_english)
        /**
         * Condition to get multiple boxes when checked
         */
        if (arguments != null) {
            if ((arguments?.getBoolean(ARG_ARABIC) == true) && ((arguments?.getBoolean(ARG_FRENCH) == true)) && (arguments?.getBoolean(
                    ARG_ENGLISH
                ) == true)
            ) {
                true.let {
                    arabicstate = it
                    frenchstate = it
                    englishstate = it
                }
                CB_arabic.isChecked = arabicstate
                CB_french.isChecked = frenchstate
                CB_english.isChecked = englishstate
            } else if ((arguments?.getBoolean(ARG_ARABIC) == true) && ((arguments?.getBoolean(
                    ARG_FRENCH
                ) == true) && (arguments?.getBoolean(ARG_ENGLISH)) == false)
            ) {
                true.let {
                    arabicstate = it
                    frenchstate = it
                }
                englishstate = false
                CB_arabic.isChecked = arabicstate
                CB_french.isChecked = frenchstate
                CB_english.isChecked = englishstate
            } else if ((arguments?.getBoolean(ARG_ARABIC) == true) && ((arguments?.getBoolean(
                    ARG_FRENCH
                ) == false)) && (arguments?.getBoolean(ARG_ENGLISH) == true)
            ) {
                true.let {
                    arabicstate = it
                    englishstate = it

                }
                frenchstate = false
                CB_arabic.isChecked = arabicstate
                CB_french.isChecked = frenchstate
                CB_english.isChecked = englishstate
            } else if ((arguments?.getBoolean(ARG_ARABIC) == false) && ((arguments?.getBoolean(
                    ARG_FRENCH
                ) == true)) && (arguments?.getBoolean(ARG_ENGLISH) == true)
            ) {
                true.let {
                    frenchstate = it
                    englishstate = it

                }
                arabicstate = false
                CB_arabic.isChecked = arabicstate
                CB_french.isChecked = frenchstate
                CB_english.isChecked = englishstate
            } else if (arguments?.getBoolean(ARG_ENGLISH) == true) {
                englishstate = true
                CB_english.isChecked = englishstate
            } else if (arguments?.getBoolean(ARG_ARABIC) == true) {
                arabicstate = true
                CB_arabic.isChecked = englishstate
            } else if (arguments?.getBoolean(ARG_FRENCH) == true) {
                frenchstate = true
                CB_french.isChecked = englishstate
            } else {
                CB_arabic.isChecked = false
                CB_french.isChecked = false
                CB_english.isChecked = false

            }
        }
        /**
         * Disable checking
         */
        CB_arabic.setOnTouchListener { _, _ -> true }
        CB_french.setOnTouchListener { _, _ -> true }
        CB_english.setOnTouchListener { _, _ -> true }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(
            param1: Boolean?,
            param2: Boolean?,
            param3: Boolean?,
        ) = language().apply {
            arguments = Bundle().apply {
                param1?.let { putBoolean(ARG_ARABIC, it) }
                param2?.let { putBoolean(ARG_FRENCH, it) }
                param3?.let { putBoolean(ARG_ENGLISH, it) }

            }
        }
    }

}