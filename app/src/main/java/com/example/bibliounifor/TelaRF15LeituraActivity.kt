package com.example.bibliounifor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.bibliounifor.ui.screens.TelaLeituraScreen

class TelaRF15LeituraActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        
        val livroId = intent.getIntExtra("LIVRO_ID", 1)
        
        setContent {
            TelaLeituraScreen(
                livroId = livroId,
                onBack = { finish() }
            )
        }
    }
}
