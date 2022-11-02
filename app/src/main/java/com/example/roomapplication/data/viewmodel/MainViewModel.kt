package com.example.roomapplication.data.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomapplication.data.db.AppDataBase
import com.example.roomapplication.data.db.UserRepository
import com.example.roomapplication.data.db.entities.UserEntity
import com.example.roomapplication.di.AppModule
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(): ViewModel() {

    private val readAllData: LiveData<List<UserEntity>>
    private val userRepo: UserRepository

    init {
        val userDao = AppModule.createDBInstance().userDao()
        userRepo = UserRepository(userDao)
        readAllData = userRepo.readAllData
    }

    fun addUser(user: UserEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            userRepo.addUser(user)
        }
    }
}