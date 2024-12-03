package com.capstone.homeease.model

<<<<<<< HEAD
data class Booking(
    var id: String = "",
    var expertId: String = "",
    var expertName: String = "",
    var userId: String = "",
    var userName: String = "",
    var status: String = "",
    val timestamp: Long = 0L,
    var note: String = "",
    var rate: String = "",
    var expertAddress: String = "",
    var expertImageUrl: String = "",
    var userAddress: String = ""
)
=======
import com.google.gson.annotations.SerializedName

data class Booking(
    var id: String = "",
    @SerializedName("expert_id")var expertId: String = "",
    @SerializedName("expert_name") val expertName: String,
    @SerializedName("user_name") val userName: String,
    var status: String,
    val timestamp: String,
    val note: String,
    val rate: String,
    @SerializedName("expert_address") val expertAddress: String,
    @SerializedName("expert_image_url")var expertImageUrl: String?,
    @SerializedName("user_address")var userAddress: String = ""
)

>>>>>>> cfe5a45c11da7916e59ce6b409ec08c6241f7645
