package com.example.jetpack_tuto

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpack_tuto.dataclass.CountryDto
import getRemoteCountries
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RecyclerViewModel : ViewModel() {

    private val _countriesLiveData = MutableLiveData<List<CountryDto>>()

    val countriesLiveData: LiveData<List<CountryDto>>
        get() = _countriesLiveData

    init {
        getCountries()


    }

    private fun getCountries() {
        viewModelScope.launch() {
            //pb = visible
            withContext(Dispatchers.IO) {
                getRemoteCountries {
                    _countriesLiveData.value = it

                }
            }
            //pb = gone
        }

    }

}