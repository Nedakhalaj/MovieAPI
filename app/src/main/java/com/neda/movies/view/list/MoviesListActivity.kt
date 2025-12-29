package com.neda.movies.view.list

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.neda.movies.databinding.ActivityMoviesListBinding

class MoviesListActivity : ComponentActivity() {

    lateinit var binding : ActivityMoviesListBinding

    lateinit var viewModel: MoviesListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoviesListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get( MoviesListViewModel::class)

        binding.btnSearch.setOnClickListener {
            val movieName = binding.edtMovieName.text.toString()
            viewModel.searchMovieByName(movieName)
        }

        viewModel.movieResultForActivity.observe(this){ movie->
            val movie = movie.description.get(0)

            binding.txtTitle.text = movie.title
            binding.txtImdbRank.text = movie.rank.toString()
            binding.txtActors.text = movie.actors
            binding.imgPoster.load( movie.posterUrl )
        }

    }
}