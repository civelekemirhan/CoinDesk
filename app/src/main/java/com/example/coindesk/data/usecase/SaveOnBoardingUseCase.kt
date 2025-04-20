package com.example.coindesk.data.usecase

import com.example.coindesk.data.datastore.DataStoreRepository
import javax.inject.Inject

class SaveOnBoardingUseCase @Inject constructor(private val repository: DataStoreRepository) {
   suspend operator fun invoke(completed: Boolean){
        repository.saveOnBoardingState(completed)
    }
}