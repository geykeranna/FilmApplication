package constanta.testtask.filmsapplication.api.service

import constanta.testtask.filmsapplication.api.model.FilmsEntity
import retrofit2.Response
import retrofit2.http.GET

interface FilmsService {

    @GET("constanta-android-dev/intership-wellcome-task/main/films.json")
    suspend fun getFilmsList(): Response<FilmsEntity>
}