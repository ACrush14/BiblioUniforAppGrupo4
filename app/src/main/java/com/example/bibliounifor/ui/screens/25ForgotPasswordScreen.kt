package com.example.bibliounifor.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bibliounifor.ui.components.CustomTextField
import com.example.bibliounifor.ui.components.PrimaryButton

@Composable
fun ForgotPasswordScreen(onNavigateBack: () -> Unit, onNavigateToValidation: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var emailError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Icone",
            fontSize = 32.sp,
            fontWeight = FontWeight.Black,
            modifier = Modifier.padding(bottom = 24.dp)
        )
        Text(
            text = "Redefinir senha",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "Insira abaixo o e-mail vinculado à sua conta.",
            textAlign = TextAlign.Center,
            fontSize = 14.sp,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        if (emailError) {
            Text(
                text = "Email não cadastrado",
                color = Color.Red,
                fontSize = 12.sp,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 16.dp, bottom = 4.dp)
            )
        }

        CustomTextField(
            value = email,
            onValueChange = { email = it },
            placeholder = "Digite seu e-mail",
            isError = emailError
        )

        Spacer(modifier = Modifier.height(24.dp))

        PrimaryButton(text = "Enviar Código", onClick = onNavigateToValidation)

        TextButton(onClick = onNavigateBack, modifier = Modifier.padding(top = 8.dp)) {
            Text("Retornar à tela de login", color = Color(0xFF4DB6AC))
        }
    }
}