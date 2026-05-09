package dev.stefano.learnmvvm.mvvm.data

class CounterRepositoryImpl: CounterRepository {
    override fun getCounter(): CounterModel = CounterModel(count = 0)

    override fun incrementCounter(current: CounterModel): CounterModel {
        return current.copy(count = current.count + 1)
    }

    override fun resetCounter(current: CounterModel): CounterModel {
        return current.copy(count = 0)
    }
}