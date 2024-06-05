package com.example.netflixclone.presentation.movielist

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.netflixclone.common.Constants.POPULAR_MOVIES
import com.example.netflixclone.common.Constants.TOP_RATED_MOVIES
import com.example.netflixclone.common.Constants.TRENDING_MOVIES
import com.example.netflixclone.common.Constants.UPCOMING_MOVIES
import com.example.netflixclone.common.Resource
import com.example.netflixclone.domain.usecase.getmovies.GetPopularMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.annotation.meta.When
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
) : ViewModel() {

    private val _state = mutableStateOf(MovieListState())
    val state: State<MovieListState> = _state
    private val _trendingState = mutableStateOf(MovieListState())
    val trendingState: State<MovieListState> = _trendingState

    private val _popularMovieState = mutableStateOf(MovieListState())
    val popularMovieState: State<MovieListState> = _popularMovieState

    private val _trendingMovieState = mutableStateOf(MovieListState())
    val trendingMovieState: State<MovieListState> = _trendingMovieState

    private val _upcomingMovieState = mutableStateOf(MovieListState())
    val upcomingMovieState: State<MovieListState> = _upcomingMovieState

    private val _topRatedMovieState = mutableStateOf(MovieListState())
    val topRatedMovieState: State<MovieListState> = _topRatedMovieState

    init {
        getMovies(POPULAR_MOVIES)
        getMovies(TRENDING_MOVIES)
        getMovies(UPCOMING_MOVIES)
        getMovies(TOP_RATED_MOVIES)
    }

    private fun getMovies(categoryId: Int) {
        getPopularMoviesUseCase(categoryId).onEach { result ->

            when (result) {
                is Resource.Success -> {
                    when (categoryId) {
                        POPULAR_MOVIES -> _popularMovieState.value =
                            MovieListState(movies = result.data ?: emptyList())

                        TRENDING_MOVIES -> _trendingMovieState.value =
                            MovieListState(movies = result.data ?: emptyList())

                        UPCOMING_MOVIES -> _upcomingMovieState.value =
                            MovieListState(movies = result.data ?: emptyList())

                        TOP_RATED_MOVIES -> _topRatedMovieState.value =
                            MovieListState(movies = result.data ?: emptyList())
                    }
                }
                is Resource.Error -> {
                    when (categoryId){
                        POPULAR_MOVIES -> _popularMovieState.value =
                        MovieListState(error = result.message ?: "An unexpected error occured" )
                        TRENDING_MOVIES -> _trendingMovieState.value =
                            MovieListState(error = result.message ?: "An unexpected error occured")

                        UPCOMING_MOVIES -> _upcomingMovieState.value =
                            MovieListState(error = result.message ?: "An unexpected error occured")

                        TOP_RATED_MOVIES -> _topRatedMovieState.value =
                            MovieListState(error = result.message ?: "An unexpected error occured")

                    }

                }
                is Resource.Loading -> {
                    when(categoryId){
                        POPULAR_MOVIES -> _popularMovieState.value =
                            MovieListState(isLoading = true )
                        TRENDING_MOVIES -> _trendingMovieState.value =
                            MovieListState(isLoading = true)

                        UPCOMING_MOVIES -> _upcomingMovieState.value =
                            MovieListState(isLoading = true)

                        TOP_RATED_MOVIES -> _topRatedMovieState.value =
                            MovieListState(isLoading = true)

                    }

                }
            }
        }.launchIn(viewModelScope)
    }

}
