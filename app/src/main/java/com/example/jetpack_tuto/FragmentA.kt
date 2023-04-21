package com.example.jetpack_tuto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.jetpack_tuto.databinding.FragmentABinding


class FragmentA : Fragment() {


   private lateinit var mainViewModel: MainViewModel

    private var _binding: FragmentABinding? = null

    private val binding
        get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentABinding.inflate(inflater,container, false)
        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        //le cycle de vie du fragment depends de l'activity
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]


        binding.btnCounterFragmentA.setOnClickListener {

            mainViewModel.increment()

        }

        mainViewModel.counterLiveData.observe(viewLifecycleOwner, Observer{ count ->
            binding.tvCounterFragmentA.text = count.toString()

        })
    }

}