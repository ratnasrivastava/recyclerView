package com.example.recyclerview.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.model.User

/**
 * Created by Ratna Srivastava on 02-12-2024.
 */
class UserAdapter(private val userList: MutableList<User>): RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.name)
        val age: TextView = view.findViewById(R.id.age)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.name.setText(userList[position].name)
        holder.age.setText(userList[position].age.toString())
    }

    fun updateUsers(users: List<User>) {
        val mutableList = ArrayList(users)
        userList.clear()
        userList.addAll(mutableList)
        notifyDataSetChanged()
    }
}