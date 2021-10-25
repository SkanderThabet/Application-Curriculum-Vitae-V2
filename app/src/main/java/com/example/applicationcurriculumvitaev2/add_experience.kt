package com.example.applicationcurriculumvitaev2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.widget.doOnTextChanged
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.textfield.TextInputLayout

class add_experience : AppCompatActivity() {
    private var uri: Uri? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_experience)

        /**
         * Toolbar
         */
        val toolbar = findViewById<Toolbar>(R.id.toolbarexp)
        setSupportActionBar(toolbar)

        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        /**
         * Init
         */
        val companyname = findViewById<TextView>(R.id.companyNameInput)
        val outlinecompanyname = findViewById<TextInputLayout>(R.id.outlined_companyname)
        val companyaddr = findViewById<TextView>(R.id.companyAddressInput)
        val outlinecompanyaddr = findViewById<TextInputLayout>(R.id.outlined_companyaddress)
        val savebtn = findViewById<Button>(R.id.save)
        val outlinedatestart = findViewById<TextInputLayout>(R.id.outlined_date_start_ex)
        val outlinedateend = findViewById<TextInputLayout>(R.id.outlined_date_end_ex)

        companyname.doOnTextChanged { text, start, before, count ->
            if (text!!.isEmpty()) {
                outlinecompanyname.error = "Must not be empty"
                savebtn.isEnabled = false
            } else {
                outlinecompanyname.error = null
                savebtn.isEnabled = !(companyaddr.text.isEmpty())
            }
        }
        companyaddr.doOnTextChanged { text, start, before, count ->
            if (text!!.isEmpty()) {
                outlinecompanyaddr.error = "Must not be empty"
                savebtn.isEnabled = false
            } else {
                outlinecompanyaddr.error = null
                savebtn.isEnabled = !(companyname.text.isEmpty())
            }
        }

        /**
         * DatePicker Start
         * Remarque ! : b -> hasWindowFocus() , it's a must to make a conditional statement for b so we won't get two popups
         * if there's a problem on first touch popup , in the XML put android:focusable="false"
         *
         */
        val datePicker_start =
            MaterialDatePicker.Builder.datePicker()
                .setTitleText("SELECT START DATE")
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .build()
        val startdate = findViewById<TextView>(R.id.startDateInput_ex)
        startdate.setOnFocusChangeListener { view, b ->
            if (b) {
                datePicker_start.show(supportFragmentManager, datePicker_start.toString())
            } else {
                datePicker_start.isHidden
            }
        }

        /**
         * DataPicker Start Focus listener
         */

        datePicker_start.addOnPositiveButtonClickListener {
            startdate.text = datePicker_start.headerText
        }
        datePicker_start.addOnCancelListener {
            if (datePicker_start.headerText.isEmpty()) {
                savebtn.isEnabled = false
                outlinedatestart.error = "Must not be empty"
            } else {
                savebtn.isEnabled
                outlinedatestart.error = null
            }
        }

        /**
         * Datapicker End
         */

        val datePicker_end =
            MaterialDatePicker.Builder.datePicker()
                .setTitleText("SELECT END DATE")
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .build()
        val enddate = findViewById<TextView>(R.id.endDateInput_ex)

        /**
         * DatePicker End focus listener
         *
         */

        enddate.setOnFocusChangeListener { view, b ->
            if (b) {
                datePicker_end.show(supportFragmentManager, datePicker_end.toString())
            } else {
                datePicker_end.isHidden
            }
        }
        datePicker_end.addOnPositiveButtonClickListener {
            enddate.text = datePicker_end.headerText
        }
        datePicker_end.addOnCancelListener {
            if (datePicker_end.headerText.isEmpty()) {
                savebtn.isEnabled = false
                outlinedateend.error = "Must not be empty"
            } else {
                savebtn.isEnabled
                outlinedateend.error = null
            }
        }

        /**
         * Image View init & on click listener event
         */
        val image = findViewById<ImageView>(R.id.imageinsertex)
        image.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, 3)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && data != null) {
            val selectedImage: Uri? = data.data
            val imageView = findViewById<ImageView>(R.id.imageinsertex)
            imageView.setImageURI(selectedImage)
            uri = selectedImage

        } else {
            Toast.makeText(applicationContext, "You haven't picked Image", Toast.LENGTH_LONG)
                .show();

        }
    }
}

