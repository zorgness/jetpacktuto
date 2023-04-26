package com.example.jetpack_tuto.old_navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.jetpack_tuto.R
import com.example.jetpack_tuto.databinding.FragmentFirstBinding
import com.example.jetpack_tuto.databinding.FragmentSecondBinding

class FragmentSecond : Fragment() {


    private val sharedViewModel: FirstViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentSecondBinding.inflate(layoutInflater)

        binding.btnFragment.setOnClickListener {
            sharedViewModel.updateFragment(FragmentFirst ())
        }
        return binding.root
    }

}