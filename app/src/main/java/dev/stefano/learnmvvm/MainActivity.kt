package dev.stefano.learnmvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dev.stefano.learnmvvm.mvvm.CounterView
import dev.stefano.learnmvvm.ui.theme.LearnMVVMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearnMVVMTheme {
                CounterView()
            }
        }
    }
}