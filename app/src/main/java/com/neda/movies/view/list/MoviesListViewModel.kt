package com.neda.movies.view.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.neda.movies.data.api.ApiRepository
import com.neda.movies.data.models.MovieApiModel
import kotlinx.coroutines.launch

class MoviesListViewModel : ViewModel(){

    lateinit var movie : MovieApiModel

    val movieResultForActivity = MutableLiveData<MovieApiModel>()

    private val api = ApiRepository()

    fun searchMovieByName(movieName:String){
        //Call repository and search and return the value

        //REAL API values
        viewModelScope.launch {
            //call the api
            movie = api.apiInterface.searchMovie(q=movieName)
            // pass the result from API to Activity
            movieResultForActivity.value = movie

        }

    }

}