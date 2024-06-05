package com.example.netflixclone.presentation.movielist.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.netflixclone.presentation.movielist.MovieListViewModel

@Composable
fun TrendingMovieListScreen(
    viewModel: MovieListViewModel = hiltViewModel()
){

    val state = viewModel.trendingState.value
    Column(
        modifier = Modifier
            .fillMaxWidth().background(color = Color.Black)
            .height(300.dp)
    ) {
        Text(
            text = "PopularMovies",
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
            color = Color.White,
            modifier = Modifier.padding(10.dp)
        )
        LazyRow{
            items(state.movies){ movie ->
                MovieListItem(movie = movie, modifier = Modifier)
            }
        }
        if(state.error.isNotBlank()){
            Text(text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally))
        }
        if (state.isLoading){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
        }
    }


}