package dev.stefano.learnmvvm.ui.counter

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.stefano.learnmvvm.data.model.CounterModel
import dev.stefano.learnmvvm.data.repository.CounterRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CounterViewModel @Inject constructor(
    private val repository: CounterRepository
): ViewModel() {
    private val _state = mutableStateOf(CounterModel(count = 0))
    val state: State<CounterModel> = _state

    init {
        viewModelScope.launch {
            _state.value = repository.getCounter()
        }
    }

    fun addCount() {
        viewModelScope.launch {
            _state.value = repository.incrementCounter(_state.value)
        }
    }

    fun resetCount() {
        viewModelScope.launch {
            _state.value = repository.resetCounter(_state.value)
        }
    }
}