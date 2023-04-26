package com.example.jetpack_tuto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.jetpack_tuto.databinding.FragmentFirstBinding
import com.example.jetpack_tuto.databinding.FragmentMainBinding


class MainFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val navController = findNavController()
        val binding = FragmentMainBinding.inflate(layoutInflater)

        binding.btnUser.setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_userFragment)
        }

        binding.btnInfos.setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_infosFragment)
        }



        return binding.root
    }


}