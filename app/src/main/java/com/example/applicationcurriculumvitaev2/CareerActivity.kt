package com.example.applicationcurriculumvitaev2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CareerActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_career)
        val btnexperience= findViewById<Button>(R.id.experience)
        val btneducation = findViewById<Button>(R.id.education)

        val exp= ExperienceData.genRandomCompanies(10)
        val expAdapter=AdapterExperience(exp)
        val recyclerViewExperience = findViewById<RecyclerView>(R.id.recyclerViewExperience)
        recyclerViewExperience.layoutManager=LinearLayoutManager(this)
        recyclerViewExperience.adapter = expAdapter

        btnexperience.setOnClickListener {
            changeFragment(experience(),"")
        }
    }



    private fun changeFragment(fragment: Fragment, name: String) {
        if (name.isEmpty())
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, fragment)
                .commit()
        else {
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, fragment)
                .addToBackStack(name).commit()
        }
    }


}