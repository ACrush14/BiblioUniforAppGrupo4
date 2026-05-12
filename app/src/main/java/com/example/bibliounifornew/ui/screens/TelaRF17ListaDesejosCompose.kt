package com.example.bibliounifor.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bibliounifor.ui.components.BookCard
import com.example.bibliounifor.ui.theme.*

@Composable
fun TelaListaDesejosScreen(
    onSuaLivrariaClick: (Int) -> Unit = {},
    onAlugarClick: (Int) -> Unit = {}
) {
    val livrosDesejados = listOf(1, 2)

    Scaffold(
        topBar = { BiblioTopAppBar(title = "Lista de Desejos") },
        bottomBar = { BiblioBottomNavigation() }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(BiblioBg)
                .padding(padding)
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
                contentPadding = PaddingValues(vertical = 16.dp)
            ) {
                items(livrosDesejados) { id ->
                    val isFirst = id == 1
                    // Nota: Assumindo que o componente BookCard ainda existe e é compatível
                    // Se houver erro de compilação, o ideal seria padronizar o BookCard também.
                    BookCard(
                        title = if (isFirst) "Vidas Secas" else "O Ceifador",
                        author = if (isFirst) "Graciliano Ramos" else "Neal Shusterman",
                        extraInfo = if (isFirst) "18 dez. 2019" else "23 mar. 2018",
                        onOptionsClick = { },
                        actionButtons = {
                            Button(
                                onClick = { onSuaLivrariaClick(id) },
                                colors = ButtonDefaults.buttonColors(containerColor = BiblioCyan),
                                shape = RoundedCornerShape(8.dp),
                                modifier = Modifier.height(36.dp)
                            ) {
                                Text("Sua Livraria", fontSize = 12.sp, color = BiblioDark)
                            }
                            Button(
                                onClick = { onAlugarClick(id) },
                                colors = ButtonDefaults.buttonColors(containerColor = BiblioCyan),
                                shape = RoundedCornerShape(8.dp),
                                modifier = Modifier.height(36.dp)
                            ) {
                                Text("Alugar", fontSize = 12.sp, color = BiblioDark)
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
fun PreviewTelaListaDesejosScreen() {
    TelaListaDesejosScreen()
}
