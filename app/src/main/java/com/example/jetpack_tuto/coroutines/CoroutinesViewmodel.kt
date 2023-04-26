package com.example.jetpack_tuto.coroutines

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CoroutinesViewmodel : ViewModel() {


    private val _counterLiveData = MutableLiveData<Int>()

    private val _colorLiveData = MutableLiveData<Int>()

    private var counterColor = 0

    private val colors = listOf(
        Color.BLACK,
        Color.GREEN,
        Color.RED,
        Color.YELLOW
    )

    val colorLiveData: LiveData<Int>
        get() = _colorLiveData

    val counterLiveData: LiveData<Int>
        get() = _counterLiveData

    init {

        _counterLiveData.value = 0
    }

    fun changeColor() {
        viewModelScope.launch {
            delay(1000)
            //counterColor++
            _colorLiveData.value = colors[++counterColor % colors.size]
        }

    }

    fun increment() {
        _counterLiveData.value = _counterLiveData.value?.plus(1)
    }

}