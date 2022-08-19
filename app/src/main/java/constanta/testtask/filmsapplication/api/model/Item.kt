package constanta.testtask.filmsapplication.api.model

data class Item(
    val actors: List<Actor>,
    val directorName: String,
    val releaseYear: Int,
    val title: String
)

