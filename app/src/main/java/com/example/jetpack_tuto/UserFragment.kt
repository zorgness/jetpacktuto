package com.example.jetpack_tuto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.jetpack_tuto.databinding.FragmentUserBinding
import com.example.jetpack_tuto.new_navigation.UserParcelable


class UserFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val navController = findNavController()
        val binding = FragmentUserBinding.inflate(layoutInflater)


        binding.btnSubmit.setOnClickListener {
            /*   val bundle = bundleOf(
                   "nom" to binding.etUserNom.text.toString(),
                   "prenom" to binding.etUserPrenom.text.toString(),
                   "age" to binding.etUserAge.text.toString().toInt()
               )*/
            val userParcelable = UserParcelable(
                binding.etUserNom.text.toString(),
                binding.etUserPrenom.text.toString(),
                binding.etUserAge.text.toString().toInt()
            )
            val bundle = bundleOf("userParcelable" to userParcelable)
            navController.navigate(R.id.action_userFragment_to_welcomeFragment, bundle)
        }

        return binding.root
    }


}