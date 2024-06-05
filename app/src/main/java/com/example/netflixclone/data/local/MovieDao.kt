package com.example.netflixclone.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.netflixclone.data.local.model.Movie
import com.example.netflixclone.data.local.model.MovieCategory
import com.example.netflixclone.data.local.model.relation.CategoryWithMovies
import com.example.netflixclone.data.local.model.relation.MovieCategoryCrossRef

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movies: List<Movie>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(movieCategories: List<MovieCategory>)

    @Query("DELETE FROM movie")
    suspend fun clearAllMovies()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovieCategoryCrossRefs(crossRefs: List<MovieCategoryCrossRef>)

    @Transaction
    @Query("SELECT * FROM moviecategory WHERE categoryId = :categoryId")
    suspend fun getMoviesOfCategory(categoryId:Int): List<CategoryWithMovies>
}