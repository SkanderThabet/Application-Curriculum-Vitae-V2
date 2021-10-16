package com.example.applicationcurriculumvitaev2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import org.w3c.dom.Text

class ResultActivity : AppCompatActivity() {

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
        val username = findViewById<TextView>(R.id.username)
        username.text = FullName
        val usermail = findViewById<TextView>(R.id.usermail)
        usermail.text = mail
        val bundle = intent.getBundleExtra("bundle")
        val AndroidSkillBundle = bundle?.getInt("Android")

        /**
         * Test with println
         */
        println("This is bundle: " + (bundle?.getString("Name") ?: "Default"))
        println("Android skill : ${AndroidSkillBundle}")

        /**
         * Bundle strings
         */
        val nameBundle = bundle?.getString("Name")
        val emailBundle = bundle?.getString("Email")
        val ageBundle = bundle?.getString("Age")
        val genderBundle = bundle?.getString("Gender")


        btnSkills.setOnClickListener {
            skills.newInstance(80)
            changeFragment(skills(), "")
        }
        btnHobbies.setOnClickListener {
            changeFragment(hobbies(), "")
        }
        btnLanguage.setOnClickListener {
            changeFragment(language(), "")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mainmenu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val bundle:Bundle? = Bundle()
        val nameBundle = bundle?.getString("Name")
        val emailBundle = bundle?.getString("Email")
        val ageBundle = bundle?.getString("Age")
        val genderBundle = bundle?.getString("Gender")
        when (item.itemId) {
            R.id.info -> {
                changeFragment(Result.newInstance(nameBundle,ageBundle,emailBundle,genderBundle), "")
            }
        }
        return super.onOptionsItemSelected(item)
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