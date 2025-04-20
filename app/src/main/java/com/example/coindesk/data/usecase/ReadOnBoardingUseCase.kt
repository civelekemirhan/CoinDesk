package com.example.coindesk.data.usecase

import com.example.coindesk.data.datastore.DataStoreRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ReadOnBoardingUseCase @Inject constructor(private val repository: DataStoreRepository) {
     operator fun invoke(): Flow<Boolean> {
      return repository.readOnBoardingState()
    }
}