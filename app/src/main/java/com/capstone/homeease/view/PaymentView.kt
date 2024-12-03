package com.capstone.homeease.view

import com.capstone.homeease.model.Payment

interface PaymentView {
    fun onSuccess(payments: List<Payment>)
    fun onFailure(errorMessage: String)
}
