package com.example.roomapplication.data.db

import androidx.lifecycle.LiveData
import com.example.roomapplication.data.db.entities.UserEntity
import com.example.roomapplication.data.db.remote.UserDao

class UserRepository(private val userDao: UserDao) {

    val readAllData: LiveData<List<UserEntity>> = userDao.readAllData()

    suspend fun addUser(userEntity: UserEntity){
        userDao.addUserData((userEntity))
    }
}