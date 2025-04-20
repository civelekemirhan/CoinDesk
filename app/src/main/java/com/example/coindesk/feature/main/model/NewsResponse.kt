package com.example.coindesk.feature.main.model

data class NewsResponse(
    val Data: List<NewsItem>,
    val HasWarning: Boolean,
    val Message: String,
    val Promoted: List<Any>,
    val RateLimit: RateLimit,
    val Type: Int
)