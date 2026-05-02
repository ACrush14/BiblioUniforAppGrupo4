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
fun ValidationScreen(onNavigateBack: () -> Unit) {
    var code by remember { mutableStateOf("") }
    var codeError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "ICONE",
            fontSize = 32.sp,
            fontWeight = FontWeight.Black,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        Text(
            text = "Redefinir Senha",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "Por favor, insira abaixo o código de\nverificação enviado ao seu e-mail.",
            textAlign = TextAlign.Center,
            fontSize = 14.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "O código será expirado em\n2:00",
            textAlign = TextAlign.Center,
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        if (codeError) {
            Text(
                text = "Código incorreto",
                color = Color.Red,
                fontSize = 12.sp,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 16.dp, bottom = 4.dp)
            )
        }

        CustomTextField(
            value = code,
            onValueChange = { code = it },
            placeholder = "Digite aqui seu código",
            isError = codeError
        )

        Spacer(modifier = Modifier.height(24.dp))

        PrimaryButton(text = "Enviar", onClick = { /* Lógica de validação */ })

        TextButton(onClick = { /* Lógica reenvio */ }, modifier = Modifier.padding(top = 8.dp)) {
            Text("Reenviar código", color = Color(0xFF4DB6AC))
        }

        Spacer(modifier = Modifier.weight(1f))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {
            TextButton(onClick = onNavigateBack) {
                Text("< Voltar", color = Color(0xFF4DB6AC), fontWeight = FontWeight.Bold)
            }
        }
    }
}