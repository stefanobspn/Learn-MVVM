package dev.stefano.learnmvvm.data.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.stefano.learnmvvm.data.model.CounterModel
import kotlinx.coroutines.flow.Flow

@Dao
interface CounterDao {
    @Query("SELECT * FROM counter_table WHERE id = 1")
    fun getCounterFlow(): Flow<CounterModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCounter(counter: CounterModel)
}