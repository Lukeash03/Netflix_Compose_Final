package com.example.netflixclone.domain.repository

import com.example.netflixclone.data.local.model.Movie

interface MovieRepository {
    suspend fun getMovies(categoryId: Int): List<Movie>?
    suspend fun clearAllMoviesFromDB()

    fun getLastFetchedTimeFromApi():Long
}