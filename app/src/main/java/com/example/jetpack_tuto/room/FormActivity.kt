package com.example.jetpack_tuto.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.jetpack_tuto.R
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.jetpack_tuto.databinding.ActivityFormBinding

class FormActivity : AppCompatActivity() {
    private val myViewModel: FormViewModel by viewModels()

    private lateinit var userList: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        val binding =  ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewModel = myViewModel
        binding.lifecycleOwner = this


        binding.btnSubmit.setOnClickListener {

            val firstName = binding.etUserFirstName.text.toString()
            val lastName = binding.etUserLastName.text.toString()

            if(firstName.isNotBlank() && lastName.isNotBlank()) {
                myViewModel.insertNewUser(UserRoom(id = 0, firstName = firstName, lastName = lastName))
                binding.etUserFirstName.setText("")
                binding.etUserLastName.setText("")

            }
        }

        myViewModel.userLiveData.observe(this, Observer {users->
            userList = ""
            users.forEach { user ->
                userList += "${user.firstName} ${user.lastName}  \n"
            }

            binding.tvList.text = userList

        })
    }
}