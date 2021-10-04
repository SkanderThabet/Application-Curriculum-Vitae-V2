package com.example.applicationcurriculumvitaev2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import androidx.core.widget.doOnTextChanged
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = findViewById<TextView>(R.id.NameInput)
        val outlineName= findViewById<TextInputLayout>(R.id.outlined_username)
        val email = findViewById<TextView>(R.id.emailInput)
        val outlineEmail= findViewById<TextInputLayout>(R.id.outlined_email)
        val age = findViewById<TextView>(R.id.ageInput)
        val outlineAge= findViewById<TextInputLayout>(R.id.outlined_age)

        name.doOnTextChanged { text, start, before, count ->
            if(text!!.isEmpty()){
                outlineName.error="Must not be empty!"
            }
            else{
                outlineName.error=null
            }
        }
        email.doOnTextChanged { text, start, before, count ->
            if(text!!.isEmpty()){
                outlineEmail.error="Must not be empty!"
            }
            else{
                outlineEmail.error=null
            }
        }
        age.doOnTextChanged { text, start, before, count ->
            if(text!!.isEmpty()){
                outlineAge.error="Must not be empty!"
            }
            else if (text.length >= 3){
                outlineAge.error="Age is wrong!"
            }
            else{
                outlineAge.error=null
            }
        }

    }
}