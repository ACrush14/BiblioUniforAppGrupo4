package com.example.bibliounifor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.bibliounifor.ui.screens.TelaMinhaLivrariaScreen

class TelaRF16MinhaLivrariaActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TelaMinhaLivrariaScreen(
                onNavigate = { route ->
                    // Lógica de navegação do Compose se necessário
                }
            )
        }
    }
}
