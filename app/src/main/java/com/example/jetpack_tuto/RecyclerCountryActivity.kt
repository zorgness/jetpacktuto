package com.example.jetpack_tuto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpack_tuto.adapter.CountryAdapter
import com.example.jetpack_tuto.databinding.ActivityMainBinding
import com.example.jetpack_tuto.databinding.ActivityRecyclerCountryBinding
import com.example.jetpack_tuto.dataclass.CountryDto
import getRemoteCountries

class RecyclerCountryActivity : AppCompatActivity() {


    private val myViewModel: RecyclerViewModel by viewModels()
    private lateinit var countryAdapter: CountryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //val binding: ActivityRecyclerCountryBinding  = DataBindingUtil.setContentView(this,R.layout.activity_recycler_country)
        val binding =  ActivityRecyclerCountryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewModel = myViewModel
        binding.lifecycleOwner = this


        binding.rvCountry.layoutManager = LinearLayoutManager(this)
        countryAdapter = CountryAdapter()
        binding.rvCountry.adapter = countryAdapter

        //myViewModel.getCountries()

        myViewModel.countriesLiveData.observe(this) {countries->
            //countryAdapter.setCountries(countries)
            countryAdapter.submitList(countries)
        }


    }
}