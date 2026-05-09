package dev.stefano.learnmvvm.mvvm

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dev.stefano.learnmvvm.mvvm.data.CounterModel
import dev.stefano.learnmvvm.mvvm.data.CounterRepository
import dev.stefano.learnmvvm.mvvm.data.CounterRepositoryImpl

class CounterViewModel(
    private val repository: CounterRepository = CounterRepositoryImpl()
): ViewModel() {
    private val _state = mutableStateOf(repository.getCounter())
    val state: State<CounterModel> = _state

    fun addCount() {
        _state.value = repository.incrementCounter(_state.value)
    }

    fun resetCount() {
        _state.value = repository.resetCounter(_state.value)
    }
}