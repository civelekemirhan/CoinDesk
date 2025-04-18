package com.example.coindesk.common.navigation

import com.example.coindesk.common.util.Constant.DETAILS_SCREEN
import com.example.coindesk.common.util.Constant.MAIN_SCREEN
import com.example.coindesk.common.util.Constant.ONBOARDING_SCREEN
import com.example.coindesk.common.util.Constant.SPLASH_SCREEN

sealed class Screen(val route: String) {
    object Splash : Screen(route = SPLASH_SCREEN)
    object Onboarding : Screen(route = ONBOARDING_SCREEN)
    object Main : Screen(route= MAIN_SCREEN)
    object Details : Screen(route = DETAILS_SCREEN)
}