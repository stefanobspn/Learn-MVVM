package dev.stefano.learnmvvm.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "counter_table")
data class CounterModel (
    @PrimaryKey val id: Int = 1,
    val count: Int
)