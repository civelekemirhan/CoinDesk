package com.example.coindesk.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface SaveDAO {

    @Query("SELECT * FROM saves_news")
    fun getAll(): Flow<List<Saves>>

    @Insert
    suspend fun insertAll(saveNew: Saves)

    @Query("DELETE FROM saves_news WHERE new_id = :new_id")
    suspend fun deleteNew(new_id: Int)


}