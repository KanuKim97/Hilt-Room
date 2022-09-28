package com.example.roomapplication.data.db.remote

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.roomapplication.data.db.entities.UserEntity

@Dao
interface UserDao {
    @Query("SELECT * FROM userentity")
    fun getAll(): List<UserEntity>

    @Insert
    fun insertAll(vararg userEntity: UserEntity)

    @Delete
    fun deleteUser(userEntity: UserEntity)
}