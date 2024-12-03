package com.capstone.homeease.model

<<<<<<< HEAD
=======
import com.google.gson.annotations.SerializedName

>>>>>>> cfe5a45c11da7916e59ce6b409ec08c6241f7645
data class LoginResponse(
    val message: String,
    val role: String,
    val user_id: Int,
    val address: String?,
    val email: String?,
    val number: Number?,
    val fullName: String?,
    val profileImage: String?
)
<<<<<<< HEAD
=======
data class LoginResponse2(
    @SerializedName("id") val userId: Int,
    @SerializedName("full_name") val fullName: String?,
    @SerializedName("email") val email: String?,
    @SerializedName("phone_number") val number: String?,
    @SerializedName("address") val address: String?,
    @SerializedName("profile_picture") val profilePicture: String?,
    @SerializedName("role") val role: String?,
)
>>>>>>> cfe5a45c11da7916e59ce6b409ec08c6241f7645

