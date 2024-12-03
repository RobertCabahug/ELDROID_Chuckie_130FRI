package com.capstone.homeease.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.capstone.homeease.R
import com.capstone.homeease.adapters.ExpertBookingsAdapter
import com.capstone.homeease.adapters.OngoingBookingsAdapter
import com.capstone.homeease.databinding.FragmentExpertDashBoardBinding
<<<<<<< HEAD
import com.capstone.homeease.model.ApiResponse2
=======
>>>>>>> cfe5a45c11da7916e59ce6b409ec08c6241f7645
import com.capstone.homeease.model.Booking
import com.capstone.homeease.model.ExpertProfileResponse
import com.capstone.homeease.network.LaravelApi
import com.capstone.homeease.utils.SharedPreferencesHelper.getUserId
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ExpertDashBoardFragment : Fragment(R.layout.fragment_expert_dash_board) {

    private lateinit var binding: FragmentExpertDashBoardBinding
    private lateinit var expertBookingsAdapter: ExpertBookingsAdapter
    private lateinit var ongoingBookingsAdapter: OngoingBookingsAdapter

<<<<<<< HEAD
    private var allBookings: List<Booking> = emptyList()

=======
>>>>>>> cfe5a45c11da7916e59ce6b409ec08c6241f7645
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentExpertDashBoardBinding.inflate(inflater, container, false)

        // Initialize RecyclerViews
        binding.bookingsRecyclerView.layoutManager =
<<<<<<< HEAD
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false) // Vertical layout
        binding.ongoingBookingsRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false) // Vertical layout

        // Initialize both adapters with empty lists initially
=======
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.ongoingBookingsRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        // Initialize both adapters
>>>>>>> cfe5a45c11da7916e59ce6b409ec08c6241f7645
        expertBookingsAdapter = ExpertBookingsAdapter(requireContext(), emptyList())
        ongoingBookingsAdapter = OngoingBookingsAdapter(requireContext(), emptyList())

        // Set the adapters for the RecyclerViews
        binding.bookingsRecyclerView.adapter = expertBookingsAdapter
        binding.ongoingBookingsRecyclerView.adapter = ongoingBookingsAdapter

        // Set click listeners for ImageViews (Navigation)
        setNavigationListeners()

        // Load expert profile and bookings
        loadExpertProfile()
<<<<<<< HEAD
        fetchExpertBookings() // Fetch all expert bookings and categorize
=======
        fetchBookings()
        fetchOngoingBookings()
>>>>>>> cfe5a45c11da7916e59ce6b409ec08c6241f7645

        return binding.root
    }

<<<<<<< HEAD
    private fun fetchExpertBookings() {
        val expertId = getUserId(requireContext()) // Use the expert's user ID for the API call
        val retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8000/api/") // Change base URL if needed
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(LaravelApi::class.java)

        Log.d("ExpertDashBoardFragment", "Fetching bookings for expert ID: $expertId")

        api.getExpertBookings(expertId).enqueue(object : Callback<ApiResponse2> {
            override fun onResponse(call: Call<ApiResponse2>, response: Response<ApiResponse2>) {
                if (response.isSuccessful) {
                    val bookings = response.body()?.data
                    if (bookings != null && bookings.isNotEmpty()) {
                        Log.d("ExpertDashBoardFragment", "Bookings fetched successfully: ${bookings.size} bookings found.")
                        allBookings = bookings

                        // Categorize the bookings
                        val acceptedBookings = allBookings.filter { it.status == "ongoing" }
                        val pendingBookings = allBookings.filter { it.status == "pending" }

                        Log.d("ExpertDashBoardFragment", "Ongoing Bookings: ${acceptedBookings.size}")
                        Log.d("ExpertDashBoardFragment", "Completed Bookings: ${pendingBookings.size}")

                        ongoingBookingsAdapter.updateBookings(acceptedBookings)
                        expertBookingsAdapter.updateBookings(pendingBookings)

                        // Ensure RecyclerView is updated
                        binding.bookingsRecyclerView.scrollToPosition(0)
                        binding.ongoingBookingsRecyclerView.scrollToPosition(0)

                    } else {
                        Log.d("ExpertDashBoardFragment", "No bookings available")
                    }
                } else {
                    Log.e("ExpertDashBoardFragment", "Failed to load expert bookings. Response: ${response.code()}")
                    Toast.makeText(requireContext(), "Failed to load expert bookings", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ApiResponse2>, t: Throwable) {
                Log.e("ExpertDashBoardFragment", "Error fetching bookings: ${t.message}")
                Toast.makeText(requireContext(), "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun setNavigationListeners() {
        binding.activity.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, ExpertActivityFragment())
                .addToBackStack(null)
                .commit()
        }
        binding.payment.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, ExpertPaymentFragment())
                .addToBackStack(null)
                .commit()
        }
        binding.textHome.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, ExpertDashBoardFragment())
                .addToBackStack(null)
                .commit()
        }

        binding.profile.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, ExpertProfileFragment())
                .addToBackStack(null)
                .commit()
=======
    private fun setNavigationListeners() {
        binding.activity.setOnClickListener {
            // Navigate to Expert Activity Page
        }

        binding.payment.setOnClickListener {
            // Navigate to Expert Payment Page
        }

        binding.textHome.setOnClickListener {
            // Reload Expert Dashboard
        }

        binding.messages.setOnClickListener {
            // Navigate to Expert Messages Page
        }

        binding.profile.setOnClickListener {
            // Navigate to Expert Profile Page
>>>>>>> cfe5a45c11da7916e59ce6b409ec08c6241f7645
        }
    }

    private fun loadExpertProfile() {
<<<<<<< HEAD
        val expertId = getUserId(requireContext())
        if (expertId == -1) {
            Log.e("ExpertDashBoardFragment", "Expert ID not found")
=======
        val userId = getUserId(requireContext())
        if (userId == -1) {
            Log.e("ExpertDashBoardFragment", "User ID not found")
>>>>>>> cfe5a45c11da7916e59ce6b409ec08c6241f7645
            return
        }

        // Make Retrofit call to fetch the expert profile
        val retrofit = Retrofit.Builder()
<<<<<<< HEAD
            .baseUrl("http://10.0.2.2:8000/api/") // Change base URL if needed
=======
            .baseUrl("http://10.0.2.2:8000/api/")
>>>>>>> cfe5a45c11da7916e59ce6b409ec08c6241f7645
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(LaravelApi::class.java)

<<<<<<< HEAD
        api.getExpertProfile(expertId).enqueue(object : Callback<ExpertProfileResponse> {
=======
        api.getExpertProfile(userId).enqueue(object : Callback<ExpertProfileResponse> {
>>>>>>> cfe5a45c11da7916e59ce6b409ec08c6241f7645
            override fun onResponse(
                call: Call<ExpertProfileResponse>,
                response: Response<ExpertProfileResponse>
            ) {
                if (response.isSuccessful) {
                    val expert = response.body()
                    Log.d("ExpertDashBoardFragment", "Expert Profile: $expert")
<<<<<<< HEAD
                    Log.d("ExpertDashBoardFragment", "Full name: ${expert?.fullName}, Phone number: ${expert?.phoneNumber}")

                    // Update the UI with the expert's data
                    binding.usernameText.text = expert?.fullName ?: "Expert Name"
                    binding.numberText.text = expert?.phoneNumber ?: "Add Phone Number"


                } else {
                    Log.e("ExpertDashBoardFragment", "Failed to load expert profile. Response: ${response.code()}")
=======
                    Log.d("ExpertDashBoardFragment", "Full name: ${expert?.full_name}, Number: ${expert?.phone_number}")

                    // Update the UI with the expert's data
                    binding.usernameText.text = expert?.full_name ?: "Expert Name"
                    binding.numberText.text = expert?.phone_number ?: "Add Phone Number"

                    expert?.profile_image?.let {
                        Glide.with(requireContext())
                            .load(it)
                            .into(binding.profilePicture)
                    }

                } else {
>>>>>>> cfe5a45c11da7916e59ce6b409ec08c6241f7645
                    Toast.makeText(requireContext(), "Failed to load profile", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ExpertProfileResponse>, t: Throwable) {
<<<<<<< HEAD
                Log.e("ExpertDashBoardFragment", "Error fetching expert profile: ${t.message}")
=======
                Toast.makeText(requireContext(), "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }





    private fun fetchBookings() {
        val userId = getUserId(requireContext())
        val retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8000/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(LaravelApi::class.java)

        api.getExpertBookings(userId).enqueue(object : Callback<List<Booking>> {
            override fun onResponse(call: Call<List<Booking>>, response: Response<List<Booking>>) {
                if (response.isSuccessful) {
                    val bookings = response.body() ?: emptyList()
                    expertBookingsAdapter.updateBookings(bookings)
                } else {
                    Toast.makeText(requireContext(), "Failed to load bookings", Toast.LENGTH_SHORT)
                        .show()
                }
            }

            override fun onFailure(call: Call<List<Booking>>, t: Throwable) {
                Toast.makeText(requireContext(), "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun fetchOngoingBookings() {
        val userId = getUserId(requireContext())
        val retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8000/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(LaravelApi::class.java)

        api.getOngoingBookings(userId).enqueue(object : Callback<List<Booking>> {
            override fun onResponse(call: Call<List<Booking>>, response: Response<List<Booking>>) {
                if (response.isSuccessful) {
                    val ongoingBookings = response.body() ?: emptyList()
                    ongoingBookingsAdapter.updateBookings(ongoingBookings)
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Failed to load ongoing bookings",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<List<Booking>>, t: Throwable) {
>>>>>>> cfe5a45c11da7916e59ce6b409ec08c6241f7645
                Toast.makeText(requireContext(), "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
