package com.example.recyclerview.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.model.User
import com.example.recyclerview.viewModel.UserViewModel

class MainActivity : ComponentActivity() {
    private lateinit var recyclerView: RecyclerView
    private val viewModel: UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = UserAdapter(mutableListOf())
        recyclerView.adapter = adapter
        viewModel.userList.observe(this, {users ->
            adapter.updateUsers(users)
        })
    }
}