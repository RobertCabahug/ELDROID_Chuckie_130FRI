package com.capstone.homeease.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.capstone.homeease.R
import com.capstone.homeease.model.UserProfile
import com.bumptech.glide.Glide

class UserProfileAdapter(
    private val context: Context,
    private val userProfile: UserProfile
) : RecyclerView.Adapter<UserProfileAdapter.UserProfileViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserProfileViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.fragment_user_profile, parent, false)
        return UserProfileViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserProfileViewHolder, position: Int) {
        // Bind user profile data to the views
        holder.fullNameText.text = userProfile.fullName
        holder.phoneNumberText.text = userProfile.phoneNumber

        // If the profile image URI exists, load it using Glide (assuming profileImage is a URI)
        userProfile.profileImage?.let {
            Glide.with(context).load(it).into(holder.profileImageView)
        }

        // Set onClick listeners for the clickable options
        holder.editProfileText.setOnClickListener { /* Handle Edit Profile */ }
        holder.manageBankText.setOnClickListener { /* Handle Manage Linked Bank Accounts */ }
        holder.manageRewardsText.setOnClickListener { /* Handle Manage My Rewards */ }
        holder.changePasswordText.setOnClickListener { /* Handle Change Password */ }
        holder.bookingHistoryText.setOnClickListener { /* Handle Booking History */ }
    }

    override fun getItemCount(): Int {
        return 1 // Only one user profile is shown
    }

    inner class UserProfileViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profileImageView: ImageView = itemView.findViewById(R.id.profile_image)
        val fullNameText: TextView = itemView.findViewById(R.id.full_name)
        val phoneNumberText: TextView = itemView.findViewById(R.id.phone_number)
        val editProfileText: TextView = itemView.findViewById(R.id.edit_profile)
        val manageBankText: TextView = itemView.findViewById(R.id.manage_bank)
        val manageRewardsText: TextView = itemView.findViewById(R.id.manage_rewards)
        val changePasswordText: TextView = itemView.findViewById(R.id.change_password)
        val bookingHistoryText: TextView = itemView.findViewById(R.id.booking_history)
    }
}
