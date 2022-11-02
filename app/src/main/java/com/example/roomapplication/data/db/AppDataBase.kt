package com.example.roomapplication.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.roomapplication.data.db.entities.UserEntity
import com.example.roomapplication.data.db.remote.UserDao

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class AppDataBase: RoomDatabase() {
    abstract fun userDao(): UserDao
}