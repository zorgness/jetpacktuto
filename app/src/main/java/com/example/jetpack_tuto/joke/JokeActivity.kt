package com.example.jetpack_tuto.joke

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.jetpack_tuto.R
import com.example.jetpack_tuto.databinding.ActivityJokeBinding
import com.example.jetpack_tuto.dataclass.JokeDto
import com.example.jetpack_tuto.network2.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class JokeActivity : AppCompatActivity() {

    private val myViewModel: JokeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val binding = ActivityJokeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewModel = myViewModel
        binding.lifecycleOwner = this


        myViewModel.jokeLiveData.observe(this, Observer {jokeStr->
            binding.tvRetrofit.text = jokeStr
        })

        myViewModel.errorMessageLiveData.observe(this, Observer {error->
            Toast.makeText(this@JokeActivity, error, Toast.LENGTH_SHORT).show()
        })


        binding.btnNewJoke.setOnClickListener {
            myViewModel.getJoke()
        }

/*        fun getJoke() {
            lifecycleScope.launch {
                val responseJoke: Response<JokeDto>? = withContext(Dispatchers.IO) {
                    ApiService.getApi().getResponseJoke("json")
                }

                val body = responseJoke?.body()

                when{
                    responseJoke == null -> {
                        Toast.makeText(this@JokeActivity, "Joke is null", Toast.LENGTH_SHORT).show()
                    }

                    responseJoke.isSuccessful() && (body != null) ->
                        binding.tvRetrofit.text = body.joke

                    responseJoke.code() == 403->
                        Toast.makeText(this@JokeActivity, "error", Toast.LENGTH_SHORT).show()
                }

            }
        }


        getJoke()*/



    }
}