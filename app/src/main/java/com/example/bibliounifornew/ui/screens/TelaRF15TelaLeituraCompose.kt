package com.example.bibliounifor.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bibliounifor.R
import com.example.bibliounifor.data.EntidadeLivro
import com.example.bibliounifor.ui.theme.*

@Composable
fun BookActionButton(text: String, modifier: Modifier = Modifier, onClick: () -> Unit = {}) {
    Button(
        onClick = onClick,
        modifier = modifier.height(55.dp),
        colors = ButtonDefaults.buttonColors(containerColor = BiblioCyan),
        shape = RoundedCornerShape(12.dp)
    ) {
        Text(text, fontSize = 18.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun TelaLeituraScreen(
    livroId: Int = 1,
    onBack: () -> Unit = {},
    viewModel: XXLeituraViewModel = viewModel()
) {
    val livro by viewModel.livroAtual.collectAsState()

    LaunchedEffect(livroId) {
        viewModel.carregarLivro(livroId)
    }

    Scaffold(
        topBar = { BiblioTopAppBar(title = "Leitura") },
        bottomBar = { BiblioBottomNavigation() }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(padding)
                .verticalScroll(rememberScrollState())
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(BiblioCyan)
                    .padding(16.dp)
            ) {
                Column {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, "Voltar", tint = Color.White)
                    }

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Card(
                            shape = RoundedCornerShape(4.dp),
                            modifier = Modifier.size(width = 110.dp, height = 160.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.o_alienista_capa),
                                contentDescription = "Capa",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        Column {
                            Text(livro?.title ?: "O Alienista", fontSize = 22.sp, fontWeight = FontWeight.Bold, color = Color.White)
                            Text(livro?.author ?: "Machado de Assis", fontSize = 18.sp, color = Color.White)
                        }
                    }
                }
            }
            
            Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                BookActionButton(text = "Abrir PDF", modifier = Modifier.fillMaxWidth())
                BookActionButton(text = "Abrir Audiobook", modifier = Modifier.fillMaxWidth())
                BookActionButton(text = "Reservar", modifier = Modifier.fillMaxWidth())
            }
        }
    }
}

@Composable
fun BookActionButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Button(
        onClick = onClick,
        modifier = modifier.height(48.dp),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = BiblioCyan,
            contentColor = BiblioDark
        )
    ) {
        Text(text = text, fontSize = 16.sp, fontWeight = FontWeight.Bold)
    }
}
