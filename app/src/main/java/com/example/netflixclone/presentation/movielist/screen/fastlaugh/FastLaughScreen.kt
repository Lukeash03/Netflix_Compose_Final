package com.example.netflixclone.presentation.movielist.screen.fastlaugh

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FastLaughScreen(){

    var scaffoldState = rememberScaffoldState()
    Scaffold(scaffoldState = scaffoldState, modifier = Modifier.padding(bottom = 16.dp)
    ) {

       FastLaughViewPager()
    }

}