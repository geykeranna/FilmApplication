package constanta.testtask.filmsapplication.ui.fragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import constanta.testtask.filmsapplication.api.model.FilmsEntity
import constanta.testtask.filmsapplication.api.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListFilmsViewModel @Inject constructor(private val repo: Repository) : ViewModel() {
    private val _all = MutableLiveData<FilmsEntity>()

    val all: LiveData<FilmsEntity>
        get() = _all

    init {
        getFilmsList()
    }

    fun getFilmsList() = viewModelScope.launch{
        repo.getAll().let {
            if (it.isSuccessful)
                _all.postValue(it.body())
            else Log.d("AAA", "False again ${it.errorBody()}")
        }
    }
}