package com.example.bibliounifor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.bibliounifor.ui.screens.ForgotPasswordScreen

class TelaRF25 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ForgotPasswordScreen(
                onNavigateBack = { finish() },
                onNavigateToValidation = {
                    // Aqui iria para a tela de validação (RF26)
                    // Por enquanto, apenas fecha ou navega conforme o fluxo
                    finish()
                }
            )
        }
    }
}
