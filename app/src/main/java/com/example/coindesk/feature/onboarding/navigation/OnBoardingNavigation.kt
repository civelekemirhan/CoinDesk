package com.example.coindesk.feature.onboarding.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.coindesk.common.navigation.Screen
import com.example.coindesk.common.util.Constant.ONBOARDING_NAV_GRAPH
import com.example.coindesk.common.util.Constant.ONBOARDING_SCREEN
import com.example.coindesk.feature.onboarding.ui.OnBoardingScreen


fun NavGraphBuilder.onBoardingNavigation(navController: NavHostController){

    navigation(startDestination = ONBOARDING_SCREEN, route = ONBOARDING_NAV_GRAPH){
        composable(route = Screen.Onboarding.route){
            OnBoardingScreen {
                navController.navigate(Screen.Main.route){
                    popUpTo(Screen.Onboarding.route){
                        inclusive = true
                    }
                }
            }
        }
    }

}