package com.example.coindesk.feature.splash.ui

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coindesk.R
import com.example.coindesk.ui.theme.appBackground
import com.example.coindesk.ui.theme.backgroundReverse
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(onNavigate: () -> Unit) {

    var circularIndicatorVisibility by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.appBackground),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth(0.8f),
            contentAlignment = Alignment.Center
        ) {

            Image(painter = painterResource(R.drawable.coindesklogo), contentDescription = null)

            LaunchedEffect(circularIndicatorVisibility) {
                delay(2000)
                circularIndicatorVisibility = false
                onNavigate()
            }


        }

        Spacer(modifier = Modifier.height(40.dp))
        AnimatedVisibility(circularIndicatorVisibility) {
            CircularProgressIndicator(color = MaterialTheme.colorScheme.backgroundReverse)
        }


    }

}

@Composable
@Preview(showSystemUi = true, showBackground = true,uiMode = UI_MODE_NIGHT_YES)
fun PreviewSplashScreen( ) {
    SplashScreen(){

    }
}