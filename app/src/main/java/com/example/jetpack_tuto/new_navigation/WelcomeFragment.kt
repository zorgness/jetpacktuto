package com.example.jetpack_tuto.new_navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jetpack_tuto.R
import com.example.jetpack_tuto.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {

/*    private var nom: String? = null
    private var prenom: String? = null
    private var age: Int = 0*/

    private var userParcelable: UserParcelable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*arguments?.let {
            nom = it.getString("nom")
            prenom = it.getString("prenom")
            age = it.getInt("age")
        }*/

        arguments?.let {
            userParcelable = it.getParcelable("userParcelable")
        }

        //arguments?.let {
        //id = it.getString("id")
        //then viewModel.getItem(id)
        //then viewModel.observe then { view get item infos}

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentWelcomeBinding.inflate(layoutInflater)

        binding.tvWelcome.text =
            "ton nom est ${userParcelable?.nom} \nton prenom est ${userParcelable?.prenom} \ntu es ${if (userParcelable?.age!! > 17) "majeur" else "mineur"} "

        return binding.root
    }


}