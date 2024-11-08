package com.capstone.homeease

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.capstone.homeease.databinding.ActivityUserDashBoardBinding // Import the ViewBinding class

class UserDashBoard : AppCompatActivity() {

    private lateinit var binding: ActivityUserDashBoardBinding // Declare the ViewBinding variable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserDashBoardBinding.inflate(layoutInflater) // Initialize the ViewBinding
        setContentView(binding.root)

        // Set click listeners for buttons using the ViewBinding
        binding.washing.setOnClickListener {
            val intent = Intent(this, AvailableExpertsActivity::class.java)
            startActivity(intent)
        }
        binding.security.setOnClickListener {
            val intent = Intent(this, AvailableExpertsActivity::class.java)
            startActivity(intent)
        }
        binding.homeservice.setOnClickListener {
            val intent = Intent(this, AvailableExpertsActivity::class.java)
            startActivity(intent)
        }
        binding.laundry.setOnClickListener {
            val intent = Intent(this, AvailableExpertsActivity::class.java)
            startActivity(intent)
        }
        binding.plumber.setOnClickListener {
            val intent = Intent(this, AvailableExpertsActivity::class.java)
            startActivity(intent)
        }
        binding.delivery.setOnClickListener {
            val intent = Intent(this, AvailableExpertsActivity::class.java)
            startActivity(intent)
        }
        binding.renting.setOnClickListener {
            val intent = Intent(this, AvailableExpertsActivity::class.java)
            startActivity(intent)
        }
        binding.activity.setOnClickListener {
            val intent = Intent(this, ActivityPage::class.java)
            startActivity(intent)
        }
        binding.payment.setOnClickListener {
            val intent = Intent(this, PaymentPageActivity::class.java)
            startActivity(intent)
        }
        binding.textHome.setOnClickListener {
            val intent = Intent(this, UserDashBoard::class.java)
            startActivity(intent)
        }
        binding.messages.setOnClickListener {
            val intent = Intent(this, MessagesPageActivity::class.java)
            startActivity(intent)
        }
        binding.profile.setOnClickListener {
            val intent = Intent(this, ProfilePageActivity::class.java)
            startActivity(intent)
        }
    }
}
