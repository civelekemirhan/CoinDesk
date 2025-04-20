package com.example.coindesk.feature.onboarding.component


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun CustomButton(onClick: () -> Unit) {

    Button(modifier =
    Modifier
        .height(45.dp)
        .fillMaxWidth(0.4f)
        .background(Color.Transparent, shape = CircleShape),
        contentPadding = PaddingValues(),
        onClick = { onClick() }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black, shape = CircleShape), contentAlignment = Alignment.Center
        ) {
            Text("Devam et", color = Color.White, fontWeight = FontWeight.Bold)
        }

    }

}