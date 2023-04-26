package com.example.jetpack_tuto.coroutines

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.jetpack_tuto.MainViewModel
import com.example.jetpack_tuto.R
import com.example.jetpack_tuto.databinding.ActivityCoroutinesBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CoroutinesActivity : AppCompatActivity() {

    private val myViewModel: CoroutinesViewmodel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines)


        val binding = ActivityCoroutinesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewModel = myViewModel
        binding.lifecycleOwner = this


        val colors = listOf(
            Color.BLACK,
            Color.GREEN,
            Color.RED,
            Color.YELLOW
        )






        binding.btnColor.setOnClickListener {
            myViewModel.changeColor()
        }


        binding.btnIncrement.setOnClickListener {
            myViewModel.increment()
        }


        myViewModel.colorLiveData.observe(this, Observer {colorInt->
            binding.constraintLayout.setBackgroundColor(colorInt)
        })

        myViewModel.counterLiveData.observe(this, Observer {count ->
            binding.tvCounter.text = count.toString()
        })


    }
}