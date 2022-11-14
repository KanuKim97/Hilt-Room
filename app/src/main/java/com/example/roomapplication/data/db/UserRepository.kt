package com.example.roomapplication.data.db

import com.example.roomapplication.data.db.entities.UserEntity
import com.example.roomapplication.data.db.remote.UserDao

class UserRepository(private val userDao: UserDao) {

    suspend fun readAllData(): UserEntity = userDao.readAllData()[0]

    suspend fun addUser(userEntity: UserEntity){
        userDao.addUserData((userEntity))
    }
}