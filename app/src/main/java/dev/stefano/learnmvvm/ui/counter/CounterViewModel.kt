package dev.stefano.learnmvvm.ui.counter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.stefano.learnmvvm.data.model.CounterModel
import dev.stefano.learnmvvm.data.repository.CounterRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CounterViewModel @Inject constructor(
    private val repository: CounterRepository
): ViewModel() {
    val state: StateFlow<CounterModel> = repository.getCounterFlow()
        .map { it ?: CounterModel(count = 0) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = CounterModel(count = 0)
        )


    fun addCount() {
        viewModelScope.launch {
            repository.incrementCounter(state.value)
        }
    }

    fun resetCount() {
        viewModelScope.launch {
            repository.resetCounter(state.value)
        }
    }
}