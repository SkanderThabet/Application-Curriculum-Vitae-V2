package com.example.applicationcurriculumvitaev2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class CareerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_career)
        val btnexperience = findViewById<Button>(R.id.experience)
        val btneducation = findViewById<Button>(R.id.education)


        println("Generated companies: \n "+ExperienceData.genRandomCompanies(10))



        btnexperience.setOnClickListener {
            changeFragment(experience(), "")

        }
        btneducation.setOnClickListener {
            changeFragment(education(),"")
        }

        val toolbar = findViewById<Toolbar>(R.id.toolbar2)
        toolbar.setNavigationOnClickListener {
            onBackPressed();

        }
    }




    private fun changeFragment(fragment: Fragment, name: String) {
        if (name.isEmpty())
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView2, fragment)
                .commit()
        else {
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView2, fragment)
                .addToBackStack(name).commit()
        }
    }


}