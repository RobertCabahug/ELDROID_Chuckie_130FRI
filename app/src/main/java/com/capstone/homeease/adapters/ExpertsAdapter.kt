package com.capstone.homeease.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.capstone.homeease.R
import com.capstone.homeease.model.ApiResponse
import com.capstone.homeease.model.BookingRequest
import com.capstone.homeease.model.Expert
import com.capstone.homeease.model.ExpertIdResponse
<<<<<<< HEAD
import com.capstone.homeease.network.LaravelApi
import com.capstone.homeease.utils.SharedPreferencesHelper.getUserIdFromSession
import com.capstone.homeease.utils.SharedPreferencesHelper.getUserNameFromSession
import com.google.gson.Gson
import com.google.gson.GsonBuilder
=======
import com.capstone.homeease.model.LoginResponse2
import com.capstone.homeease.network.LaravelApi
import com.capstone.homeease.network.RetrofitClient
import com.capstone.homeease.utils.SharedPreferencesHelper
import com.capstone.homeease.view.ExpertDashBoardFragment
import com.capstone.homeease.view.UserDashBoardFragment
>>>>>>> cfe5a45c11da7916e59ce6b409ec08c6241f7645
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.SimpleDateFormat
<<<<<<< HEAD
import java.util.*

class ExpertsAdapter(
    private val context: Context,
    private var experts: List<Expert> // Make this a mutable list so we can update it
) : RecyclerView.Adapter<ExpertsAdapter.ExpertViewHolder>() {
=======
import java.util.Date
import java.util.Locale

class ExpertsAdapter(
    private val context: Context,
    private var experts: MutableList<Expert>,
    private val expertIdMap: Map<String, Int>
) : RecyclerView.Adapter<ExpertsAdapter.ExpertViewHolder>() {
    private val apiService: LaravelApi = RetrofitClient.createService(LaravelApi::class.java)
>>>>>>> cfe5a45c11da7916e59ce6b409ec08c6241f7645

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpertViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_expert, parent, false)
        return ExpertViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExpertViewHolder, position: Int) {
        val expert = experts[position]
<<<<<<< HEAD
        Log.d("ExpertsAdapter", "Expert Full Name: ${expert.fullName}, Address: ${expert.address}")
=======
        holder.bind(expert, position, context, apiService, experts)
        Log.d("ExpertsAdapter", "Binding expert: ${expert.fullName}, Address: ${expert.address}")

>>>>>>> cfe5a45c11da7916e59ce6b409ec08c6241f7645
        holder.fullNameTextView.text = expert.fullName
        holder.addressTextView.text = expert.address

        // Load expert profile image if available
        expert.profileImage?.let {
<<<<<<< HEAD
=======
            Log.d("ExpertsAdapter", "Loading profile image for: ${expert.fullName}")
>>>>>>> cfe5a45c11da7916e59ce6b409ec08c6241f7645
            Picasso.get()
                .load(it)
                .placeholder(R.drawable.img) // Add placeholder
                .into(holder.profileImageView)
        }

<<<<<<< HEAD
        // Set up the Book Now button click listener
        holder.bookNowButton.setOnClickListener {
            val userId = getUserIdFromSession(context)
            val userName = getUserNameFromSession(context)
            if (userId == null) {
                Toast.makeText(context, "Please log in to book an expert", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val gson: Gson = GsonBuilder().setLenient().create()


            val retrofit = Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8000/api/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()


            val apiService = retrofit.create(LaravelApi::class.java)


            // Fetch the expert's ID by email
            apiService.getExpertIdByEmail(expert.email).enqueue(object : Callback<ExpertIdResponse> {
                override fun onResponse(call: Call<ExpertIdResponse>, response: Response<ExpertIdResponse>) {
                    if (response.isSuccessful) {
                        val expertId = response.body()?.id
                        Log.d("API Response", "Expert: $expert")

                        if (expertId != null) {
                            // Convert current time to a formatted date string
                            val timestamp = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Date())
                            Log.d("BookingRequest", "User Name: $userName")

                            // Create the booking data
                            val bookingData = BookingRequest(
                                userId = userId,
                                expertId = expertId,
                                expertName = expert.fullName,
                                expertAddress = expert.address,
                                userAddress = "address",
                                userName = "name", // Corrected to user's name
                                status = "Pending",
                                timestamp = timestamp
                            )

                            // Send the booking request to the backend
                            apiService.bookExpert(bookingData).enqueue(object : Callback<ApiResponse> {
                                override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                                    if (response.isSuccessful) {
                                        Log.d("Booking Success", "Response: ${response.body()}")
                                        Toast.makeText(context, "Booking request sent successfully", Toast.LENGTH_SHORT).show()
                                    } else {
                                        Log.e("Booking Error", "Error: ${response.errorBody()?.string()}")
                                        Log.e("ExpertsAdapter", "Error creating booking: ${response.errorBody()?.string()}")
                                        Toast.makeText(context, "Failed to send booking request", Toast.LENGTH_SHORT).show()
                                    }
                                }

                                override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                                    Log.e("ExpertsAdapter", "Network error: ${t.message}")
                                    Toast.makeText(context, "Network error, please try again", Toast.LENGTH_SHORT).show()
                                }
                            })
                        } else {
                            Toast.makeText(context, "Failed to fetch expert ID", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        Log.e("ExpertsAdapter", "Error fetching expert ID: ${response.errorBody()?.string()}")
                        Toast.makeText(context, "Failed to fetch expert details", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<ExpertIdResponse>, t: Throwable) {
                    Log.e("ExpertsAdapter", "Network error: ${t.message}")
                    Toast.makeText(context, "Network error, please try again", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }


    override fun getItemCount(): Int = experts.size


    fun updateExperts(expertsList: List<Expert>) {
        experts = expertsList
=======
        val expertId = expertIdMap[expert.email]
        Log.d("ExpertsAdapter", "Expert ID from map: $expertId") // Log the expert ID from the map

        // Set up the Book Now button click listener
        holder.bookNowButton.setOnClickListener {
            // Dynamically fetch the current position
            val currentPosition = holder.adapterPosition
            if (currentPosition == RecyclerView.NO_POSITION) {
                Log.w("ExpertsAdapter", "Invalid adapter position")
                return@setOnClickListener
            }

            val currentExpert = experts[currentPosition] // Get the expert at the current position
            val expertId = expertIdMap[currentExpert.email]
            val userId = SharedPreferencesHelper.getUserIdFromSession(context)

            Log.d("ExpertsAdapter", "Fetching profile for User ID: $userId")

            // Fetch the user's profile
            apiService.getUserProfile2(userId).enqueue(object : Callback<LoginResponse2> {
                override fun onResponse(call: Call<LoginResponse2>, response: Response<LoginResponse2>) {
                    if (response.isSuccessful) {
                        val userProfile = response.body()
                        val userName = userProfile?.fullName ?: "Unknown User"

                        Log.d("ExpertsAdapter", "Fetched username: $userName")

                        val currentTimestamp = SimpleDateFormat(
                            "yyyy-MM-dd HH:mm:ss", Locale.getDefault()
                        ).format(Date())

                        val bookingRequest = BookingRequest(
                            user_id = userId,
                            expert_id = expertId ?: 1, // Fallback if expertId is null
                            expert_name = currentExpert.fullName,
                            user_name = userName,
                            status = "pending",
                            timestamp = currentTimestamp,
                            note = "Booking request from user.",
                            rate = "300",
                            expert_address = currentExpert.address,
                            user_address = userProfile?.address ?: "Default Address"
                        )

                        // Make the API call to book the expert
                        Log.d("ExpertsAdapter", "Booking request: $bookingRequest")
                        bookExpert(bookingRequest, currentPosition)
                    } else {
                        Log.e("ExpertsAdapter", "Failed to fetch user profile. Error: ${response.message()}")
                        Toast.makeText(context, "Failed to fetch user profile.", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<LoginResponse2>, t: Throwable) {
                    Log.e("ExpertsAdapter", "Error fetching user profile: ${t.message}")
                    Toast.makeText(context, "Error fetching user profile.", Toast.LENGTH_SHORT).show()
                }
            })
        }

    }

    override fun getItemCount(): Int = experts.size

    private fun bookExpert(
        bookingRequest: BookingRequest,
        position: Int
    ) {
        apiService.bookExpert(bookingRequest).enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        Log.d("ExpertsAdapter", "Booking Successful! Response: $responseBody")
                        Toast.makeText(context, "Booking Successful!", Toast.LENGTH_SHORT).show()

                        // Remove the expert from the list
                        if (position != RecyclerView.NO_POSITION) {
                            experts.removeAt(position) // Remove the expert from the list
                            notifyItemRemoved(position) // Notify the adapter about the removal
                            notifyItemRangeChanged(position, experts.size) // Update remaining items
                        } else {
                            Log.w("ExpertsAdapter", "Invalid position, item not removed.")
                        }
                    } else {
                        Log.d("ExpertsAdapter", "Empty response body")
                        Toast.makeText(
                            context,
                            "Booking Successful, but empty response body.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    Log.e("ExpertsAdapter", "Booking Failed. Error: ${response.message()}")
                    Toast.makeText(
                        context,
                        "Booking Failed. Error: ${response.message()}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Log.e("ExpertsAdapter", "API Request failed: ${t.message}")
                Toast.makeText(context, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }



    fun updateExperts(expertsList: List<Expert>) {
        experts = expertsList.toMutableList()
>>>>>>> cfe5a45c11da7916e59ce6b409ec08c6241f7645
        notifyDataSetChanged()
    }

    class ExpertViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val fullNameTextView: TextView = itemView.findViewById(R.id.fullNameTextView)
        val addressTextView: TextView = itemView.findViewById(R.id.address)
        val profileImageView: ImageView = itemView.findViewById(R.id.expertImageView)
        val bookNowButton: Button = itemView.findViewById(R.id.bookNowButton)
<<<<<<< HEAD
=======
        fun bind(
            expert: Expert,
            position: Int,
            context: Context,
            apiService: LaravelApi,
            experts: MutableList<Expert>
        ) {
            fullNameTextView.text = expert.fullName
            addressTextView.text = expert.address

            expert.profileImage?.let {
                Picasso.get()
                    .load(it)
                    .placeholder(R.drawable.img) // Add placeholder
                    .into(profileImageView)
            }
        }
>>>>>>> cfe5a45c11da7916e59ce6b409ec08c6241f7645
    }
}
