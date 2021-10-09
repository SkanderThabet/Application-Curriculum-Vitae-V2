package com.example.applicationcurriculumvitaev2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import org.w3c.dom.Text


class Result : Fragment() {

private lateinit var textView : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val view : View = inflater.inflate(R.layout.fragment_result, container, false)
        textView = view.findViewById<View>(R.id.Name) as TextView
        val bundle = arguments
        val message = bundle!!.getString("Name")
        textView.text=message



        // Inflate the layout for this fragment
        return view
    }
}