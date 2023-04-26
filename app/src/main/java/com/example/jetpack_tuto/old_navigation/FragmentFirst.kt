package com.example.jetpack_tuto.old_navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import com.example.jetpack_tuto.R
import com.example.jetpack_tuto.databinding.FragmentFirstBinding


class FragmentFirst : Fragment() {


    private val sharedViewModel: FirstViewModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentFirstBinding.inflate(layoutInflater)

        binding.btnFragment2.setOnClickListener {
            sharedViewModel.updateFragment(FragmentSecond ())
        }

        return  binding.root
    }


}