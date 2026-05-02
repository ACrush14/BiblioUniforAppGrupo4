package com.example.bibliounifor.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bibliounifor.ui.components.CustomTextField
import com.example.bibliounifor.ui.components.PrimaryButton

@Composable
fun LoginScreen(onNavigateToForgot: () -> Unit, onNavigateToRegister: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var credential by remember { mutableStateOf("") }
    var hasError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Bem vindo de novo!",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        if (hasError) {
            Text(
                text = "Email ou senhas incorretos\nPreencha todos os campos",
                color = Color.Red,
                fontSize = 14.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        Button(
            onClick = { /* Lógica Google Auth */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text("Google", color = Color.Black)
        }

        Spacer(modifier = Modifier.height(24.dp))

        CustomTextField(
            value = email,
            onValueChange = { email = it },
            placeholder = "Digite seu e-mail"
        )
        CustomTextField(
            value = password,
            onValueChange = { password = it },
            placeholder = "Digite sua senha",
            isPassword = true
        )
        CustomTextField(
            value = credential,
            onValueChange = { credential = it },
            placeholder = "Digite sua credencial"
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextButton(onClick = onNavigateToForgot ) {
            Text("Esqueceu a Senha?", color = Color(0xFF4DB6AC))
        }

        PrimaryButton(text = "Entrar", onClick = { /* Lógica de Login */ })

        Row(
            modifier = Modifier.padding(top = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Não tem uma conta? ")
            TextButton(
                onClick =  onNavigateToRegister ,
                contentPadding = PaddingValues(0.dp)
            ) {
                Text("Crie aqui", color = Color(0xFF4DB6AC))
            }
        }
    }
}
