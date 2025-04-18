package com.example.coindesk.feature.main.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.coindesk.common.navigation.Screen
import com.example.coindesk.common.util.Constant.MAIN_NAV_GRAPH
import com.example.coindesk.common.util.Constant.MAIN_SCREEN
import com.example.coindesk.feature.main.ui.MainScreen


fun NavGraphBuilder.mainNavigation(navController: NavHostController){

    navigation(startDestination = MAIN_SCREEN, route = MAIN_NAV_GRAPH){
        composable(route = Screen.Main.route){
            MainScreen { pageName ->


            }
        }
    }

}