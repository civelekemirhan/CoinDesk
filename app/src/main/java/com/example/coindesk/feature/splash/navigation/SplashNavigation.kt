package com.example.coindesk.feature.splash.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.coindesk.common.navigation.Screen
import com.example.coindesk.common.util.Constant.SPLASH_NAV_GRAPH
import com.example.coindesk.common.util.Constant.SPLASH_SCREEN
import com.example.coindesk.feature.splash.ui.SplashScreen


fun NavGraphBuilder.splashNavigation(navController: NavHostController){

    navigation(startDestination = SPLASH_SCREEN, route = SPLASH_NAV_GRAPH){
        composable(route = Screen.Splash.route){
            SplashScreen { targetDestination ->
                    navController.navigate(targetDestination.route){
                        popUpTo(Screen.Splash.route){
                            inclusive = true
                        }
                    }
            }
        }
    }

}