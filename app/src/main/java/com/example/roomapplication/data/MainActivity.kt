package com.example.roomapplication.data

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.example.roomapplication.data.db.AppDataBase
import com.example.roomapplication.data.db.entities.UserEntity
import com.example.roomapplication.databinding.ActivityMainBinding
import com.example.roomapplication.di.AppModule
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var userDB: AppDataBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        userDB = AppModule.createDBInstance()

        setContentView(binding.root)

    }

    override fun onResume() {
        super.onResume()


    }

}