package com.example.netflixclone.presentation.uiModel

import androidx.annotation.ColorInt
import androidx.compose.ui.graphics.Color
import com.example.netflixclone.R

data class FastLaughPagerData(
    @ColorInt val color: Color,
    val text1: String,
    val image1: Int,
    val text2: String,
    val image2: Int,
    val text3: String,
    val image3: Int,
    val text4: String,
    val image4: Int,
    val volumeImage : Int
)

val fastLaughList = listOf(
    FastLaughPagerData(
        color = Color.Magenta,
        "Lol",
        R.drawable.ic_baseline_sentiment_very_satisfied_24,
        "My List",R.drawable.ic_baseline_add_24,
        "Share",R.drawable.ic_baseline_send_24,"Play",
        R.drawable.ic_baseline_play_arrow_24,R.drawable.ic_baseline_volume_up_24
    ),
    FastLaughPagerData(
        color = Color.Yellow,
        "Lol",
        R.drawable.ic_baseline_sentiment_very_satisfied_24,
        "My List",R.drawable.ic_baseline_add_24,
        "Share",R.drawable.ic_baseline_send_24,"Play",
        R.drawable.ic_baseline_play_arrow_24,R.drawable.ic_baseline_volume_up_24
    ),
    FastLaughPagerData(
        color = Color.Red,
        "Lol",
        R.drawable.ic_baseline_sentiment_very_satisfied_24,
        "My List",R.drawable.ic_baseline_add_24,
        "Share",R.drawable.ic_baseline_send_24,"Play",
        R.drawable.ic_baseline_play_arrow_24,R.drawable.ic_baseline_volume_up_24
    ),
            FastLaughPagerData(
            color = Color.Green,
    "Lol",
    R.drawable.ic_baseline_sentiment_very_satisfied_24,
    "My List",R.drawable.ic_baseline_add_24,
    "Share",R.drawable.ic_baseline_send_24,"Play",
    R.drawable.ic_baseline_play_arrow_24,R.drawable.ic_baseline_volume_up_24
)
)