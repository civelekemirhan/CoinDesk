package com.example.coindesk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.coindesk.common.navigation.SetupNavGraph
import com.example.coindesk.data.room.AppDatabase
import com.example.coindesk.ui.theme.CoinDeskTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            CoinDeskTheme {
                SetupNavGraph(rememberNavController())
            }
        }
    }
}

