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
                
                // Return mock data to test app logic
                val mockMovie = MovieApiModel(
                    ok = true,
                    description = listOf(
                        MovieDetailsApi(
                            title = "Mock Movie: $movieName",
                            rank = 8.5,
                            actors = "Test Actor 1, Test Actor 2",
                            posterUrl = "https://via.placeholder.com/300x450"
                        )
                    )
                )
                
                movie = mockMovie
                println("Mock Response: $movie")
                println("Description size: ${movie.description?.size}")
                movieResultForActivity.value = movie
                errorMessage.value = null
            } catch (e: Exception) {
                println("Error: ${e.message}")
                errorMessage.value = "Error: ${e.message}"
            }
        }
    }

}