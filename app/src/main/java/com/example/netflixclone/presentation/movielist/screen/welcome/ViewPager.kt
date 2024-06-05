package com.example.netflixclone.presentation.movielist.screen.welcome

import android.content.Intent
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.netflixclone.presentation.MainActivity
import com.example.netflixclone.presentation.uiModel.PagerData
import com.example.netflixclone.presentation.uiModel.itemList
import com.example.netflixclone.R
import com.example.netflixclone.util.UiConstants
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState

@ExperimentalPagerApi
@Composable
fun ViewPager() {
    val pageState = rememberPagerState()

    Column() {
        HorizontalPager(
            count = itemList.size,
            state = pageState,
            modifier = Modifier
                .fillMaxSize()
                .weight(9f)
        ) { page ->
            PageUi(pager = itemList[page])
        }
        HorizontalPagerIndicator(
            pagerState = pageState,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
//                .padding(20.dp)
                .weight(1f),
            activeColor = Color.White
        )
    }
}

@Composable
fun PageUi(pager: PagerData) {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Image(
            painter = painterResource(id = pager.imgUri),
            contentDescription = pager.title,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        0.0f to Color.Black,
                        0.25f to Color.Transparent,
                        0.9f to Color.Black
                    )
                )
        )
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .requiredWidth(300.dp)
                .padding(bottom = 60.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = pager.title,
                    textAlign = TextAlign.Center,
                    fontSize = 32.sp,
                    fontFamily = UiConstants.latoFontFamily,
                    lineHeight = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = pager.description,
                    fontSize = 16.sp,
                    fontFamily = UiConstants.latoFontFamily,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                )
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun FullWidthButton(
    buttonText: String,
    containerColor: Color,
    contentColor: Color,
    onClick: () -> Unit
) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp), onClick = onClick,
        shape = RoundedCornerShape(2.dp), colors = ButtonDefaults.buttonColors(
            backgroundColor = containerColor, contentColor = contentColor
        )
    ) {
        Text(text = buttonText)
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheetContent() {
    val context = LocalContext.current
    var emailTextFieldState by remember {
        mutableStateOf("")
    }
    val startAnotherActivity = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        // handle the result of the launched activity if needed
    }
    val scope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        horizontalAlignment = Alignment.End
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_baseline_close_24),
            contentDescription = "close button",
            alignment = Alignment.TopEnd
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Ready to watch?",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            style = TextStyle(fontSize = 24.sp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Enter your email to create or sign in to",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            style = TextStyle(fontSize = 20.sp, color = Color.Gray)
        )
        Text(
            text = "your account.",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            style = TextStyle(fontSize = 20.sp, color = Color.Gray)
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = emailTextFieldState,
            onValueChange = {
                emailTextFieldState = it
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Blue,
                unfocusedBorderColor = Color.Gray
            ),
            label = {
                Text(text = stringResource(R.string.email))
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        FullWidthButton(
            contentColor = Color.White,
            containerColor = Color.Red,
            buttonText = "Get Started"
        )
        {
            val intent = Intent(context, MainActivity::class.java)
            startAnotherActivity.launch(intent)
        }
    }
}

