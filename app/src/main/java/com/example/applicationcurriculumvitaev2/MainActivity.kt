package com.example.applicationcurriculumvitaev2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.core.widget.doOnTextChanged
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = findViewById<TextView>(R.id.NameInput)
        val outlineName = findViewById<TextInputLayout>(R.id.outlined_username)
        val email = findViewById<TextView>(R.id.emailInput)
        val outlineEmail = findViewById<TextInputLayout>(R.id.outlined_email)
        val age = findViewById<TextView>(R.id.ageInput)
        val outlineAge = findViewById<TextInputLayout>(R.id.outlined_age)
        val next = findViewById<Button>(R.id.next)
        val male = findViewById<RadioButton>(R.id.genre_homme)
        val female = findViewById<RadioButton>(R.id.genre_femme)
        val GenderGroup = findViewById<RadioGroup>(R.id.GenderGroup)
        val groupe = GenderGroup.checkedRadioButtonId
        val FM = findViewById<RadioButton>(groupe)

        when {
            email.text.isEmpty() -> next.isEnabled = false
            age.text.isEmpty() -> next.isEnabled = false
            name.text.isEmpty() -> next.isEnabled = false

        }
        name.doOnTextChanged { text, start, before, count ->
            if (text!!.isEmpty()) {
                outlineName.error = "Must not be empty!"
                next.isEnabled = false
            } else {
                outlineName.error = null
                next.isEnabled = !(email.text.isEmpty() && age.text.isEmpty())
            }
        }
        email.doOnTextChanged { text, start, before, count ->
            if (Patterns.EMAIL_ADDRESS.matcher(email.text.toString())
                    .matches()
            ) {
                next.isEnabled = true
                outlineName.error = null
            }
            else if (text!!.isEmpty()) {
                outlineEmail.error = "Must not be empty!"
                next.isEnabled=false
            }
            else {
                outlineEmail.error = null
                email.setError("Check your mail")
                next.isEnabled = !(age.text.isEmpty() && name.text.isEmpty())


            }
        }
        age.doOnTextChanged { text, start, before, count ->
            if (text!!.isEmpty()) {
                outlineAge.error = "Must not be empty!"
                next.isEnabled = false
            } else if (text.length >= 3) {
                outlineAge.error = "Age is wrong!"
                next.isEnabled = false
            } else {
                outlineAge.error = null
                next.isEnabled = !(email.text.isEmpty() && name.text.isEmpty())
            }
        }

        next.setOnClickListener {

            val fullname = name.text.toString()
            val ageV2 = age.text.toString()
            val mail = email.text.toString()
            val genre = FM.text.toString()

            val intent = Intent(this, SkillHobbiesActivity::class.java)
            intent.putExtra("Name", fullname)
            intent.putExtra("Email", mail)
            intent.putExtra("Age", ageV2)
            intent.putExtra("Gender", genre)
            startActivity(intent)

        }

    }
}