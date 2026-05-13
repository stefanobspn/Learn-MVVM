package dev.stefano.learnmvvm.mvvm

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel: ViewModel() {
    private val _state = mutableStateOf(CounterModel())
    val state: State<CounterModel> = _state

    fun addCount() {
        _state.value = _state.value.copy(count = _state.value.count + 1)
    }
}