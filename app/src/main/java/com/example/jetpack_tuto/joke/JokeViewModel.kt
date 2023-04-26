package com.example.jetpack_tuto.joke

import android.widget.Toast
import androidx.lifecycle.*
import com.example.jetpack_tuto.dataclass.JokeDto
import com.example.jetpack_tuto.network2.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class JokeViewModel : ViewModel() {

    private val _jokeLiveData = MutableLiveData<String>()

    private val _errorMessageLiveData = MutableLiveData<String>()

    val jokeLiveData: LiveData<String>
        get() = _jokeLiveData

    val errorMessageLiveData: LiveData<String>
        get() = _errorMessageLiveData

    init {
        getJoke()
    }


    fun getJoke() {
        viewModelScope.launch {
            val responseJoke: Response<JokeDto>? = withContext(Dispatchers.IO) {
                ApiService.getApi().getResponseJoke("json")
            }

            val body = responseJoke?.body()

            when {
                responseJoke == null -> {

                    _errorMessageLiveData.value = "Joke is null"
                }

                responseJoke.isSuccessful && (body != null) -> {
                    _jokeLiveData.value = body.joke
                }


                responseJoke.code() == 403 ->
                    _errorMessageLiveData.value = "erreur"
            }

        }
    }
}