package com.example.netflixclone.di

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.netflixclone.common.Constants
import com.example.netflixclone.data.local.MovieDao
import com.example.netflixclone.data.local.MovieDataBase
import com.example.netflixclone.data.remote.MovieApi
import com.example.netflixclone.data.repository.MovieRepositoryImpl
import com.example.netflixclone.data.sharedpreference.SharedPreferenceHelper
import com.example.netflixclone.domain.repository.MovieRepository
import com.example.netflixclone.domain.usecase.getmovies.GetPopularMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMovieApi(): MovieApi {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieApi::class.java)
    }

    @Volatile
    private var INSTANCE: MovieDataBase? = null

    private class MovieDatabaseCallback() : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let {
                CoroutineScope(Dispatchers.IO).launch {
                    it.movieDao().insertCategory(Constants.movieCategories)
                }
            }
        }
    }

    @Singleton
    @Provides
    fun provideMovieDataBase(
        @ApplicationContext applicationContext: Context
    ): MovieDataBase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                applicationContext,
                MovieDataBase::class.java,
                "movie_db"
            )
                .addCallback(MovieDatabaseCallback())
                .build()
                .also {
                    INSTANCE = it
                }
            instance
        }
    }

    @Singleton
    @Provides
    fun providesMovieDao(database: MovieDataBase):MovieDao =
        database.movieDao()


    @Provides
    @Singleton
    fun provideSharedPreference(@ApplicationContext applicationContext: Context): SharedPreferences{
        return PreferenceManager.getDefaultSharedPreferences(applicationContext)
    }
    @Provides
    @Singleton
    fun provideSharedpreferenceHelper(sharedPreferences: SharedPreferences):SharedPreferenceHelper =
        SharedPreferenceHelper(sharedPreferences)




    @Provides
    @Singleton
    fun provideMovieRepository(api: MovieApi, movieDao: MovieDao,sharedPreferenceHelper: SharedPreferenceHelper): MovieRepository {
        return MovieRepositoryImpl(api, movieDao,sharedPreferenceHelper)
    }

    @Provides
    @Singleton
    fun provideGetPopularMoviesUseCase(movieRepository: MovieRepository): GetPopularMoviesUseCase {
        return GetPopularMoviesUseCase(movieRepository)
    }

}