package com.example.coindesk.data.datastore

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map



 val Context.dataStore:DataStore<Preferences> by preferencesDataStore(name = "on_boarding_pref")

class DataStoreImpl(private val dataStore: DataStore<Preferences>) : DataStoreRepository{

    private val ONBOARDING_KEY = booleanPreferencesKey(name = "on_boarding_completed")

    override suspend fun saveOnBoardingState(completed: Boolean) {
       dataStore.edit { it->
            it[ONBOARDING_KEY] = completed
       }
    }

    override fun readOnBoardingState(): Flow<Boolean> {
      return  dataStore.data.map {
            it[ONBOARDING_KEY] ?:false
        }
    }
}