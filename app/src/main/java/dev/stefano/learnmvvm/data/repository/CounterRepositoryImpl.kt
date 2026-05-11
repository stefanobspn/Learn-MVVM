package dev.stefano.learnmvvm.data.repository

import dev.stefano.learnmvvm.data.model.CounterModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CounterRepositoryImpl @Inject constructor(private val dao: CounterDao): CounterRepository {
    override fun getCounterFlow(): Flow<CounterModel?> = dao.getCounterFlow()

    override suspend fun incrementCounter(counter: CounterModel): CounterModel {
        val newCounter = counter.copy(count = counter.count + 1)
        dao.insertCounter(newCounter)

        return newCounter
    }

    override suspend fun resetCounter(counter: CounterModel) {
        val newCounter = counter.copy(count = 0)
        dao.insertCounter(newCounter)
    }
}