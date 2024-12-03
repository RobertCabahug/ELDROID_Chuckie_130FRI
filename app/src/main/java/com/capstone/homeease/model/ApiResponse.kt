package com.capstone.homeease.model

data class ApiResponse(
    val success: Boolean,
<<<<<<< HEAD
    val message: String
)

data class ExpertIdResponse(
    val id: Int
)
=======
    val message: String,
    val data: BookingRequest
)

data class ExpertIdResponse(
    val id: Int,
    val message: String
)
data class ApiResponse2(
    val status: String,
    val message: String,
    val data: List<Booking>
)
data class ChangePasswordRequest(
    val current_password: String,
    val new_password: String,
    val new_password_confirmation: String
)
>>>>>>> cfe5a45c11da7916e59ce6b409ec08c6241f7645
