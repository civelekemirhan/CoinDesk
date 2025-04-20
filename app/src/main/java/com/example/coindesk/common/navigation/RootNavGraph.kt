package com.example.coindesk.common.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.coindesk.common.util.Constant.ROOT_NAV_GRAPH
import com.example.coindesk.common.util.Constant.SPLASH_NAV_GRAPH
import com.example.coindesk.feature.main.navigation.mainNavigation
import com.example.coindesk.feature.onboarding.navigation.onBoardingNavigation
import com.example.coindesk.feature.splash.navigation.splashNavigation


@Composable
fun SetupNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = SPLASH_NAV_GRAPH,
        route = ROOT_NAV_GRAPH
    ) {

        splashNavigation(navController)

        onBoardingNavigation(navController)

        mainNavigation(navController)



    }

}