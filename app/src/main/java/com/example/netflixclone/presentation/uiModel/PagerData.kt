package com.example.netflixclone.presentation.uiModel

import com.example.netflixclone.R

data class PagerData(
    val title: String,
    val description: String,
    val imgUri: Int
)

val itemList = listOf(
    PagerData(
        "Unlimited entertainment,one low price.", "Everything on Netflix,starting at just RS.149",
        R.drawable.net_home1
    ),
    PagerData(
        "Download and watch offline", "Always have something to watch offline.",
        R.drawable.net_home2
    ),
    PagerData(
        "No annoying contracts", "Join today, cancel at any time.",
        R.drawable.net_home3
    ),
    PagerData(
        "Watch everywhere",
        "Stream on your phone, tablet, laptop, TV and more.",
        R.drawable.net_home1
    ),
)