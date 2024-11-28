package com.capstone.homeease.controller

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.capstone.homeease.R
import com.capstone.homeease.model.UserProfile
import com.capstone.homeease.network.LaravelApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserProfileController : Fragment(R.layout.fragment_user_profile) {

    private lateinit var greetingText: TextView
    private lateinit var fullNameText: TextView
    private lateinit var phoneNumberText: TextView
    private lateinit var editProfileText: TextView
    private lateinit var manageBankText: TextView
    private lateinit var manageRewardsText: TextView
    private lateinit var changePasswordText: TextView
    private lateinit var bookingHistoryText: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        greetingText = view.findViewById(R.id.greeting_text)
        fullNameText = view.findViewById(R.id.full_name)
        phoneNumberText = view.findViewById(R.id.phone_number)
        editProfileText = view.findViewById(R.id.edit_profile)
        manageBankText = view.findViewById(R.id.manage_bank)
        manageRewardsText = view.findViewById(R.id.manage_rewards)
        changePasswordText = view.findViewById(R.id.change_password)
        bookingHistoryText = view.findViewById(R.id.booking_history)

        // Fetch user profile
        fetchUserProfile(123) // Replace with actual user ID
    }

    private fun fetchUserProfile(userId: Int) {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8000/api/profile/user") // Replace with your API base URL
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(LaravelApi::class.java)
        service.getUsersProfile(userId).enqueue(object : Callback<UserProfile> {
            override fun onResponse(call: Call<UserProfile>, response: Response<UserProfile>) {
                if (response.isSuccessful) {
                    val userProfile = response.body()
                    userProfile?.let {
                        greetingText.text = "Maayong Adlaw"
                        fullNameText.text = it.fullName
                        phoneNumberText.text = it.phoneNumber
                        // If there is a profile image, set it here (e.g., using Glide)
                    }
                } else {
                    Toast.makeText(context, "Failed to fetch profile", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<UserProfile>, t: Throwable) {
                Toast.makeText(context, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
