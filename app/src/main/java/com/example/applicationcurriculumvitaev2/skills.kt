package com.example.applicationcurriculumvitaev2

import com.example.applicationcurriculumvitaev2.R


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar

private const val ARG_ANDROID_SKILL = "Android"

class skills : Fragment() {

    private var number: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            number = it.getInt(ARG_ANDROID_SKILL)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_skills, container, false)
        val androidSkill = view.findViewById<SeekBar>(R.id.seekBar_android)
        if (arguments != null) {
            number = arguments?.getInt(ARG_ANDROID_SKILL)
        }
        androidSkill.progress = number ?: 66
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(
            param1: Int
        ) = skills().apply {
            arguments = Bundle().apply {
                putInt(ARG_ANDROID_SKILL, param1)

            }
        }
    }

}