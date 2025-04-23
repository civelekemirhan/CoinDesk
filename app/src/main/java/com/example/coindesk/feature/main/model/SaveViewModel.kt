package com.example.coindesk.feature.main.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coindesk.common.api.CoinDeskApi
import com.example.coindesk.data.room.AppDatabase
import com.example.coindesk.data.room.Saves
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SaveViewModel @Inject constructor(
    private val db: AppDatabase,
    private val api: CoinDeskApi
) : ViewModel() {

    private val savesFlow = db.saveDao().getAll()

    val savedIds = savesFlow.map { it.map { it.new_id }.toSet() }


    private val _news = MutableStateFlow<List<NewsItem>>(emptyList())

    val news = savedIds.map { ids ->
        _news.value.filter { it.id.toInt() in ids }
    }


    fun loadSavesNews() {
        viewModelScope.launch {
            _news.value = api.getLatestNews(
                lang = "EN",
            ).Data
        }
    }

    fun insertNews(new: NewsItem) {
        val savedNew = Saves(new_id = new.id.toInt())
        viewModelScope.launch {
            db.saveDao().insertAll(savedNew)
        }

    }

    fun deleteNew(new_id: Int) {
        viewModelScope.launch {
            db.saveDao().deleteNew(new_id)
        } 
    }


}