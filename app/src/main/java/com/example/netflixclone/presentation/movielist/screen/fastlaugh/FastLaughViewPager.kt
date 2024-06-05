package com.example.netflixclone.presentation.movielist.screen.fastlaugh

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.netflixclone.presentation.uiModel.FastLaughPagerData
import com.example.netflixclone.presentation.uiModel.fastLaughList
import com.google.accompanist.pager.*

@OptIn(ExperimentalPagerApi::class)
@Composable
fun FastLaughViewPager() {
    val pageState = rememberPagerState()

    Column() {
        VerticalPager(
            count = fastLaughList.size,
            state = pageState,
            modifier = Modifier
                .fillMaxSize()
        ) { page ->
            FastLaughPageUi(pager = fastLaughList[page])
        }

    }
}

@Composable
fun FastLaughPageUi(pager: FastLaughPagerData) {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
    ) {




        Column(
            modifier = Modifier
                .background(color = pager.color)
                .absolutePadding(right = 20.dp, bottom = 25.dp)
                .fillMaxWidth()
                .height(80.dp),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Bottom
        ) {

            Image(
                painter = painterResource(id = pager.image1),
                contentDescription = "",
                Modifier.size(30.dp)
            )
            Text(
                text = pager.text1,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.absolutePadding(right = 5.dp),
                color = Color.White
            )
            Spacer(modifier = Modifier.height(20.dp))
            Image(
                painter = painterResource(id = pager.image2),
                contentDescription = "",
                Modifier.size(30.dp)
            )
            Text(
                text = pager.text2,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.absolutePadding(right = 0.dp),
                color = Color.White
            )
            Spacer(modifier = Modifier.height(20.dp))
            Image(
                painter = painterResource(id = pager.image3),
                contentDescription = "",
                Modifier.size(30.dp)
            )
            Text(
                text = pager.text3,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.absolutePadding(right = 0.dp),
                color = Color.White
            )
            Spacer(modifier = Modifier.height(20.dp))
            Image(
                painter = painterResource(id = pager.image4),
                contentDescription = "",
                Modifier.size(30.dp)
            )
            Text(
                text = pager.text4,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.absolutePadding(right = 0.dp),
                color = Color.White
            )
            Spacer(modifier = Modifier.height(20.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = pager.volumeImage),
                    contentDescription = "",
                    alignment = Alignment.BottomStart, modifier = Modifier
                        .padding(15.dp)
                        .size(30.dp)
                )
            }


        }
    }


}

