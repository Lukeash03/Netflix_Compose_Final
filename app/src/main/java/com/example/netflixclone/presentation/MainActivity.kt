package com.example.netflixclone.presentation

import android.graphics.Movie
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Search
import androidx.lifecycle.MutableLiveData
import androidx.navigation.compose.rememberNavController
import com.example.netflixclone.presentation.movielist.screen.navigation.BottomNavItem
import com.example.netflixclone.presentation.movielist.screen.navigation.BottomNavigationBar
import com.example.netflixclone.presentation.movielist.screen.navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            Scaffold(bottomBar = {
                BottomNavigationBar(
                    items = listOf(
                        BottomNavItem(
                            name = "Home",
                            route = "home",
                            icon = Icons.Default.Home
                        ),
                        BottomNavItem(
                            name = "Fast Laugh",
                            route = "fast laugh",
                            icon = Icons.Default.Face
                        ),
                        BottomNavItem(
                            name = "Search",
                            route = "search",
                            icon = Icons.Default.Search
                        ),
                        BottomNavItem(
                            name = "Downloads",
                            route = "downloads",
                            icon = Icons.Default.KeyboardArrowDown
                        )
                    ), navController = navController, onItemClick = {
                        navController.navigate(it.route)
                    })

            }) {
                Navigation(navController = navController)
            }
        }


    }
}


