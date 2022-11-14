package com.example.roomapplication.data.db.remote

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.roomapplication.data.db.entities.UserEntity

@Dao
interface UserDao {
    @Query("SELECT * FROM user_table ORDER BY uid ASC")
    suspend fun readAllData(): List<UserEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUserData(userEntity: UserEntity)

}