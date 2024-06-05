package com.example.netflixclone.presentation.movielist.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.netflixclone.presentation.uiModel.MovieItemcard
import com.example.netflixclone.presentation.uiModel.movieList
import com.example.netflixclone.R

@Composable
fun MovieCardList() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
//            .height(300.dp)
    ) {
        Column() {
            MovieCard(text = "Trending Now", items = movieList)
            MovieCard(text = "Teen Dramas", items = movieList)
            MovieCard(text = "Comedy", items = movieList)
            MovieCard(text = "Thriller", items = movieList)
        }
    }

}

@Composable
fun MovieCard(text: String, items: List<MovieItemcard>) {

    Text(
        text = text,
        fontWeight = FontWeight.Bold,
        fontSize = 15.sp,
        color = Color.White,
        modifier = Modifier.padding(10.dp)
    )
    LazyRow {
        items(items) {

            for (i in 0..items.size){
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    shape = RoundedCornerShape(10.dp),
                    elevation = 5.dp
                ) {
                    Box(
                        modifier = Modifier
                            .height(200.dp)
                            .width(100.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.strangerthings),
                            contentDescription = "",
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }

        }
    }
}





