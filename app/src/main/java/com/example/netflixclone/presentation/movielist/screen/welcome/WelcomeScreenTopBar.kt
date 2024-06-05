package com.example.netflixclone.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.netflixclone.R

@Composable
fun WelcomeScreenTopBar() {
    Row(modifier = Modifier.fillMaxWidth()) {

        Row(
            modifier = Modifier
                .weight(1f)
                .height(70.dp)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.netflix),
                contentDescription = "netflix logo",
            )
        }
        Row(
            modifier = Modifier
                .weight(1f)
                .height(70.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "PRIVACY",
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    text = "SIGN IN",
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                IconButton(onClick = { } ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_more_vert_24),
                        contentDescription = "", tint = Gray
                    )
                }
            }


        }
    }
}