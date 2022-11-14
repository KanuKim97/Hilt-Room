package com.example.roomapplication.data.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomapplication.data.db.AppDataBase
import com.example.roomapplication.data.db.UserRepository
import com.example.roomapplication.data.db.entities.UserEntity
import com.example.roomapplication.di.AppModule
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userRepo: UserRepository
): ViewModel() {
    private val _userData = MutableLiveData<UserEntity>()
    val userData: LiveData<UserEntity>
        get() = _userData


    init {
        viewModelScope.launch {
            _userData.value = userRepo.readAllData()
        }
    }

    fun addUser(user: UserEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            userRepo.addUser(user)
        }
    }

    fun showAllUser() {
        viewModelScope.launch(Dispatchers.IO) {
            _userData.value.let {
                userRepo.readAllData()
            }
        }
    }

}