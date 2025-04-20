package com.example.coindesk.feature.main.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coindesk.common.api.CoinDeskApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(api: CoinDeskApi): ViewModel() {


    private val _news = MutableStateFlow<List<NewsItem>>(emptyList())
    val news= _news

    init {
        viewModelScope.launch(Dispatchers.IO) {
            news.value = api.getLatestNews(
                lang = "EN",
            ).Data
        }
    }


}