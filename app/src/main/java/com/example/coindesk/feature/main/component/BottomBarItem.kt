package com.example.coindesk.feature.main.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarItem( val route : String, val title : String, val icon : ImageVector){

    object Home : BottomBarItem("home", "Home", Icons.Default.Home)
    object Saves : BottomBarItem("saves", "Saves",Icons.Default.Star)
    object Profile : BottomBarItem("profile", "Profile",Icons.Default.Person)
    object News : BottomBarItem("news", "News",Icons.Default.Face)


}