package com.capstone.homeease

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.capstone.homeease.databinding.ActivityExpertRegistrationBinding
import java.util.*

class ExpertRegistration : AppCompatActivity() {

    private lateinit var binding: ActivityExpertRegistrationBinding
    private lateinit var selectedProfession: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExpertRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Profession options
        val professions = listOf(
            "Car Washing", "Home Security", "Laundry",
            "Plumbing", "Food Delivery", "Car Rental"
        )

        // Setup profession spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, professions)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.professionSpinner.adapter = adapter

        binding.professionSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                selectedProfession = parent.getItemAtPosition(position) as String
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // No selection
            }
        }

        binding.submitButton.setOnClickListener {
            val fullName = binding.fullNameEditText.text.toString().trim()
            val email = binding.emailEditText.text.toString().trim()
            val password = binding.passwordEditText.text.toString().trim()
            val dateOfBirth = binding.dateOfBirthEditText.text.toString().trim()

            if (fullName.isEmpty() || email.isEmpty() || password.isEmpty() || dateOfBirth.isEmpty()) {
                Toast.makeText(this, "All fields must be filled", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Registration completed locally", Toast.LENGTH_SHORT).show()
                // Proceed to next steps as necessary
            }
        }
    }

    // Date picker dialog setup
    fun showDatePickerDialog(view: View) {
        val c = Calendar.getInstance()
        val year = c[Calendar.YEAR]
        val month = c[Calendar.MONTH]
        val day = c[Calendar.DAY_OF_MONTH]

        val datePickerDialog = DatePickerDialog(this,
            { _, year, monthOfYear, dayOfMonth ->
                binding.dateOfBirthEditText.setText("${monthOfYear + 1}/$dayOfMonth/$year")
            }, year, month, day
        )
        datePickerDialog.show()
    }
}



