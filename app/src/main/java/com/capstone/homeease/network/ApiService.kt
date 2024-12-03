package com.capstone.homeease.network

<<<<<<< HEAD

import com.capstone.homeease.model.ApiResponse
import com.capstone.homeease.model.ChangePasswordRequest
import com.capstone.homeease.model.ExpertIdResponse
import com.capstone.homeease.model.ExpertProfileResponse
import com.capstone.homeease.model.LoginResponse
import com.capstone.homeease.model.LoginResponse2

import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body

import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
=======
import com.capstone.homeease.model.LoginRequest
import com.capstone.homeease.model.LoginResponse
import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
>>>>>>> cfe5a45c11da7916e59ce6b409ec08c6241f7645
import retrofit2.http.GET

import retrofit2.http.Multipart
import retrofit2.http.POST
<<<<<<< HEAD
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.PartMap
import retrofit2.http.Path
import retrofit2.http.Query
=======
import retrofit2.http.Part
import retrofit2.http.PartMap
>>>>>>> cfe5a45c11da7916e59ce6b409ec08c6241f7645


interface ApiService {

    @Multipart
<<<<<<< HEAD
    @POST("register/expert")
=======
    @POST("register/expert")  // Ensure this matches the endpoint in Laravel
>>>>>>> cfe5a45c11da7916e59ce6b409ec08c6241f7645
    fun registerExpertWithImage(
        @PartMap fields: HashMap<String, String>,
        @Part image: MultipartBody.Part?
    ): Call<ResponseBody>

<<<<<<< HEAD
    @GET("expert/by-email/{email}")
    fun getExpertIdByEmail(
        @Query("email") email: String
    ): Call<ExpertIdResponse>

    @GET("user-profile")
    fun getUserProfile(
        @Query("id") userId: Int // Use @Query to pass the userId as a query parameter
    ): Call<LoginResponse2>
    @GET("expert-profile")
    fun getExpertProfile(@Query("userId") userId: Int): Call<ExpertProfileResponse>
    @FormUrlEncoded
    @PUT("/api/user/{userId}")
    fun updateUserProfile(
        @Path("userId") userId: String,
        @Field("full_name") fullName: String,
        @Field("email") email: String,
        @Field("address") address: String,
        @Field("phone_number") number: String
    ): Call<Void>
    @FormUrlEncoded
    @PUT("/api/expert/update/{id}")
    fun updateExpertProfile(
        @Path("id") userId: String,
        @Field("full_name") fullName: String,
        @Field("email") email: String,
        @Field("address") address: String,
        @Field("phone_number") phoneNumber: String,
        @Field("profession") profession: String,
        @Field("date_of_birth") dateOfBirth: String
    ): Call<Void>
    @POST("change-password/{userId}")
    fun changePassword(
        @Path("userId") userId: String,
        @Body request: ChangePasswordRequest
    ): Call<ApiResponse>


=======

    companion object {
        private const val BASE_URL = "http://10.0.2.2:8000/api/"

        fun create(): ApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }
>>>>>>> cfe5a45c11da7916e59ce6b409ec08c6241f7645
}

