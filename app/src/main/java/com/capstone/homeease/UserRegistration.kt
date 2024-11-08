package com.capstone.homeease

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class UserRegistration : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_registration)

        val fullNameEditText = findViewById<EditText>(R.id.fullNameEditText)
        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val passwordConfirmEditText = findViewById<EditText>(R.id.passwordConfirmEditText)
        val continueButton = findViewById<Button>(R.id.registerButton)

        continueButton.setOnClickListener {
            val fullName = fullNameEditText.text.toString().trim()
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()
            val confirmPassword = passwordConfirmEditText.text.toString().trim()

            // Validate if passwords match
            if (password == confirmPassword) {
                if (fullName.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                    Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show()
                    // Proceed to the next screen if needed
                } else {
                    Toast.makeText(this, "All fields must be filled", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
            }
        }
    }
}


