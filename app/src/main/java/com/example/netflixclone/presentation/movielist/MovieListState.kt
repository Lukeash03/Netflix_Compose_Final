package com.example.netflixclone.presentation.movielist

import com.example.netflixclone.data.local.model.Movie


data class MovieListState(
    val isLoading : Boolean = false,
    val movies : List<Movie> = emptyList(),
    val error: String = ""
)
