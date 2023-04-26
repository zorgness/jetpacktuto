import android.util.Log
import com.example.jetpack_tuto.*
import com.example.jetpack_tuto.dataclass.CountryDto
import com.example.jetpack_tuto.dataclass.GetCountriesDto
import com.example.jetpack_tuto.dataclass.GetCountryDto
import com.example.jetpack_tuto.dataclass.RetourDto
import com.example.jetpack_tuto.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/*fun updateCountry(toUpdate: UpdateCountryDto) {
    val call: Call<RetourDto>? = ApiService.getApi().updateCountry(toUpdate)
    call?.enqueue(object : Callback<RetourDto> {

        override fun onResponse(call: Call<RetourDto>, response: Response<RetourDto>) {

            response.body()?.let {
                //countryDtoCallback.invoke()
            }
        }

        override fun onFailure(call: Call<RetourDto>, t: Throwable) {
            TODO("Not yet implemented")
        }
    })
}*/

fun insertCountry(idStagiaire: Long, name: String, url: String) {
    val call: Call<RetourDto>? = ApiService.getApi().addCountry(idStagiaire, name, url)
    call?.enqueue(object : Callback<RetourDto> {

        override fun onResponse(call: Call<RetourDto>, response: Response<RetourDto>) {

            response.body()?.let {
                //countryDtoCallback.invoke()
            }

        }

        override fun onFailure(call: Call<RetourDto>, t: Throwable) {
            TODO("Not yet implemented")
        }
    })
}

fun deleteCountry(country: CountryDto, countryDtoCallback: (CountryDto) -> Unit) {
    val call: Call<RetourDto>? = ApiService.getApi().deleteCountry(country.idPays.toLong())
    call?.enqueue(object : Callback<RetourDto> {

        override fun onResponse(call: Call<RetourDto>, response: Response<RetourDto>) {

            response.body()?.let {
                countryDtoCallback.invoke(country)
            }

        }

        override fun onFailure(call: Call<RetourDto>, t: Throwable) {
            TODO("Not yet implemented")
        }


    })

}


fun getCountryById(idCountry: Long, countryDtoCallback: (GetCountryDto) -> Unit) {
    val call: Call<GetCountryDto>? = ApiService.getApi().getCountry(idCountry)
    call?.enqueue(object : Callback<GetCountryDto> {
        override fun onResponse(call: Call<GetCountryDto>, response: Response<GetCountryDto>) {

            response.body()?.let {
                countryDtoCallback.invoke(it)
            }
        }

        override fun onFailure(call: Call<GetCountryDto>, t: Throwable) {
            Log.e("failure", t.message ?: "lol")
        }
    })
}

fun getRemoteCountries(countriesDtoCallback: (List<CountryDto>) -> Unit) {
    val call: Call<GetCountriesDto>? = ApiService.getApi().getAllCountry(2)
    call?.enqueue(object : Callback<GetCountriesDto> {
        override fun onResponse(call: Call<GetCountriesDto>, response: Response<GetCountriesDto>) {

            response.body()?.let {
                if(it.status == "ok")
                    countriesDtoCallback.invoke(it.countries)
            }
        }

        override fun onFailure(call: Call<GetCountriesDto>, t: Throwable) {
            Log.e("failure", t.message ?: "lol")
        }
    })
}