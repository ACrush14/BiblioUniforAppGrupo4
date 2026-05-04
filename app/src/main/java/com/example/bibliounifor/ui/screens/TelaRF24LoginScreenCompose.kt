package com.example.bibliounifor.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bibliounifor.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    onNavigateToForgot: () -> Unit,
    onNavigateToRegister: () -> Unit,
    onLoginSuccess: () -> Unit,
    onNavigateBack: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var credential by remember { mutableStateOf("") }
    var hasError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F7F7))
            .verticalScroll(rememberScrollState())
    ) {
        // HEADER - Corrigido para evitar erro de renderização no Preview
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(BiblioCyan),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .background(Color.White.copy(alpha = 0.3f), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = null,
                        modifier = Modifier.size(60.dp),
                        tint = Color.White
                    )
                }
                Text(
                    text = "Acesse sua conta ADM",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }

        // CONTEÚDO
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        ) {
            Text(
                text = "Bem vindo de novo!",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = BiblioDark,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            if (hasError) {
                Text(
                    text = "Email, senha ou credencial incorretos",
                    color = Color.Red,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }

            // Botão Google
            Button(
                onClick = { /* Lógica Google Auth */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                shape = RoundedCornerShape(12.dp),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 2.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
            ) {
                Text("Google", color = Color.Black)
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Inputs com fundo branco e arredondados
            AdminTextField(
                value = email,
                onValueChange = { email = it },
                placeholder = "Digite seu e-mail"
            )
            Spacer(modifier = Modifier.height(12.dp))
            AdminTextField(
                value = password,
                onValueChange = { password = it },
                placeholder = "Digite sua senha",
                isPassword = true
            )
            Spacer(modifier = Modifier.height(12.dp))
            AdminTextField(
                value = credential,
                onValueChange = { credential = it },
                placeholder = "Digite sua credencial"
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextButton(
                onClick = onNavigateToForgot,
                contentPadding = PaddingValues(0.dp)
            ) {
                Text("Esqueceu a Senha?", color = BiblioCyan)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    if (email == "a" && password == "b" && credential == "c") {
                        onLoginSuccess()
                    } else {
                        hasError = true
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                colors = ButtonDefaults.buttonColors(containerColor = BiblioCyan),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Entrar", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Não tem uma conta? ", color = Color(0xFF415E5E))
                TextButton(
                    onClick = onNavigateToRegister,
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Text("Crie aqui", color = BiblioCyan, fontWeight = FontWeight.Bold)
                }
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            TextButton(onClick = onNavigateBack) {
                Text("← Voltar", color = BiblioCyan)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    isPassword: Boolean = false
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(placeholder, color = Color.Gray) },
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(12.dp),
        visualTransformation = if (isPassword) PasswordVisualTransformation() else androidx.compose.ui.text.input.VisualTransformation.None,
        singleLine = true
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    LoginScreen(
        onNavigateToForgot = {}, 
        onNavigateToRegister = {}, 
        onLoginSuccess = {},
        onNavigateBack = {}
    )
}
