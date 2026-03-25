package com.neda.movies.view.list

import android.os.Bundle
import android.widget.Toast
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
            val movieName = binding.edtMovieName.text.toString().trim()
            if (movieName.isNotEmpty()) {
                Toast.makeText(this, "Searching for: $movieName", Toast.LENGTH_SHORT).show()
                viewModel.searchMovieByName(movieName)
            } else {
                Toast.makeText(this, "Please enter a movie name", Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.movieResultForActivity.observe(this){ movie->
            if (!movie.description.isNullOrEmpty()) {
                val movieDetails = movie.description[0]
                
                binding.txtTitle.text = movieDetails.title ?: "No title available"
                binding.txtImdbRank.text = movieDetails.rank?.toString() ?: "No rating available"
                binding.txtActors.text = movieDetails.actors ?: "No actors information"
                
                if (!movieDetails.posterUrl.isNullOrEmpty()) {
                    binding.imgPoster.load(movieDetails.posterUrl)
                }
                // If no poster, just leave empty
            } else {
                binding.txtTitle.text = "No results found"
                binding.txtImdbRank.text = ""
                binding.txtActors.text = ""
                // No poster available
            }
        }

        viewModel.errorMessage.observe(this){ error->
            if (error != null) {
                Toast.makeText(this, error, Toast.LENGTH_LONG).show()
                binding.txtTitle.text = error
                binding.txtImdbRank.text = ""
                binding.txtActors.text = ""
            }
        }
    }
}