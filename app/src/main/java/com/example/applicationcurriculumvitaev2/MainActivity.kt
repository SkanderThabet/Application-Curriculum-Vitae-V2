package com.example.applicationcurriculumvitaev2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Patterns
import android.widget.*
import androidx.core.widget.doOnTextChanged
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    private var uri: Uri? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//Scrollview pour assurer la comptabilité des composants sur tout l'écran
        val name = findViewById<TextView>(R.id.usernameInput)
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

        val picture = findViewById<ImageView>(R.id.useravatar)

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
            } else if (text!!.isEmpty()) {
                outlineEmail.error = "Must not be empty!"
                next.isEnabled = false
            } else {
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
        picture.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, 3)
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
            intent.putExtra("Image", uri.toString())
            println("image : " + uri)
            startActivity(intent)

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val next = findViewById<Button>(R.id.next)
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && data != null) {
            val selectedImage: Uri? = data.data
            val imageView = findViewById<ImageView>(R.id.useravatar)
            imageView.setImageURI(selectedImage)
            uri = selectedImage

        } else {
            next.isEnabled = false
            Toast.makeText(applicationContext, "You haven't picked Image", Toast.LENGTH_LONG)
                .show();

        }
    }


}