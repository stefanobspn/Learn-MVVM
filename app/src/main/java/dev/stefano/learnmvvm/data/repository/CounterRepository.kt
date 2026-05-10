package dev.stefano.learnmvvm.data.repository

import dev.stefano.learnmvvm.data.model.CounterModel

interface CounterRepository {
    fun getCounter(): CounterModel
    fun incrementCounter(current: CounterModel): CounterModel
    fun resetCounter(current: CounterModel): CounterModel
}