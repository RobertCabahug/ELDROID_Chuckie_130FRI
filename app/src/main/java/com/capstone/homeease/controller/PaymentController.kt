package com.capstone.homeease.controller

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.capstone.homeease.R
import com.capstone.homeease.adapters.PaymentsAdapter
import com.capstone.homeease.model.Payment
import com.capstone.homeease.view.PaymentView

class PaymentController(private val view: PaymentView) : Fragment(R.layout.fragment_payments) {

    private lateinit var recyclerView: RecyclerView
    private lateinit var paymentsAdapter: PaymentsAdapter
    private val payments = mutableListOf<Payment>()

    // Called when the fragment's view is created
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize RecyclerView and set up the adapter
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Add predefined payment methods to the list
        payments.add(Payment("Paymaya"))
        payments.add(Payment("Credit/Debit Card"))
        payments.add(Payment("Bank Account"))

        // Set the adapter with the payment data
        paymentsAdapter = PaymentsAdapter(payments)
        recyclerView.adapter = paymentsAdapter
    }

    // This method could be used to update the view or load new data if needed
    fun updatePaymentMethods() {
        payments.clear()
        payments.add(Payment("Paymaya"))
        payments.add(Payment("Credit/Debit Card"))
        payments.add(Payment("Bank Account"))
        paymentsAdapter.notifyDataSetChanged()
    }
}
