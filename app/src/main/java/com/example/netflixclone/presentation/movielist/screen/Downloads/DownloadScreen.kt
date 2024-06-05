package com.example.netflixclone.presentation.movielist.screen.Downloads

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.netflixclone.presentation.movielist.screen.home.MovieCard
import com.example.netflixclone.presentation.movielist.screen.home.MovieCardList

@Composable
fun DownloadScreen() {

    var scrollState = rememberScrollState()
    Scaffold(Modifier.padding(bottom = 40.dp)) {
        Column(
            modifier = Modifier
                .background(Color.Black)
                .verticalScroll(scrollState)
        ) {
            DownloadScreenTopBar()
            DownloadScreenTexts()
        }
    }

}