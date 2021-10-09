package com.example.applicationcurriculumvitaev2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class ResultActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val intent = intent
        val FullName = intent.getStringExtra("Name")
        val age = intent.getStringExtra("Age")
        val mail = intent.getStringExtra("Email")
        val gender = intent.getStringExtra("Gender")
        val androidskill = intent.getStringExtra("Android")
        val iosSkill = intent.getStringExtra("iOS")
        val flutterskill = intent.getStringExtra("Flutter")
        val language = intent.getStringExtra("Language")
        val hbs = intent.getStringExtra("Hobbies")
        val btnSkills = findViewById<Button>(R.id.skills)
        val btnHobbies = findViewById<Button>(R.id.hobbies)
        val btnLanguage = findViewById<Button>(R.id.language)

        btnSkills.setOnClickListener {
            changeFragment(skills(),"")
        }
        btnHobbies.setOnClickListener {
            changeFragment(hobbies(),"")
        }
        btnLanguage.setOnClickListener {
            changeFragment(language(),"")
        }

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mainmenu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.info -> changeFragment(Result(),"result")
        }
        return super.onOptionsItemSelected(item)
    }

    private fun changeFragment(fragment:Fragment,name:String){
        if(name.isEmpty())
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView,fragment).commit()
        else{
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView,fragment).addToBackStack(name).commit()
        }
    }



}