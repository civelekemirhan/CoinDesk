package com.example.coindesk.feature.main.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.coindesk.feature.main.component.NewsCard
import com.example.coindesk.feature.main.model.HomeViewModel
import com.example.coindesk.feature.main.model.SaveViewModel

@Composable
fun SaveScreen() {

    val saveViewModel = hiltViewModel<SaveViewModel>()

    val filteredNews by saveViewModel.news.collectAsState(initial = emptyList())

    var isNewsLoading by remember {
        mutableStateOf(true)
    }

    LaunchedEffect(Unit) {
        saveViewModel.loadSavesNews()
    }


    AnimatedVisibility(isNewsLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }



    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (filteredNews.isNotEmpty()) {
                isNewsLoading = false
                items(filteredNews) { data ->
                    NewsCard(new = data) { savedData ->
                        saveViewModel.deleteNew(savedData.id.toInt())
                    }
                }
            }

        }

    }

}