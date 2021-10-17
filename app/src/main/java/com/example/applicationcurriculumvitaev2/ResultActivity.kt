package com.example.applicationcurriculumvitaev2

import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import org.w3c.dom.Text

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        /**
         * Initialize the intent
         */
        val intent = intent

        /**
         * Call the vals from the previous intent to get their data
         */
        val FullName = intent.getStringExtra("Name")
        val age = intent.getStringExtra("Age")
        val mail = intent.getStringExtra("Email")
        val gender = intent.getStringExtra("Gender")
        val androidskill = intent.getStringExtra("Android")
        val iosSkill = intent.getStringExtra("iOS")
        val flutterskill = intent.getStringExtra("Flutter")
        val languages = intent.getStringExtra("Language")
        val hbs = intent.getStringExtra("Hobbies")
        val img = intent.getStringExtra("Image")
        val fileUri = Uri.parse(img)


        /**
         * Calling component's layout
         */
        val btnSkills = findViewById<Button>(R.id.skills)
        val btnHobbies = findViewById<Button>(R.id.hobbies)
        val btnLanguage = findViewById<Button>(R.id.language)
        val username = findViewById<TextView>(R.id.username)
        val image=findViewById<ImageView>(R.id.imageView5)
        username.text = FullName
        val usermail = findViewById<TextView>(R.id.usermail)
        usermail.text = mail
        image.setImageURI(fileUri)
        /**
         * Calling the bundle from the previous activity passed as intent
         */
        val bundle = intent.getBundleExtra("bundle")

        /**
         * Skills bundle
         */
        val AndroidSkillBundle = bundle?.getInt("Android")
        val iOSSkillBundle = bundle?.getInt("iOS")
        val FlutterSkillBundle = bundle?.getInt("Flutter")

        /**
         * Hobbies bundle
         */
        val h_music=bundle?.getBoolean("Music")
        val h_sport=bundle?.getBoolean("Sport")
        val h_games=bundle?.getBoolean("Games")

        /**
         * Languages bundle
         */
        val l_arabic=bundle?.getBoolean("Arabic")
        val l_french=bundle?.getBoolean("French")
        val l_english=bundle?.getBoolean("English")

        /**
         * Test with println
         */
        println("This is bundle: " + (bundle?.getString("Name") ?: "Default"))
        println("Android skill : ${AndroidSkillBundle}")

        /**
         * Image bundle consumption
         *
         */
//        val extras = getIntent().extras
//        val path: Uri = extras?.get("img") as Uri
//        image.setImageURI(path)


        /**
         * Default Fragment
         */
        changeFragment(skills.newInstance(AndroidSkillBundle,iOSSkillBundle,FlutterSkillBundle), "")

        /**
         * Event listeners to change fragments
         */
        btnSkills.setOnClickListener {
            changeFragment(skills.newInstance(AndroidSkillBundle,iOSSkillBundle,FlutterSkillBundle), "")
        }
        btnHobbies.setOnClickListener {
            changeFragment(hobbies.newInstance(h_music,h_sport,h_games), "")
        }
        btnLanguage.setOnClickListener {
            changeFragment(language.newInstance(l_arabic,l_french,l_english), "")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mainmenu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val bundle=intent.getBundleExtra("bundle")

        /**
         * Bundle strings
         */
        val nameBundle = bundle?.getString("Name")
        val emailBundle = bundle?.getString("Email")
        val ageBundle = bundle?.getString("Age")
        val genderBundle = bundle?.getString("Gender")

        when (item.itemId) {
            R.id.info -> {
                changeFragment(
                    Result.newInstance(nameBundle, ageBundle, emailBundle, genderBundle),
                    ""
                )
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