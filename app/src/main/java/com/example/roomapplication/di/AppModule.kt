package com.example.roomapplication.di

import android.content.Context
import androidx.room.Room
import com.example.roomapplication.data.HiltAndroidApp
import com.example.roomapplication.data.db.AppDataBase
import com.example.roomapplication.data.db.UserRepository
import com.example.roomapplication.data.db.remote.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun createDBInstance(@ApplicationContext context: Context): AppDataBase {

        return Room.databaseBuilder(
            context,
            AppDataBase::class.java,
            "UserDataBase"
        ).build()
    }

    @Provides
    @Singleton
    fun provideDao(AppDB: AppDataBase): UserDao {
        return AppDB.userDao()
    }

    @Provides
    @Singleton
    fun provideUserRepo(userDao: UserDao): UserRepository {
        return UserRepository(userDao)
    }
}