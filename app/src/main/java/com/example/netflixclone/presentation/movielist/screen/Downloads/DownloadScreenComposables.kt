package com.example.netflixclone.presentation.movielist.screen.Downloads

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.netflixclone.R
import com.example.netflixclone.presentation.movielist.screen.welcome.FullWidthButton

@Composable

fun DownloadScreenTopBar() {

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

            Text(
                text = "Downloads",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
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

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DownloadScreenTexts() {
    Column(
        modifier = Modifier
            .padding(15.dp)
            .wrapContentHeight(),
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_settings_24),
                tint = Color.White,
                contentDescription = ""
            )
            Text(text = "Smart Downloads", fontSize = 10.sp, color = Color.White)
        }

        Text(
            text = "Introducing downloads for",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            style = TextStyle(fontSize = 28.sp, color = Color.White)
        )


        Text(
            text = "You",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            style = TextStyle(fontSize = 28.sp, color = Color.White)
        )

        Text(
            text = "we'll download a personalised selection of",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            style = TextStyle(fontSize = 15.sp, color = Color.Gray)
        )
        Text(
            text = "movies and shows for you, so there's always",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            style = TextStyle(fontSize = 15.sp, color = Color.Gray)
        )
        Text(
            text = "something to watch on your device",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            style = TextStyle(fontSize = 15.sp, color = Color.Gray)
        )
        Spacer(modifier = Modifier.height(20.dp))


        Box(modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)) {
            Image(
                painter = painterResource(id = R.drawable.download),
                contentDescription = "",
                contentScale = ContentScale.Crop
            )

        }
        Spacer(modifier = Modifier.height(20.dp))


        FullWidthButton(
            contentColor = Color.White,
            containerColor = Color.Blue,
            buttonText = "Set Up"
        ) {}
        Spacer(modifier = Modifier.height(20.dp))

        FullWidthButton(
            contentColor = Color.Black,
            containerColor = Color.White,
            buttonText = "See what you can download"
        )

        {

        }


    }


}