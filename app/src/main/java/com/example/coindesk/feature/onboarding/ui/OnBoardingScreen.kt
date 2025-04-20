package com.example.coindesk.feature.onboarding.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.coindesk.feature.onboarding.component.CustomButton
import com.example.coindesk.feature.onboarding.component.HorizontalPagerItem
import com.example.coindesk.feature.onboarding.model.OnBoardingViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Composable
fun OnBoardingScreen(onNavigate: () -> Unit) {

    val viewModel : OnBoardingViewModel = hiltViewModel()

    val pages = listOf(
        OnBoarding.First,
        OnBoarding.Second,
        OnBoarding.Third,
        OnBoarding.Fourth
    )

    val pagerState = rememberPagerState {
        pages.size
    }

    var isButtonEnabled by remember {
        mutableStateOf(false)
    }

    val scope = rememberCoroutineScope()

    Scaffold { paddingValue ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValue),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {

            Row(
                Modifier
                    .weight(0.1f)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 8.dp, end = 8.dp),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.Bottom,
            ) {
                TextButton(
                    {
                        scope.launch(Dispatchers.Main) {
                            viewModel.onCompleted(true)
                        }
                        onNavigate()
                    },
                ) {
                    Text(
                        "Skip",
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.Black,
                    )
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = "Skip",
                        tint = Color.Black,
                    )
                }
            }
            Row(
                modifier = Modifier
                    .weight(0.6f)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {

                HorizontalPager(pagerState) { page ->
                    HorizontalPagerItem(page = pages[page])
                }
            }
            Row(
                Modifier
                    .weight(0.2f)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 8.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                HorizontalIndicator(pagerState) { isButtonEnabled = it }
            }
            Row(
                Modifier
                    .weight(0.2f)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {
                AnimatedVisibility(isButtonEnabled) {
                    CustomButton {
                        scope.launch(Dispatchers.Main) {
                            viewModel.onCompleted(true)
                        }
                        onNavigate()
                    }
                }
            }
        }
    }
}


@Composable
private fun HorizontalIndicator(pagerState: PagerState, setButtonEnabled: (Boolean) -> Unit) {
    repeat(pagerState.pageCount) { iteration ->
        val color = if (pagerState.currentPage == iteration) Color.Black else Color.Transparent
        /* TODO  UI Theme moda göre renkler ayarlanmalı */
        Box(
            modifier = Modifier
                .padding(2.dp)
                .border(1.dp, Color.Black, CircleShape)
                .background(color, CircleShape)
                .size(25.dp),
        )
        if (iteration != pagerState.pageCount - 1) {
            Spacer(modifier = Modifier.padding(end = 24.dp))
        }
        LaunchedEffect(pagerState.currentPage) {
            setButtonEnabled(pagerState.currentPage == pagerState.pageCount - 1)
        }
    }
}