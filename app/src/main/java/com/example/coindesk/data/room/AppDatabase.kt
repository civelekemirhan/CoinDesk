package com.example.coindesk.data.room

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Saves::class], version = 1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun saveDao(): SaveDAO
}