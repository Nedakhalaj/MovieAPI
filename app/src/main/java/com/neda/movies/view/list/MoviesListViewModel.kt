package com.neda.movies.view.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.neda.movies.data.api.ApiRepository
import com.neda.movies.data.models.MovieApiModel
import com.neda.movies.data.models.MovieDetailsApi
import kotlinx.coroutines.launch

class MoviesListViewModel : ViewModel(){

    lateinit var movie : MovieApiModel

    val movieResultForActivity = MutableLiveData<MovieApiModel>()
    val errorMessage = MutableLiveData<String>()

    private val api = ApiRepository()

    fun searchMovieByName(movieName:String){
        if (movieName.isBlank()) {
            errorMessage.value = "Please enter a movie name"
            return
        }

        viewModelScope.launch {
            try {
                println("Searching for: $movieName")
                movie = api.apiInterface.searchMovie(search=movieName)
                println("API Response: $movie")
                println("Search results size: ${movie.search?.size}")
                movieResultForActivity.value = movie
                errorMessage.value = null
            } catch (e: Exception) {
                println("Error: ${e.message}")
                errorMessage.value = "Error: ${e.message}"
            }
        }
    }

}