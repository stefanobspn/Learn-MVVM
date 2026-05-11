package dev.stefano.learnmvvm.data.repository

import dev.stefano.learnmvvm.data.model.CounterModel
import javax.inject.Inject

class CounterRepositoryImpl @Inject constructor(private val dao: CounterDao): CounterRepository {
    override suspend fun getCounter(): CounterModel {
        return dao.getCounter() ?: CounterModel(count = 0)
    }

    override suspend fun incrementCounter(counter: CounterModel): CounterModel {
        val newCounter = counter.copy(count = counter.count + 1)
        dao.insertCounter(newCounter)

        return newCounter
    }

    override suspend fun resetCounter(counter: CounterModel): CounterModel {
        val newCounter = counter.copy(count = 0)
        dao.insertCounter(newCounter)

        return newCounter
    }
}