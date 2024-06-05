package com.example.netflixclone.common

import com.example.netflixclone.data.local.model.MovieCategory

object Constants {

    const val BASE_URL = "https://api.themoviedb.org/3/"
    const val API_KEY = "12f6c287c182b7cc5c10632cfee9eca8"
    const val IMAGE_BASE_UR = "https://image.tmdb.org/t/p/w500/"
    const val MOVIE_CACHE_LIFETIME_IN_MINUTES = 30

    // Movie Categories.
    const val POPULAR_MOVIES = 1
    const val TRENDING_MOVIES = 2
    const val UPCOMING_MOVIES = 3
    const val TOP_RATED_MOVIES = 4

    val movieCategories = listOf(
        MovieCategory(POPULAR_MOVIES, "Popular Movies"),
        MovieCategory(TRENDING_MOVIES, "Trending Movies"),
        MovieCategory(UPCOMING_MOVIES, "Upcoming Movies"),
        MovieCategory(TOP_RATED_MOVIES, "Top rated Movies"),
    )
}