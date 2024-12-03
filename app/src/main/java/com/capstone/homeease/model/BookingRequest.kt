package com.capstone.homeease.model

<<<<<<< HEAD
data class BookingRequest(
    val userId: Int,
    val expertId: Int,
    val expertName: String,
    val userName: String,
    val expertAddress: String,
    val userAddress: String,
    val status: String,
    val timestamp: String // Ensure this is a properly formatted date string, not a long
=======

data class BookingRequest(
    val user_id: Int,
    val expert_id: Int?,
    val expert_name: String,
    val user_name: String,
    val status: String,
    val timestamp: String,
    val note: String,
    val rate: String,
    val expert_address: String,
    val user_address: String,
)
data class BookingRequest2(
    val bookings: List<Booking>
>>>>>>> cfe5a45c11da7916e59ce6b409ec08c6241f7645
)