package com.stdio.iptesttask.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.stdio.iptesttask.presentation.ui.screens.main.MainScreen
import com.stdio.iptesttask.presentation.ui.theme.IPTestTaskTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IPTestTaskTheme {
                MainScreen()
            }
        }
    }
}