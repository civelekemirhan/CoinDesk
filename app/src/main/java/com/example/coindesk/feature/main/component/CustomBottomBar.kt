package com.example.coindesk.feature.main.component

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun CustomBottomBar(
    currentSelectedScreen: BottomBarItem,
    onSelected: (page:BottomBarItem) -> Unit
) {

    val items = listOf(
        BottomBarItem.Home,
        BottomBarItem.Saves,
        BottomBarItem.Profile,
        BottomBarItem.News
    )

    NavigationBar {
        items.forEach { item ->
            AddItem(
                screen = item,
                isSelected = item.route == currentSelectedScreen.route,
                onClick = {
                    onSelected(item)
                }
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarItem,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    NavigationBarItem(
        label = { Text(text = screen.title) },
        icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription = screen.title
            )
        },
        selected = isSelected,
        alwaysShowLabel = true,
        onClick = onClick
    )
}
