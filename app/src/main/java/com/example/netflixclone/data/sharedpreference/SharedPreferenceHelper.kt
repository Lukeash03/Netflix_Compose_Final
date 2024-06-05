package com.example.netflixclone.data.sharedpreference

import android.content.SharedPreferences
import androidx.core.content.edit
import javax.inject.Inject

class SharedPreferenceHelper @Inject constructor(private val sharedPreferences: SharedPreferences) {

    fun setLastFetchedTime(currentTime: Long) {
        sharedPreferences.edit {
            putLong(SharedPreferenceContract.LAST_FETCHED_TIME_KEY, currentTime)
        }
    }

    fun getLastFetchedTime(): Long =
        sharedPreferences.getLong(
            SharedPreferenceContract.LAST_FETCHED_TIME_KEY, 0
        )

}