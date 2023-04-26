package com.example.jetpack_tuto.old_navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.commit
import androidx.lifecycle.Observer
import com.example.jetpack_tuto.R
import com.example.jetpack_tuto.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {

    private val myViewModel: FirstViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)


        myViewModel.fragmentLiveData.observe(this, Observer {fragment->
            supportFragmentManager.commit {
                setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                replace(R.id.frame_layout_fragment, fragment)
            }
        })

    }
}