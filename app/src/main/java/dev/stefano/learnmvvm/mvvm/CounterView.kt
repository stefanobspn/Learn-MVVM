package dev.stefano.learnmvvm.mvvm

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CountView(myViewModel: CounterViewModel = viewModel()) {
    val data = myViewModel.state.value

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Count : ${data.count}")
        Button(onClick = { myViewModel.addCount() }) {
            Text("Add Count")
        }

        Button(onClick = { myViewModel.resetCount() }) {
            Text("Reset Count")
        }
    }
}