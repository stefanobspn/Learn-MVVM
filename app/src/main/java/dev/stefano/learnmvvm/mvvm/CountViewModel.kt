package dev.stefano.learnmvvm.mvvm

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CountViewModel: ViewModel() {
    private val _state = mutableStateOf(CountModel())
    val state: State<CountModel> = _state

    fun addCount() {
        _state.value = _state.value.copy(
            count = _state.value.count + 1
        )
    }
}