package com.example.applicationcurriculumvitaev2

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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


        println("Generated companies: \n " + ExperienceData.genRandomCompanies(10))



        btnexperience.setOnClickListener {
            changeFragment(experience(), "")

        }
        btneducation.setOnClickListener {
            changeFragment(education(), "")
        }

        val toolbar = findViewById<Toolbar>(R.id.toolbar2)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            onBackPressed();

        }
        toolbar.inflateMenu(R.menu.careermenu);

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.careermenu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.addeducation -> {
                val intent = Intent(this.applicationContext, add_education::class.java)
                startActivity(intent)
//                Toast.makeText(this,"Education button clicked",Toast.LENGTH_LONG).show()
//                println("Test eD")

                return true
            }
            R.id.addexperience -> {
                val intent = Intent(this, add_experience::class.java)
                startActivity(intent)
//                Toast.makeText(this,"Experience button clicked",Toast.LENGTH_LONG).show()
//                println("Test ex")
                return true
            }
        }
        return super.onOptionsItemSelected(item)
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