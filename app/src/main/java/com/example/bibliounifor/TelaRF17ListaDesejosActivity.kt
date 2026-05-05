package com.example.bibliounifor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.bibliounifor.ui.screens.TelaListaDesejosScreen

class TelaRF17ListaDesejosActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TelaListaDesejosScreen()
        }
    }
}
