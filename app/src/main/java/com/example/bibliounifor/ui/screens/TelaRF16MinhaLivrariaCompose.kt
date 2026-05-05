package com.example.bibliounifor.ui.screens

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bibliounifor.R
import com.example.bibliounifor.RF14TelaVerMaisLivro
import com.example.bibliounifor.data.EntidadeLivro
import com.example.bibliounifor.ui.components.BiblioBottomNav
import com.example.bibliounifor.ui.components.BookCard
import com.example.bibliounifor.ui.theme.*

@Composable
fun TelaMinhaLivrariaScreen(
    onLivroClick: (Int) -> Unit = {},
    onNavigate: (String) -> Unit = {},
    viewModel: XXLivrariaViewModel = viewModel()
) {
    val livros by viewModel.meusLivros.collectAsState()

    TelaMinhaLivrariaContent(
        livros = livros,
        onLivroClick = onLivroClick,
        onNavigate = onNavigate
    )
}

@Composable
fun TelaMinhaLivrariaContent(
    livros: List<EntidadeLivro>,
    onLivroClick: (Int) -> Unit,
    onNavigate: (String) -> Unit = {}
) {
    var showFilterMenu by remember { mutableStateOf(false) }
    val context = LocalContext.current

    Scaffold(
        bottomBar = {
            BiblioBottomNav(currentRoute = "livraria", onNavigate = onNavigate)
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF5F5F5))
                .padding(padding)
        ) {
            // Header Section conforme a imagem
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp)
                    .background(BiblioCyan)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.Start
                    ) {
                        IconButton(onClick = { }) {
                            Icon(
                                Icons.Default.Notifications,
                                contentDescription = "Notificações",
                                tint = BiblioDark,
                                modifier = Modifier.size(32.dp)
                            )
                        }
                    }

                    // Profile Image
                    Box(
                        modifier = Modifier
                            .size(90.dp)
                            .clip(CircleShape)
                            .background(Color.Gray)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_launcher_background),
                            contentDescription = "Foto de Perfil",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "joaobobo@gmail.com",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White
                    )
                }
            }

            // Título "Meus Livros" e o Filtro (Setinha)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Meus Livros",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = BiblioDark
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    // Ícone de livros (Usando Emoji para compatibilidade garantida)
                    Text("📚", fontSize = 28.sp)
                }

                Box {
                    IconButton(onClick = { showFilterMenu = true }) {
                        Icon(
                            Icons.Default.KeyboardArrowDown,
                            contentDescription = "Filtro",
                            modifier = Modifier.size(36.dp),
                            tint = BiblioDark
                        )
                    }

                    DropdownMenu(
                        expanded = showFilterMenu,
                        onDismissRequest = { showFilterMenu = false },
                        modifier = Modifier.background(Color.White).padding(8.dp)
                    ) {
                        listOf("Lido", "Lendo", "Não Lido").forEach { status ->
                            DropdownMenuItem(
                                text = {
                                    Surface(
                                        modifier = Modifier.fillMaxWidth().height(40.dp),
                                        shape = RoundedCornerShape(20.dp),
                                        color = BiblioCyan
                                    ) {
                                        Box(contentAlignment = Alignment.Center) {
                                            Text(
                                                text = status,
                                                color = BiblioDark,
                                                fontWeight = FontWeight.Medium,
                                                textAlign = TextAlign.Center,
                                                modifier = Modifier.padding(horizontal = 24.dp)
                                            )
                                        }
                                    }
                                },
                                onClick = { showFilterMenu = false }
                            )
                        }
                    }
                }
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(livros) { livro ->
                    var showBookOptions by remember { mutableStateOf(false) }

                    BookCard(
                        title = livro.title,
                        author = livro.author,
                        extraInfo = "18 dez. 2019",
                        statusText = "Status: Lido",
                        imageColor = BiblioCyan,
                        onOptionsClick = { showBookOptions = true },
                        actionButtons = {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.End,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                // Label "Alugado" (exemplo estático baseado na imagem)
                                if (livro.id % 2 != 0) {
                                    Text(
                                        "Alugado",
                                        modifier = Modifier.padding(end = 16.dp),
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = BiblioDark
                                    )
                                }

                                Button(
                                    onClick = { /* Lógica de remover */ },
                                    colors = ButtonDefaults.buttonColors(containerColor = BiblioRed),
                                    shape = RoundedCornerShape(4.dp),
                                    modifier = Modifier.height(36.dp)
                                ) {
                                    Text("Remover", color = Color.White, fontSize = 12.sp)
                                }
                            }

                            // Menu para "Ver mais" disparado pelos 3 pontos
                            DropdownMenu(
                                expanded = showBookOptions,
                                onDismissRequest = { showBookOptions = false },
                                modifier = Modifier.background(Color.White).padding(8.dp)
                            ) {
                                DropdownMenuItem(
                                    text = {
                                        Surface(
                                            modifier = Modifier.fillMaxWidth().height(40.dp),
                                            shape = RoundedCornerShape(20.dp),
                                            color = BiblioCyan
                                        ) {
                                            Box(contentAlignment = Alignment.Center) {
                                                Text(
                                                    text = "Ver mais",
                                                    color = BiblioDark,
                                                    fontWeight = FontWeight.Medium,
                                                    textAlign = TextAlign.Center,
                                                    modifier = Modifier.padding(horizontal = 24.dp)
                                                )
                                            }
                                        }
                                    },
                                    onClick = {
                                        showBookOptions = false
                                        // Conexão com a Activity RF14 conforme pedido
                                        val intent = Intent(context, RF14TelaVerMaisLivro::class.java)
                                        context.startActivity(intent)
                                    }
                                )
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
fun PreviewTelaMinhaLivrariaScreen() {
    val sampleLivros = listOf(
        EntidadeLivro(id = 1, title = "O Alienista", author = "Machado de Assis", content = ""),
        EntidadeLivro(id = 2, title = "A Sociedade do Anel", author = "J. R. R. Tolkien", content = ""),
        EntidadeLivro(id = 3, title = "A Culpa é das estrelas", author = "John Green", content = "")
    )
    TelaMinhaLivrariaContent(
        livros = sampleLivros,
        onLivroClick = {}
    )
}
