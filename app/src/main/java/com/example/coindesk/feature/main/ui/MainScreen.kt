package com.example.coindesk.feature.main.ui

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.togetherWith
import androidx.compose.animation.with
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.coindesk.feature.main.component.BottomBarItem
import com.example.coindesk.feature.main.component.CustomBottomBar
import com.example.coindesk.ui.theme.backgroundReverse


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(onNavigation : (pageName : String) -> Unit){

    var selectedItem by remember { mutableStateOf<BottomBarItem>(BottomBarItem.Home) }
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        selectedItem.title,
                        style = MaterialTheme.typography.headlineLarge,
                        color = MaterialTheme.colorScheme.backgroundReverse,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            )

        },
        bottomBar = {
            CustomBottomBar(
                currentSelectedScreen = selectedItem,
                onSelected = { it->
                    selectedItem = it
                    onNavigation(it.route)
                }
            )
        }
    ){ it->
        Box(modifier = Modifier.fillMaxSize().padding(it), contentAlignment = Alignment.Center){
            AnimatedContent(selectedItem) {targetState->

                when(targetState){
                    BottomBarItem.Home -> HomeScreen()
                    BottomBarItem.Saves -> SaveScreen()
                    BottomBarItem.Profile -> ProfileScreen()
                    BottomBarItem.News -> NewsScreen()
                }

            }

        }
    }
}