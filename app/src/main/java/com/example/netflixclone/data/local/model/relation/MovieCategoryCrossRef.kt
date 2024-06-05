package com.example.netflixclone.data.local.model.relation

import androidx.room.Entity

@Entity(primaryKeys = ["movieId","categoryId"])
data class MovieCategoryCrossRef(
    val movieId : Int,
    val categoryId: Int
)
