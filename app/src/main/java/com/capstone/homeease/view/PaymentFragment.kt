package com.capstone.homeease.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.capstone.homeease.R
import com.capstone.homeease.adapters.PaymentsAdapter
import com.capstone.homeease.model.Payment

class PaymentFragment : Fragment(R.layout.fragment_payments) {

    private lateinit var recyclerView: RecyclerView
    private lateinit var paymentsAdapter: PaymentsAdapter
    private val payments = mutableListOf<Payment>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set up the RecyclerView
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Predefined payment methods
        payments.add(Payment("Paymaya"))
        payments.add(Payment("Credit/Debit Card"))
        payments.add(Payment("Bank Account"))

        // Set up the adapter with the payment methods
        paymentsAdapter = PaymentsAdapter(payments)
        recyclerView.adapter = paymentsAdapter
    }
}


