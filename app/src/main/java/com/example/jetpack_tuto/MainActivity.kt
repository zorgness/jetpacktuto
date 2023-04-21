package com.example.jetpack_tuto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.jetpack_tuto.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var myViewModel: MainViewModel

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        //le cycle de vie du viewmodel depends de l'activity ou du fragment



        binding.btnCounter.setOnClickListener {
            /*counter++
            tvCounter.text = counter.toString()*/
            myViewModel.increment()

        }



        binding.btnFragmentA.setOnClickListener {
              supportFragmentManager.let {
                   it.beginTransaction().apply {
                       replace(
                           R.id.frame_layout,
                           FragmentA()
                       )
                       setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                   }.also {ft->
                       try {
                           ft.commit()
                       } catch (e: Exception) {
                           //
                       }
                   }
               }
        }

        binding.btnFragmentB.setOnClickListener {

            supportFragmentManager.let { fragment ->
                fragment.beginTransaction().apply {
                    replace(
                        R.id.frame_layout,
                        FragmentB()
                    )
                    setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                }.also { ft ->
                    try {
                        ft.commit()
                    } catch (e: Exception) {
                        //
                    }
                }
            }
        }

        myViewModel.counterLiveData.observe(this, Observer { count ->
          binding.tvCounter.text = count.toString()
            Toast.makeText(this, count.toString(), Toast.LENGTH_SHORT).show()
        })
    }
}