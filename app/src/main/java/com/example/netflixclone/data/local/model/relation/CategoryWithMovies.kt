package com.example.netflixclone.data.local.model.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.netflixclone.data.local.model.Movie
import com.example.netflixclone.data.local.model.MovieCategory

data class CategoryWithMovies(
    @Embedded val category : MovieCategory,
    @Relation(
        parentColumn = "categoryId",
        entityColumn = "movieId",
        associateBy = Junction(MovieCategoryCrossRef::class)
    )
    val movies : List<Movie>
)
