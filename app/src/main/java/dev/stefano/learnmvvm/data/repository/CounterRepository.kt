package dev.stefano.learnmvvm.data.repository

import dev.stefano.learnmvvm.data.model.CounterModel

interface CounterRepository {
    suspend fun getCounter(): CounterModel
    suspend fun incrementCounter(counter: CounterModel): CounterModel
    suspend fun resetCounter(counter: CounterModel): CounterModel
}