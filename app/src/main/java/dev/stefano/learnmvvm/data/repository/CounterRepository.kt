package dev.stefano.learnmvvm.data.repository

import dev.stefano.learnmvvm.data.model.CounterModel
import kotlinx.coroutines.flow.Flow

interface CounterRepository {
    fun getCounterFlow(): Flow  <CounterModel?>
    suspend fun incrementCounter(counter: CounterModel): CounterModel
    suspend fun resetCounter(counter: CounterModel)
}