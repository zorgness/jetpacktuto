package com.example.jetpack_tuto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE
import androidx.fragment.app.commit
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.jetpack_tuto.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //private lateinit var myViewModel: MainViewModel
    private val myViewModel: MainViewModel by viewModels()
    //private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)



        //LE "by" est un delegate (on delegue au compilateur d'instancier à notre place)
        //myViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        //le cycle de vie du viewmodel depends de l'activity ou du fragment

        //binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(binding.root)

        //@ fait reférence a ce qu'il y a dans l'xml

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.viewModel = myViewModel
        binding.counterTest = 18

        binding.lifecycleOwner = this






     /*   binding.btnCounter.setOnClickListener {
            *//*counter++
            tvCounter.text = counter.toString()*//*
            myViewModel.increment()

        }*/



        binding.btnFragmentA.setOnClickListener {

            supportFragmentManager.commit {
                setTransition(TRANSIT_FRAGMENT_FADE)
                replace(R.id.frame_layout, FragmentA())
            }
            /*  supportFragmentManager.let {
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
               }*/
        }

        binding.btnFragmentB.setOnClickListener {

            supportFragmentManager.commit {
                replace(binding.frameLayout.id, FragmentB())
            }

           /* supportFragmentManager.let { fragment ->
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
            }*/
        }

      /*  myViewModel.counterLiveData.observe(this, Observer { count ->
          binding.tvCounter.text = count.toString()
            Toast.makeText(this, count.toString(), Toast.LENGTH_SHORT).show()
        })*/
    }
}