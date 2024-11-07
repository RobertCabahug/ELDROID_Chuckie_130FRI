package com.capstone.homeease

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.capstone.homeease.databinding.ActivityProfilePageBinding // Import the ViewBinding class

class ProfilePageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfilePageBinding // Declare the ViewBinding variable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfilePageBinding.inflate(layoutInflater) // Initialize the ViewBinding
        setContentView(binding.root)

        // Set click listeners for buttons using the ViewBinding
        binding.activity.setOnClickListener {
            //val intent = Intent(this, ActivityPage::class.java)
            //startActivity(intent)
        }
        binding.payment.setOnClickListener {
            //val intent = Intent(this, PaymentPageActivity::class.java)
            //startActivity(intent)
        }
        binding.textHome.setOnClickListener {
            //val intent = Intent(this, UserDashBoard::class.java)
            //startActivity(intent)
        }
        binding.messages.setOnClickListener {
            //val intent = Intent(this, MessagesPageActivity::class.java)
            //startActivity(intent)
        }
        binding.profile.setOnClickListener {
            //val intent = Intent(this, ProfilePageActivity::class.java)
            //startActivity(intent)
        }
        binding.logoutText.setOnClickListener {
            //val intent = Intent(this, HomeActivity::class.java)
            //startActivity(intent)
        }
    }
}
