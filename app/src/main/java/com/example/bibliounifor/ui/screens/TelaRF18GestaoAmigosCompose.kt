package com.example.bibliounifor.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bibliounifor.ui.theme.*

// Modelo de Dados do Usuário
data class User(
    val nome: String,
    val usuario: String,
    val email: String,
    val bio: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaGestaoAmigosScreen() {
    var searchQuery by remember { mutableStateOf("") }
    var selectedUser by remember { mutableStateOf<User?>(null) }

    // Mock de "Base de Dados" para os amigos
    val amigosMock = listOf(
        User("Marcos Antônio", "Marquinhoss302890", "marquinhos@gmail.com", "Ler é legal."),
        User("Ronaldo Alves", "ronaldo_alves", "ronaldo@email.com", "Amante de tecnologia."),
        User("Vitoria Ferreira", "vivi_ferreira", "vitoria@email.com", "Estudante de design."),
        User("Marta Viana", "marta_v", "marta@email.com", "Gosto de romances."),
        User("Adriano de Souza", "adriano_s", "adriano@email.com", "Fã de suspense.")
    )

    if (selectedUser != null) {
        // Exibe a tela de detalhes se um usuário estiver selecionado
        UserDetailScreen(user = selectedUser!!, onBack = { selectedUser = null })
    } else {
        // Exibe a lista de amigos
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Amigos", fontWeight = FontWeight.Bold, color = BiblioDark) },
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = BiblioCyan)
                )
            }
        ) { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(BiblioBg)
                    .padding(padding)
            ) {
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    placeholder = { Text("Procure um amigo") },
                    leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                    trailingIcon = { Icon(Icons.Default.Add, contentDescription = "Adicionar", tint = BiblioDark) },
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = BiblioCyan,
                        unfocusedBorderColor = Color.LightGray,
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White
                    )
                )

                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    val amigosFiltrados = amigosMock.filter { it.nome.contains(searchQuery, ignoreCase = true) }
                    items(amigosFiltrados.size) { index ->
                        val user = amigosFiltrados[index]
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { selectedUser = user } // Ao clicar, seleciona o usuário
                                .padding(vertical = 12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(48.dp)
                                    .clip(CircleShape)
                                    .background(Color.Gray)
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Text(
                                text = user.nome,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = BiblioDark,
                                modifier = Modifier.weight(1f)
                            )
                            IconButton(onClick = { }) {
                                Icon(Icons.Default.MoreVert, contentDescription = "Opções", tint = BiblioDark)
                            }
                        }
                        HorizontalDivider(color = Color.LightGray, thickness = 0.5.dp)
                    }
                }
            }
        }
    }
}

@Composable
fun UserDetailScreen(user: User, onBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Header de Perfil (Cor Cyan, foto, email)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .background(BiblioCyan)
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = { }) {
                    Icon(Icons.Default.Notifications, contentDescription = null, tint = Color.Black)
                }
                IconButton(onClick = { }) {
                    Icon(Icons.Default.Settings, contentDescription = null, tint = Color.Black)
                }
            }
            
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(90.dp)
                        .clip(CircleShape)
                        .background(Color.Gray)
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = user.email,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }
        }

        // Formulário de Detalhes
        Column(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()
        ) {
            DetailField(label = "Nome", value = user.nome)
            DetailField(label = "Usuário", value = user.usuario)
            DetailField(label = "Bio", value = user.bio, isLong = true)

            Spacer(modifier = Modifier.height(32.dp))

            // Botão Adicionar Amigo
            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(containerColor = BiblioCyan),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Adicionar Amigo", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Botão Excluir Amigo (Vermelho)
            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD32F2F)),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Excluir amigo", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }

            TextButton(
                onClick = onBack,
                modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 8.dp)
            ) {
                Text("Voltar", color = BiblioCyan, fontSize = 16.sp)
            }
        }
    }
}

@Composable
fun DetailField(label: String, value: String, isLong: Boolean = false) {
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Text(
            text = label, 
            fontWeight = FontWeight.Bold, 
            fontSize = 18.sp, 
            color = Color.Black,
            modifier = Modifier.padding(start = 4.dp)
        )
        Spacer(modifier = Modifier.height(6.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(if (isLong) 120.dp else 52.dp)
                .background(Color(0xFFF5F7F7), RoundedCornerShape(26.dp))
                .padding(horizontal = 20.dp, vertical = if (isLong) 16.dp else 0.dp),
            contentAlignment = if (isLong) Alignment.TopStart else Alignment.CenterStart
        ) {
            Text(text = value, color = Color.DarkGray, fontSize = 16.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTelaGestaoAmigosScreen() {
    TelaGestaoAmigosScreen()
}
