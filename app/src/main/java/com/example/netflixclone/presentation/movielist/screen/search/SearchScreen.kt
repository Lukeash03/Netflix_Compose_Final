package com.example.netflixclone.presentation.movielist.screen.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.netflixclone.R





@Composable
fun SearchScreen() {
    Column(
        modifier = Modifier
            .background(Color.Black)
            .padding(16.dp)
    ) {
        SearchBar()
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 8.dp)
        ) {
            TopSearchesList()
        }
    }
}

@Composable
fun SearchBar() {
    val searchBarTextState = remember {
        mutableStateOf("")
    }
    Box(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(20.dp))
            .background(color = Color.DarkGray)
            .height(50.dp)
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clip(shape = RoundedCornerShape(20.dp))
        ) {
            // Search Icon
            Image(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "Search Icon",
                colorFilter = ColorFilter.tint(Color.LightGray),
                modifier = Modifier.padding(vertical = 16.dp)
            )

            // Search TextField.
            TextField(
                value = searchBarTextState.value,
                onValueChange = { searchBarTextState.value = it },
                modifier = Modifier
                    .fillMaxSize(), trailingIcon = {
                    Icon(
                        Icons.Rounded.Clear,
                        contentDescription = "Search bar clear button",
                        modifier = Modifier
                            .offset(x = 10.dp)
                            .clickable {
                                searchBarTextState.value = ""
                            }, tint = Color.LightGray
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Black,
                    disabledTextColor = Color.Transparent,
                    backgroundColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )
            )
        }
    }
}

@Composable
fun TopSearchesList() {
    LazyColumn() {
        items(items = (1..10).toList()) {
            TopSearchedCardItem()
        }
    }

}

@Composable
fun TopSearchedCardItem() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        // Top searches result image.
        Image(
            painter = painterResource(id = R.drawable.strangerthings),
            contentDescription = "",
            modifier = Modifier
                .width(160.dp)
                .height(100.dp),
            contentScale = ContentScale.Crop
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(start = 16.dp)
                .fillMaxWidth()
        ) {
            // Top search result title.
            Text(
                text = "Stranger Things",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                ), modifier = Modifier.weight(1f)
            )
            // Top search result card play button.
            IconButton(
                onClick = {}, modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_round_play_circle),
                    contentDescription = "Play Button",
                    colorFilter = ColorFilter.tint(Color.White),
                    modifier = Modifier
                        .height(40.dp)
                        .width(40.dp)
                )
            }
        }
    }
}




data class ItemData(val title: String, val imageResId: Int)
fun generateDummyData(): List<ItemData> {
    return listOf(
        ItemData("Item 1", R.drawable.strangerthings),
        ItemData("Item 2", R.drawable.strangerthings),
        ItemData("Item 3", R.drawable.strangerthings),
        ItemData("Item 4", R.drawable.strangerthings)
    )
}