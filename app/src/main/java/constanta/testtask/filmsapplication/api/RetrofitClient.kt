package constanta.testtask.filmsapplication.api

import constanta.testtask.filmsapplication.api.service.FilmsService
import constanta.testtask.filmsapplication.api.utils.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: FilmsService by lazy {
        retrofit.create(FilmsService::class.java)
    }
}