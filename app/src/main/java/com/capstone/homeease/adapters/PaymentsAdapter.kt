package com.capstone.homeease.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.capstone.homeease.R
import com.capstone.homeease.model.Payment


class PaymentsAdapter(private val payments: List<Payment>) :
    RecyclerView.Adapter<PaymentsAdapter.PaymentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentViewHolder {
        // Inflate the layout for each item in the list
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_payment, parent, false)
        return PaymentViewHolder(view)
    }

    override fun onBindViewHolder(holder: PaymentViewHolder, position: Int) {
        // Bind the payment data to the view holder
        val payment = payments[position]
        holder.bind(payment)
    }

    override fun getItemCount(): Int = payments.size

    class PaymentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(payment: Payment) {
        }
    }
}


