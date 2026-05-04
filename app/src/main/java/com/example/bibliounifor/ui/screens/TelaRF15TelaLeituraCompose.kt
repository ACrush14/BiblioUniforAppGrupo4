package com.example.bibliounifor.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bibliounifor.R
import com.example.bibliounifor.data.EntidadeLivro
import com.example.bibliounifor.ui.theme.*

@Composable
fun TelaLeituraScreen(
    livroId: Int = 1,
    onBack: () -> Unit = {},
    onNavigate: (String) -> Unit = {},
    viewModel: XXLeituraViewModel = viewModel()
) {
    val livro by viewModel.livroAtual.collectAsState()

    LaunchedEffect(livroId) {
        viewModel.carregarLivro(livroId)
    }

    TelaLeituraContent(
        livro = livro,
        onBack = onBack,
        onNavigate = onNavigate
    )
}

@Composable
fun TelaLeituraContent(
    livro: EntidadeLivro?,
    onBack: () -> Unit = {},
    onNavigate: (String) -> Unit = {}
) {
    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor = Color.White,
                modifier = Modifier.height(70.dp),
                contentPadding = PaddingValues(0.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { }) { Icon(Icons.Default.Home, contentDescription = null, modifier = Modifier.size(28.dp)) }
                    IconButton(onClick = { }) { Icon(Icons.Default.ShoppingCart, contentDescription = null, modifier = Modifier.size(28.dp)) }
                    IconButton(onClick = { }) { Icon(Icons.Default.Search, contentDescription = null, modifier = Modifier.size(28.dp)) }
                    IconButton(onClick = { }) { Icon(Icons.Default.FavoriteBorder, contentDescription = null, modifier = Modifier.size(28.dp)) }
                    IconButton(onClick = { }) { Icon(Icons.AutoMirrored.Filled.List, contentDescription = null, modifier = Modifier.size(28.dp)) }
                    IconButton(onClick = { }) { Icon(Icons.Default.Person, contentDescription = null, modifier = Modifier.size(28.dp)) }
                    IconButton(onClick = { }) { Icon(Icons.Default.Settings, contentDescription = null, modifier = Modifier.size(28.dp)) }
                }
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(padding)
                .verticalScroll(rememberScrollState())
        ) {
            // Header Section
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(BiblioCyan)
                    .padding(16.dp)
            ) {
                Column {
                    // Botão Voltar
                    IconButton(
                        onClick = onBack,
                        modifier = Modifier.padding(bottom = 8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar",
                            tint = Color.White,
                            modifier = Modifier.size(32.dp)
                        )
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Book Cover
                        Card(
                            shape = RoundedCornerShape(4.dp),
                            elevation = CardDefaults.cardElevation(4.dp),
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
                            Text(
                                text = livro?.title ?: "O Alienista",
                                fontSize = 26.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Text(
                                text = livro?.author ?: "Machado de Assis",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color.White
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "Ficção Psicológica",
                                fontSize = 16.sp,
                                color = Color.White.copy(alpha = 0.9f)
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Options Section
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    BookActionButton(text = "Alugar", modifier = Modifier.weight(1f))
                    Spacer(modifier = Modifier.width(16.dp))
                    BookActionButton(text = "Comprar", modifier = Modifier.weight(1f))
                }

                BookActionButton(text = "Procurar", modifier = Modifier.fillMaxWidth())
                BookActionButton(text = "Abrir PDF", modifier = Modifier.fillMaxWidth())
                BookActionButton(text = "Abrir Audiobook", modifier = Modifier.fillMaxWidth())
                BookActionButton(text = "Reservar", modifier = Modifier.fillMaxWidth())
                BookActionButton(text = "Setor Localizado", modifier = Modifier.fillMaxWidth())
                
                Spacer(modifier = Modifier.height(20.dp))
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
        modifier = modifier.height(52.dp),
        shape = RoundedCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = BiblioCyan,
            contentColor = Color.White
        )
    ) {
        Text(
            text = text,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTelaLeituraScreen() {
    val sampleLivro = EntidadeLivro(
        id = 1,
        title = "O Alienista",
        author = "Machado de Assis",
        content = "",
        lastPosition = 0
    )
    TelaLeituraContent(livro = sampleLivro)
}
