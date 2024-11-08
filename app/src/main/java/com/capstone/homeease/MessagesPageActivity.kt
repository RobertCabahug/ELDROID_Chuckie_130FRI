package com.capstone.homeease

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import com.capstone.homeease.databinding.ActivityMessagesPageBinding // Import the ViewBinding class

class MessagesPageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMessagesPageBinding // Declare the ViewBinding variable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMessagesPageBinding.inflate(layoutInflater) // Initialize the ViewBinding
        setContentView(binding.root)

        val messagesListView = binding.messagesListView
        val messagesList = listOf("Message 1", "Message 2", "Message 3")

        if (messagesList.isNullOrEmpty()) {
            messagesListView.visibility = View.GONE
        } else {
            messagesListView.visibility = View.VISIBLE
            // Set up your ListView adapter or other logic here
        }


        binding.messages.setOnClickListener {
            val intent = Intent(this, MessagesPageActivity::class.java)
            startActivity(intent)
        }

    }
}
