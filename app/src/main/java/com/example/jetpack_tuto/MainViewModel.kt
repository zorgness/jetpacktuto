package com.example.jetpack_tuto

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private val _counterLiveData = MutableLiveData<Int>()

    //seul livedata non modifiable est accessible de l'extérieur !!!
    val counterLiveData: LiveData<Int>
        get() = _counterLiveData

    init {_counterLiveData.value = 0}

    fun increment() {
        _counterLiveData.value =_counterLiveData.value?.plus(1)
    }

    //LiveData est un conteneur de données.
    // il a la capacité de notifier tout changement la données qu'il contient
}