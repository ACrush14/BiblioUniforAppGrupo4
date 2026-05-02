package com.example.bibliounifor.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bibliounifor.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaGestaoAmigosScreen() {
    var searchQuery by remember { mutableStateOf("") }
    val amigosMock = listOf("Ronaldo Alves", "Robson Gonçalves", "Vitoria Ferreira", "Marta Viana", "Adriano de Souza")

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
                val amigosFiltrados = amigosMock.filter { it.contains(searchQuery, ignoreCase = true) }
                items(amigosFiltrados.size) { index ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
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
                            text = amigosFiltrados[index],
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
