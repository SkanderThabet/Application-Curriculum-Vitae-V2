package com.example.applicationcurriculumvitaev2

import com.example.applicationcurriculumvitaev2.R


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar

private const val ARG_ANDROID_SKILL = "Android"
private const val ARG_IOS_SKILL = "iOS"
private const val ARG_FLUTTER_SKILL = "Flutter"

class skills : Fragment() {

    private var androidNumber: Int? = null
    private var iOSNumber: Int? = null
    private var flutterNumber: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            androidNumber = it.getInt(ARG_ANDROID_SKILL)
            iOSNumber = it.getInt(ARG_IOS_SKILL)
            flutterNumber= it.getInt(ARG_FLUTTER_SKILL)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_skills, container, false)
        val androidSkill = view.findViewById<SeekBar>(R.id.seekBar_android)
        val iosSkill = view.findViewById<SeekBar>(R.id.seekBar_ios)
        val flutterSkill = view.findViewById<SeekBar>(R.id.seekBar_flutter)
        if (arguments != null) {
            androidNumber = arguments?.getInt(ARG_ANDROID_SKILL)
            iOSNumber = arguments?.getInt(ARG_IOS_SKILL)
            flutterNumber = arguments?.getInt(ARG_FLUTTER_SKILL)
        }
        //Set the number
        androidSkill.progress = androidNumber ?: 66
        iosSkill.progress = iOSNumber ?: 66
        flutterSkill.progress = flutterNumber ?: 66

        //disable on touch to get fixed values
        androidSkill.setOnTouchListener { _, _ -> true }
        iosSkill.setOnTouchListener { _, _ -> true }
        flutterSkill.setOnTouchListener { _, _ -> true }
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(
            param1: Int?,
            param2: Int?,
            param3: Int?,
        ) = skills().apply {
            arguments = Bundle().apply {
                param1?.let { putInt(ARG_ANDROID_SKILL, it) }
                param2?.let { putInt(ARG_IOS_SKILL, it) }
                param3?.let { putInt(ARG_FLUTTER_SKILL, it) }

            }
        }
    }

}