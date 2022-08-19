package constanta.testtask.filmsapplication.api.repository

import constanta.testtask.filmsapplication.api.service.FilmsService
import javax.inject.Inject

class Repository @Inject constructor(private val apiService: FilmsService){
    suspend fun getAll() = apiService.getFilmsList()
}