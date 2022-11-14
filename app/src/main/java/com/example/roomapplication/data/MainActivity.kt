package com.example.roomapplication.data

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.roomapplication.R
import com.example.roomapplication.data.db.AppDataBase
import com.example.roomapplication.data.db.entities.UserEntity
import com.example.roomapplication.data.viewmodel.MainViewModel
import com.example.roomapplication.databinding.ActivityMainBinding
import com.example.roomapplication.di.AppModule
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()

        mainViewModel.userData.observe(this){
            binding.txtView.text = it.toString()
        }

        binding.BtnInputTxt.setOnClickListener(this)
    }

    private fun showDataAllToDB() = mainViewModel.showAllUser()

    private fun insertDataToDB() {
        val eMail = binding.txtEditEmail.text.toString()
        val firstName = binding.txtEditFirstName.text.toString()
        val lastName = binding.txtEditLastName.text.toString()
        val shopID = binding.txtEditShopID.text

        if(inputCheck(eMail, firstName, lastName, shopID)) {
            // Create User Object
            val user = UserEntity(0, eMail, firstName, lastName, shopID.toString().toInt())
            // Add Data to Database
            mainViewModel.addUser(user)
            Toast.makeText(this, "Add Complete", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Insert More", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(
        eMail: String,
        firstName: String,
        lastName: String,
        shopID: Editable
    ): Boolean
    = !( TextUtils.isEmpty(eMail) &&
         TextUtils.isEmpty(firstName) &&
         TextUtils.isEmpty(lastName) &&
         shopID.isEmpty() )

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.Btn_ShowAll -> showDataAllToDB()
            R.id.Btn_InputTxt -> insertDataToDB()
        }
    }

}