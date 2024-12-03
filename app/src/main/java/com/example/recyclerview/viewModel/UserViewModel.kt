package com.example.recyclerview.viewModel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recyclerview.model.User
import com.example.recyclerview.view.UserAdapter

/**
 * Created by Ratna Srivastava on 02-12-2024.
 */
class UserViewModel: ViewModel() {

    private val _userList = MutableLiveData<List<User>>()
    val userList: LiveData<List<User>> get() = _userList

    init {
        _userList.value = listOf(User("Ratna",  31), User("Srivastava", 30), User("Singh", 29))
        setUsers(_userList.value)
    }
    fun setUsers(userList: List<User>?){
        _userList.value = userList?: emptyList()
    }
}