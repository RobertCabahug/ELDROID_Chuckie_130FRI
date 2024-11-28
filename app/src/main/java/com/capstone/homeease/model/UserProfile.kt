package com.capstone.homeease.model
import android.net.Uri

data class UserProfile(
    val fullName: String,
    val phoneNumber: String,
    val email: String,
    val address: String,
    val number: String,
    val profileImage: Uri? = null
)
