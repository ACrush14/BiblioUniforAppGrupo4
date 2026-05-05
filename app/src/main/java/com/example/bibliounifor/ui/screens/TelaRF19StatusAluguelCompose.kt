package com.example.bibliounifor.ui.screens

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bibliounifor.TelaRF23RenovacaoOnline
import com.example.bibliounifor.ui.components.BookCard
import com.example.bibliounifor.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaLivrosAlugadosScreen() {
    val context = LocalContext.current
    val livrosAlugados = listOf(1) // Mock para exibição

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Livros Alugados", fontWeight = FontWeight.Bold, color = BiblioDark) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = BiblioCyan)
            )
        }
    ) { padding ->
        Box(modifier = Modifier.fillMaxSize().background(BiblioBg).padding(padding)) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp)
            ) {
                items(livrosAlugados.size) { index ->
                    BookCard(
                        title = "O Senhor dos Anéis",
                        author = "J.R.R. Tolkien",
                        extraInfo = "Validade: 10 de agosto de 2026\nDias para o Vencimento: 5 dias",
                        statusColor = BiblioRed,
                        actionButtons = {
                            Button(
                                onClick = { 
                                    // Agora navega para a Activity de Renovação Online (XML)
                                    val intent = Intent(context, TelaRF23RenovacaoOnline::class.java)
                                    context.startActivity(intent)
                                },
                                colors = ButtonDefaults.buttonColors(containerColor = BiblioCyan),
                                shape = RoundedCornerShape(12.dp),
                                modifier = Modifier.height(44.dp).fillMaxWidth(0.6f)
                            ) {
                                Text("Renovar", fontSize = 16.sp, color = BiblioDark)
                            }
                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTelaLivrosAlugadosScreen() {
    TelaLivrosAlugadosScreen()
}
