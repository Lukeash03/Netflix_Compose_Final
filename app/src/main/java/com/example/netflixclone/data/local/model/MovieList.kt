package com.example.netflixclone.data.local.model

import com.example.netflixclone.data.local.model.Movie

data class MovieList(
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)
