package com.example.coindesk.feature.onboarding.ui


import com.example.coindesk.R

sealed class OnBoarding(val title: Int, val subtitle: Int, val description: Int, val image: Int) {
    data object First : OnBoarding(
        R.string.onboarding_title_1,
        R.string.onboarding_subtitle_1,
        R.string.onboarding_description_1,
        R.drawable.coindesk1
    )

    data object Second : OnBoarding(
        R.string.onboarding_title_2,
        R.string.onboarding_subtitle_2,
        R.string.onboarding_description_2,
        R.drawable.coindesk2
        )

    data object Third : OnBoarding(
        R.string.onboarding_title_3,
        R.string.onboarding_subtitle_3,
        R.string.onboarding_description_3,
        R.drawable.coindesk3
    )

    data object Fourth : OnBoarding(
        R.string.onboarding_title_4,
        R.string.onboarding_subtitle_4,
        R.string.onboarding_description_4
        ,R.drawable.coindesk4
    )

}