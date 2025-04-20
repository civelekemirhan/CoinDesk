package com.example.coindesk.feature.splash.model

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coindesk.data.usecase.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val useCases: UseCases): ViewModel() {

    private val _isOnBoardingCompleted = MutableStateFlow(false)
    val isOnBoardingCompleted = _isOnBoardingCompleted

    init {
        viewModelScope.launch {
           useCases.readOnBoardingUseCase.invoke().collectLatest { it->
               _isOnBoardingCompleted.value = it
           }
        }

    }

}