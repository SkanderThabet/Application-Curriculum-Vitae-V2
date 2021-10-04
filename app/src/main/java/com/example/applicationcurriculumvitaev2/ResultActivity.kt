package com.example.applicationcurriculumvitaev2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val intent = intent
        val FullName = intent.getStringExtra("Name")
        val age = intent.getStringExtra("Age")
        val mail = intent.getStringExtra("Email")
        val gender= intent.getStringExtra("Gender")
        val androidskill=intent.getStringExtra("Android")
        val iosSkill = intent.getStringExtra("iOS")
        val flutterskill = intent.getStringExtra("Flutter")
        val language = intent.getStringExtra("Language")
        val hbs = intent.getStringExtra("Hobbies")

        val name= findViewById<TextView>(R.id.Name)
        val email= findViewById<TextView>(R.id.Email)
        val yearold= findViewById<TextView>(R.id.yearsold)
        val genre= findViewById<TextView>(R.id.genre)
        val android= findViewById<TextView>(R.id.android_skill)
        val ios= findViewById<TextView>(R.id.iOS_skill)
        val flutter= findViewById<TextView>(R.id.Flutter_skill)
        val lang= findViewById<TextView>(R.id.Languages)
        val hobbies= findViewById<TextView>(R.id.hobbies)

        name.text="Name:$FullName"
        email.text="Email:$mail"
        yearold.text="Age:$age"
        genre.text="Gender:$gender"
        android.text="AndroidSkill:$androidskill"
        ios.text="IosSkill:$iosSkill"
        flutter.text="FlutterSkill:$flutterskill"
        lang.text="Languages:$language"
        hobbies.text="Hobbies:$hbs"

    }
}