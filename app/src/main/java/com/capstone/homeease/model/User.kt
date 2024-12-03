package com.capstone.homeease.model
import android.net.Uri

data class User(
    val fullName: String,
    val email: String,
    val password: String,
    val passwordConfirmation: String,
    val address: String,
    val number: String,
    val profileImage: Uri? = null,
    val role: String = "user" // Default role is user
)
<<<<<<< HEAD
=======


>>>>>>> cfe5a45c11da7916e59ce6b409ec08c6241f7645
