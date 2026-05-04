package com.example.bibliounifor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.bibliounifor.ui.screens.TelaGestaoAmigosScreen

class TelaRF18 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TelaGestaoAmigosScreen()
        }
    }
}
