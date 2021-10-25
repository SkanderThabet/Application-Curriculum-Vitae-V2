package com.example.applicationcurriculumvitaev2

import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.MaterialToolbar
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
         * Initialize the toolbar
         */
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

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
        val image = findViewById<ImageView>(R.id.imageView5)
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
        val h_music = bundle?.getBoolean("Music")
        val h_sport = bundle?.getBoolean("Sport")
        val h_games = bundle?.getBoolean("Games")

        /**
         * Languages bundle
         */
        val l_arabic = bundle?.getBoolean("Arabic")
        val l_french = bundle?.getBoolean("French")
        val l_english = bundle?.getBoolean("English")

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
        changeFragment(
            skills.newInstance(AndroidSkillBundle, iOSSkillBundle, FlutterSkillBundle),
            ""
        )

        /**
         * Event listeners to change fragments
         */
        btnSkills.setOnClickListener {
            changeFragment(
                skills.newInstance(
                    AndroidSkillBundle,
                    iOSSkillBundle,
                    FlutterSkillBundle
                ), ""
            )
        }
        btnHobbies.setOnClickListener {
            changeFragment(hobbies.newInstance(h_music, h_sport, h_games), "")
        }
        btnLanguage.setOnClickListener {
            changeFragment(language.newInstance(l_arabic, l_french, l_english), "")
        }

        toolbar.setNavigationOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        /**
         * Career button event
         */
        val careerbtn = findViewById<Button>(R.id.myCareer)
        careerbtn.setOnClickListener {
            val intent = Intent(this, CareerActivity::class.java)
            startActivity(intent)
        }

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mainmenu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val bundle = intent.getBundleExtra("bundle")

        /**
         * Get Shared preference
         */
        val sh:SharedPreferences = this.applicationContext.getSharedPreferences(PREF,
            MODE_PRIVATE)
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
            R.id.logout -> {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Logout")
                builder.setMessage("Are you sure you want to logout ?")
                builder.setPositiveButton(
                    "Yes",
                    DialogInterface.OnClickListener { dialogInterface, i ->
                        sh.edit().clear().apply()
                        finish()
                        dialogInterface.cancel()
                    })
                builder.setNegativeButton(
                    "No",
                    DialogInterface.OnClickListener { dialogInterface, i ->
                        dialogInterface.cancel()
                    })
                val alert:AlertDialog = builder.create()
                alert.show()
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