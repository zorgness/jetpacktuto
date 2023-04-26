package com.example.jetpack_tuto.old_navigation

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FirstViewModel: ViewModel() {


    private val _fragmentLiveData = MutableLiveData<Fragment>()

    val fragmentLiveData: LiveData<Fragment>
        get() = _fragmentLiveData


    init {
        _fragmentLiveData.value = FragmentFirst()
    }

    fun updateFragment(fragment: Fragment) {
        _fragmentLiveData.value = fragment
    }


}