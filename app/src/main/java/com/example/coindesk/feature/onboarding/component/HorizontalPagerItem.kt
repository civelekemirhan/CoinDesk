package com.example.coindesk.feature.onboarding.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coindesk.feature.onboarding.ui.OnBoarding

@Composable
fun HorizontalPagerItem(page: OnBoarding) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
    ) {
        Image(
            modifier = Modifier.height(200.dp).width(300.dp),
            painter = painterResource(id = page.image),
            contentDescription = "Image",
            contentScale = ContentScale.Crop,
        )

        Spacer(modifier = Modifier.height(30.dp))

        Column(
            modifier = Modifier.fillMaxWidth(0.8f),
            verticalArrangement = Arrangement.Center,
        ) {
            Row {
                Text(
                    stringResource(page.title),
                    fontSize = 30.sp,
                )
            }
            Row {
                Text(
                    stringResource(page.subtitle),
                    fontSize = 20.sp,
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row {
                Text(
                    stringResource(page.description),
                    fontSize = 16.sp,
                    textAlign = TextAlign.Justify,
                )
            }
        }
    }
}
