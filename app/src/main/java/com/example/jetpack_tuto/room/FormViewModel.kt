package com.example.jetpack_tuto.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FormViewModel : ViewModel() {

    private val _usersLiveData = MutableLiveData<List<UserRoom>>()

    val userLiveData: LiveData<List<UserRoom>>
        get() = _usersLiveData


    init {

        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch() {
            val users: List<UserRoom> = withContext(Dispatchers.IO) {
                MyApp.db.userRoomDao().getAllUsers()
            }
            _usersLiveData.value = users
        }
    }


    fun insertNewUser(user: UserRoom)   {
        //CHECK HERE
        viewModelScope.launch() {
            withContext(Dispatchers.IO) {
                MyApp.db.userRoomDao().insertUser(user)

            }
            fetchUsers()
        }
    }

}