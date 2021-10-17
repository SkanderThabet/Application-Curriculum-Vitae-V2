package com.example.applicationcurriculumvitaev2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.Button
import android.widget.CheckBox
import android.widget.FrameLayout
import android.widget.SeekBar
import androidx.fragment.app.Fragment

class SkillHobbiesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill_hobbies)
        val androidSkill = findViewById<SeekBar>(R.id.seekBar_android)
        val iosSkill = findViewById<SeekBar>(R.id.seekBar_ios)
        val flutterSkill = findViewById<SeekBar>(R.id.seekBar_flutter)
        val arabic = findViewById<CheckBox>(R.id.checkBox_arabic)
        val french = findViewById<CheckBox>(R.id.checkbox_french)
        val english = findViewById<CheckBox>(R.id.checkBox_english)
        val music = findViewById<CheckBox>(R.id.checkBox_music)
        val sport = findViewById<CheckBox>(R.id.checkBox_sport)
        val games = findViewById<CheckBox>(R.id.checkBox_game)
        val submit = findViewById<Button>(R.id.SUBMIT)

        val intent = intent
        val name = intent.getStringExtra("Name")
        val age = intent.getStringExtra("Age")
        val mail = intent.getStringExtra("Email")
        val genre = intent.getStringExtra("Gender")
        val image= intent.getStringExtra("Image")

        submit.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            val lang = when {
                arabic.isChecked && french.isChecked && english.isChecked -> "Arabic French English"
                arabic.isChecked && french.isChecked -> "Arabic French"
                arabic.isChecked && english.isChecked -> "Arabic English"
                french.isChecked && english.isChecked -> "French English"
                arabic.isChecked -> "Arabic"
                french.isChecked -> "French"
                english.isChecked -> "English"

                else -> "None"
            }
            val hb = when {
                music.isChecked && sport.isChecked && games.isChecked -> "Music Sport Games"
                sport.isChecked && games.isChecked -> "Sport Games"
                sport.isChecked && music.isChecked -> "Sport Music"
                games.isChecked && music.isChecked -> "Games Music"
                games.isChecked -> "Games"
                sport.isChecked -> "Sport"
                music.isChecked -> "Music"
                else -> "None"
            }
            val bundle=Bundle()

            bundle.putString("Name",name)
            bundle.putString("Age",age)
            bundle.putString("Email",mail)
            bundle.putString("Gender",genre)
            bundle.putInt("Android",androidSkill.progress)
            bundle.putInt("iOS",iosSkill.progress)
            bundle.putInt("Flutter",flutterSkill.progress)
            bundle.putBoolean("Music",music.isChecked)
            bundle.putBoolean("Sport",sport.isChecked)
            bundle.putBoolean("Games",games.isChecked)
            bundle.putBoolean("Arabic",arabic.isChecked)
            bundle.putBoolean("French",french.isChecked)
            bundle.putBoolean("English",english.isChecked)
            intent.putExtra("Android", androidSkill.progress.toString())
            intent.putExtra("iOS", iosSkill.progress.toString())
            intent.putExtra("Flutter", flutterSkill.progress.toString())
            intent.putExtra("Language", lang)
            intent.putExtra("Hobbies", hb)
            intent.putExtra("Name", name)
            intent.putExtra("Age", age)
            intent.putExtra("Email", mail)
            intent.putExtra("Gender", genre)
            intent.putExtra("bundle",bundle)
            intent.putExtra("Image",image)
            startActivity(intent)
        }
    }


}