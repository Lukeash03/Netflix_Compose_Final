package com.example.netflixclone.presentation.movielist.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.ImagePainter.State.Empty.painter
import coil.compose.rememberImagePainter
import com.example.netflixclone.R
import com.example.netflixclone.common.Constants.IMAGE_BASE_UR
import com.example.netflixclone.data.local.model.Movie

@Composable
fun MovieListItem(
    movie: Movie, modifier: Modifier
) {
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
                painter = rememberImagePainter(
                    data = "${IMAGE_BASE_UR}/${movie.posterPath}", builder = {
                        placeholder(R.drawable.solid_color_image)
                        crossfade(true)
                    }
                ),
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
        }
    }

}