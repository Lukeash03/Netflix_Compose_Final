package com.example.netflixclone.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.netflixclone.data.local.model.Movie
import com.example.netflixclone.data.local.model.MovieCategory
import com.example.netflixclone.data.local.model.relation.MovieCategoryCrossRef

@Database(
    entities = [
        Movie::class,
        MovieCategory::class,
        MovieCategoryCrossRef::class
    ],
    version = 2, exportSchema = false
)
abstract class MovieDataBase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}