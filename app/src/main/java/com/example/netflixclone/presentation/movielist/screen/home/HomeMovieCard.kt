package com.example.netflixclone.presentation.movielist.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.netflixclone.R

@Composable
fun MovieCard() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp)
    ) {

        Image(
            painter = painterResource(id = R.drawable.strangerthings),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .height(470.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        0f to Color.Black,
                        0.5f to Color.Transparent,
                        1.5f to Color.Black
                    )

                )
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .align(Alignment.BottomCenter)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
                    , Arrangement.SpaceAround,Alignment.CenterVertically
            ) {

                Column(
                    modifier = Modifier
                        .size(60.dp)
                        ,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_baseline_add_24),
                        contentDescription = "",
                        modifier = Modifier.size(30.dp)
                    )
                    Text(text = "My List", color = Color.White)

                }

                Button(
                    onClick = { },
                    modifier = Modifier.padding(vertical = 5.dp).size(100.dp,70.dp),
                    shape = RoundedCornerShape(15),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White, contentColor = Color.Black)
                ) {
                    Text(text = "play", fontSize = 20.sp)
                }

                Column(
                    modifier = Modifier
                        .size(60.dp)
                        ,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_baseline_info_24),
                        contentDescription = "",
                        modifier = Modifier.size(30.dp)
                    )
                    Text(text = "My Info", color = Color.White)

                }

            }
        }
        Box(modifier = Modifier.fillMaxWidth()) {
            Column(verticalArrangement = Arrangement.Top) {
                HomeScreenTopBar()
                HomeScreenTopBar2()
            }
        }

    }


}