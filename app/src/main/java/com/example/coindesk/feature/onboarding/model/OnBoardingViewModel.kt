package com.example.coindesk.feature.onboarding.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.coindesk.data.usecase.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(private val useCases: UseCases): ViewModel(){


    fun onCompleted(completed: Boolean){
        viewModelScope.launch {
            useCases.saveOnBoardingUseCase.invoke(completed)
        }
    }

}