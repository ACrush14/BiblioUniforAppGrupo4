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


data class RegisterFormState (
    val nome: String = "",
    val usuario: String = "",
    val email: String = "",
    val senha: String = "",
    val confirmacao: String = "",
)


@Composable
fun RegisterScreen(onNavigateBack: () -> Unit, onNavigateToLogin: () -> Unit) {

    var formState by remember {mutableStateOf(RegisterFormState()) }
    var emailError by remember { mutableStateOf(false) }

    val emailsNoBanco = listOf("admin@unifor.br", "anderson@unifor.br")

Column(
    modifier = Modifier
        .fillMaxSize()
        .padding(24.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
) {
    Text (
        text = "Seja bem vindo ao \n BiblioUnifor!",
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(bottom = 8.dp)
    )

    Text(
        text = "Vamos fazer sua conta",
        fontSize = 16.sp,
        color = Color.DarkGray,
        modifier = Modifier.padding(bottom = 24.dp)
    )

    CustomTextField(
        value = formState.nome,
        onValueChange = { formState = formState.copy(nome = it) },
        placeholder = "Digite seu nome completo")


    CustomTextField(
        value = formState.usuario,
        onValueChange = { formState = formState.copy(usuario = it) },
        placeholder = "Digite seu nome de usuário")
    if (emailError) {
        Text(
            text = "Email já cadastrado ou inválido",
            color = Color.Red,
            fontSize = 12.sp,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 16.dp, bottom = 4.dp)
        )
    }

    CustomTextField (
        value = formState.email,
        onValueChange = { formState = formState.copy(email = it) },
        placeholder = "Digite seu e-mail",
        isError = emailError
    )

    CustomTextField (
        value = formState.senha,
        onValueChange = { formState = formState.copy(senha = it) },
        placeholder = "Digite sua senha",
        isPassword = true
    )

    CustomTextField (
        value = formState.confirmacao,
        onValueChange = { formState = formState.copy(confirmacao = it) },
        placeholder = "Confirme sua senha",
        isPassword = true
    )

    Column(modifier = Modifier.fillMaxWidth().padding(start = 16.dp, top = 8.dp, bottom = 24.dp)) {
        Text("A senha deve conter pelo menos 8 caracteres", color = Color.Red, fontSize = 12.sp)
        Text(" Um número", color = Color.Red, fontSize = 12.sp)
        Text(" Uma letra Maiuscula", color = Color.Red, fontSize = 12.sp)
    }

    PrimaryButton(text = "Cadastrar", onClick = {
        if (formState.email in emailsNoBanco) {
            emailError = true
        } else {
            emailError = false
            onNavigateToLogin()
        }
    })

    Row(
        modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("Já tem uma conta?")
        TextButton(
            onClick = onNavigateToLogin,
            contentPadding = PaddingValues(0.dp)
        ) {
            Text("Entre Aqui", color = Color(0xFF4DB6AC))
        }

        }
    }
}
