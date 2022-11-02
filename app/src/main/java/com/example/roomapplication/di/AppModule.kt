package com.example.roomapplication.di

import androidx.room.Room
import com.example.roomapplication.data.HiltAndroidApp
import com.example.roomapplication.data.db.AppDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun createDBInstance(): AppDataBase {

        return Room.databaseBuilder(
            HiltAndroidApp.applicationContext(),
            AppDataBase::class.java,
            "UserDataBase"
        ).build()
    }

}