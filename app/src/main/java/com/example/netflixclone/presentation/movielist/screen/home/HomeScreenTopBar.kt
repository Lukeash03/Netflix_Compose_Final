package com.example.netflixclone.presentation.movielist.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.netflixclone.R

@Composable
fun HomeScreenTopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
    ) {

        Row(
            modifier = Modifier
                .weight(2f)
                .padding(15.dp), verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(id = R.drawable.netflix),
                contentDescription = "netflix logo",
            )

        }

        Row(
            modifier = Modifier
                .weight(1f)
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(25.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_cast_24),
                contentDescription = "netflix logo", modifier = Modifier.size(25.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.netflix_avatar),
                contentDescription = "",
                modifier = Modifier.size(25.dp)
            )
        }

    }

}


@Composable
fun HomeScreenTopBar2() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .padding(5.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(text = "TV Shows", fontSize = 15.sp, fontWeight = FontWeight.Bold, color = Color.White)
        Text(text = "Movies", fontSize = 15.sp, fontWeight = FontWeight.Bold,color = Color.White)
        Text(text = "Categories", fontSize = 15.sp, fontWeight = FontWeight.Bold,color = Color.White)

    }

}
