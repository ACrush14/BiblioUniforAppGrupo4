package com.example.bibliounifor.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.bibliounifor.ui.theme.BiblioBg

@Composable
fun TelaMinhaLivrariaScreen() {
    Scaffold(
        topBar = { BiblioTopAppBar(title = "Minha Livraria") },
        bottomBar = { BiblioBottomNavigation() }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(BiblioBg)
                .padding(padding)
        ) {
            // Conteúdo da Livraria aqui
            Text("Bem-vindo à sua livraria!")
        }
    }
}
