package com.example.jetpack_tuto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.jetpack_tuto.databinding.FragmentABinding
import com.example.jetpack_tuto.databinding.FragmentBBinding


class FragmentB : Fragment() {


    private lateinit var mainViewModel: MainViewModel

    private var _binding: FragmentBBinding? = null

    private val binding
        get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBBinding.inflate(inflater,container, false)
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


        binding.btnCounterFragmentB.setOnClickListener {

            mainViewModel.increment()

        }


        mainViewModel.counterLiveData.observe(viewLifecycleOwner){ count ->
            binding.tvCounterFragmentB.text = count.toString()
        }
    }

}

