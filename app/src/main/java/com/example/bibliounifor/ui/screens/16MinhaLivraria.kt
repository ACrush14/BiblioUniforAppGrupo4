package com.example.bibliounifor.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bibliounifor.ui.components.BiblioHeader
import com.example.bibliounifor.ui.components.BookCard
import com.example.bibliounifor.ui.theme.*

@Composable
fun TelaMinhaLivrariaScreen(
    onLivroClick: (Int) -> Unit = {},
    viewModel: XXLivrariaViewModel = viewModel()
) {
    val livros by viewModel.meusLivros.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        BiblioHeader(title = "Meus Livros", userEmail = "joaobobo@gmail.com")

        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {
            items(livros) { livro ->
                BookCard(
                    title = livro.title,
                    author = livro.author,
                    extraInfo = "18 dez. 2019",
                    statusText = "Status: Lido",
                    actionButtons = {
                        Button(
                            onClick = { onLivroClick(livro.id) },
                            colors = ButtonDefaults.buttonColors(containerColor = BiblioCyan)
                        ) {
                            Text("Ler", color = BiblioDark)
                        }
                    }
                )
            }
        }
    }
}
