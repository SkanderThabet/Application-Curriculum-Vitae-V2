package com.example.applicationcurriculumvitaev2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CareerActivity : AppCompatActivity() {

    private var layoutManager : RecyclerView.LayoutManager?=null
    private var adapter: RecyclerView.Adapter<AdapterExperience.ViewHolder>?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_career)

    TODO("Need to add the recycler view and the layoutManager")
        layoutManager = LinearLayoutManager(this)

    }


}