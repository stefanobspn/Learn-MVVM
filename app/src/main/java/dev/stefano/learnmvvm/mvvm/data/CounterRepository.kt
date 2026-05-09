package dev.stefano.learnmvvm.mvvm.data

interface CounterRepository {
    fun getCounter(): CounterModel
    fun incrementCounter(current: CounterModel): CounterModel
    fun resetCounter(current: CounterModel): CounterModel
}