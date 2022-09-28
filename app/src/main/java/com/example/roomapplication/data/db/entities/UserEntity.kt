package com.example.roomapplication.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity (
    @PrimaryKey
    val uid: Int,
    @ColumnInfo(name= "eMail")
    val eMail: String,
    @ColumnInfo(name= "first_name")
    val firstName: String,
    @ColumnInfo(name= "last_name")
    val lastName: String,
    @ColumnInfo(name= "shop_id")
    val shop_id:String
)