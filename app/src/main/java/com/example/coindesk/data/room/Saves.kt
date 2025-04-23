package com.example.coindesk.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "saves_news")
data class Saves (
    @PrimaryKey(autoGenerate = true)
    val save_id: Int =0,
    val new_id:Int
)