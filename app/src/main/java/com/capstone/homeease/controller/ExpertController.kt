package com.capstone.homeease.controller

<<<<<<< HEAD
import com.capstone.homeease.network.RetrofitClient
import com.capstone.homeease.view.ExpertView
import com.capstone.homeease.model.ExpertRepository
import com.capstone.homeease.network.LaravelApi
=======
import com.capstone.homeease.model.Expert
import com.capstone.homeease.model.ExpertIdResponse
import com.capstone.homeease.model.ExpertRepository
import com.capstone.homeease.network.ApiService
import com.capstone.homeease.network.LaravelApi
import com.capstone.homeease.network.RetrofitClient
import com.capstone.homeease.view.ExpertView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

>>>>>>> cfe5a45c11da7916e59ce6b409ec08c6241f7645

class ExpertController(private val view: ExpertView) {

    private val repository: ExpertRepository = ExpertRepository(
        RetrofitClient.createService(LaravelApi::class.java)
    )
<<<<<<< HEAD

=======
    private val apiService: ApiService = RetrofitClient.apiService
>>>>>>> cfe5a45c11da7916e59ce6b409ec08c6241f7645
    fun fetchExperts(profession: String) {
        repository.getExperts(profession) { experts, error ->
            if (experts != null) {
                view.showExperts(experts)
            } else {
                view.showError(error ?: "Unknown error")
            }
        }
    }
<<<<<<< HEAD
=======
    fun getExpertIdByEmail(email: String, callback: (Int?) -> Unit) {
        apiService.getExpertIdByEmail(email).enqueue(object : Callback<ExpertIdResponse> {
            override fun onResponse(call: Call<ExpertIdResponse>, response: Response<ExpertIdResponse>) {
                if (response.isSuccessful) {
                    val expertIdResponse = response.body()
                    if (expertIdResponse != null) {
                        callback(expertIdResponse.id)  // Return the expert ID via callback
                    } else {
                        callback(null)  // Expert not found
                    }
                } else {
                    callback(null)  // Error response
                }
            }

            override fun onFailure(call: Call<ExpertIdResponse>, t: Throwable) {
                callback(null)  // Network failure
            }
        })
    }
>>>>>>> cfe5a45c11da7916e59ce6b409ec08c6241f7645
}
