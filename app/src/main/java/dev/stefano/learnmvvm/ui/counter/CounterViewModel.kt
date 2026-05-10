package dev.stefano.learnmvvm.ui.counter

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.stefano.learnmvvm.data.model.CounterModel
import dev.stefano.learnmvvm.data.repository.CounterRepository
import javax.inject.Inject

@HiltViewModel
class CounterViewModel @Inject constructor(
    private val repository: CounterRepository
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