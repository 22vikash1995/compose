package com.example.composedemoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.composedemoapp.ui.theme.ComposeDemoAppTheme
import com.example.composedemoapp.view.screens.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemoAppTheme {
                MainScreen()
            }
        }
    }
}

