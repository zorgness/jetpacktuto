package com.example.jetpack_tuto.new_navigation

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.jetpack_tuto.R
import kotlinx.coroutines.delay


class SplashFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val navController = findNavController()

        Handler().postDelayed({
            navController.navigate(R.id.action_splashFragment_to_mainFragment)
        }, 2000)

        return inflater.inflate(R.layout.fragment_splash, container, false)
    }


}