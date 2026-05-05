package com.example.bibliounifor.ui.screens

import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.bibliounifor.*
import com.example.bibliounifor.ui.theme.BiblioCyan
import com.example.bibliounifor.ui.theme.BiblioDark

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BiblioTopAppBar(title: String) {
    val context = LocalContext.current
    TopAppBar(
        title = { Text(title, fontWeight = FontWeight.Bold, color = BiblioDark) },
        navigationIcon = {
            IconButton(onClick = {
                val intent = Intent(context, TelaRF21Notificacoes::class.java)
                context.startActivity(intent)
            }) {
                Icon(Icons.Default.Notifications, contentDescription = "Notificações", tint = Color.Black)
            }
        },
        actions = {
            IconButton(onClick = {
                val intent = Intent(context, TelaRF10Configuracao::class.java)
                context.startActivity(intent)
            }) {
                Icon(Icons.Default.Settings, contentDescription = "Configurações", tint = Color.Black)
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = BiblioCyan)
    )
}

@Composable
fun BiblioBottomNavigation() {
    val context = LocalContext.current
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(65.dp),
        shadowElevation = 8.dp,
        color = Color.White
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // 1. Casa -> RF09
            NavItem(Icons.Default.Home, "Home", Modifier.weight(1f)) {
                context.startActivity(Intent(context, TelaRF09DashboardUsuario::class.java))
            }
            // 2. Tenda (Livraria) -> RF16
            NavItem(Icons.Default.ShoppingCart, "Livraria", Modifier.weight(1f)) {
                context.startActivity(Intent(context, TelaRF16MinhaLivrariaActivity::class.java))
            }
            // 3. Lupa -> RF12
            NavItem(Icons.Default.Search, "Pesquisa", Modifier.weight(1f)) {
                context.startActivity(Intent(context, TelaRF12TelaDePesquisa::class.java))
            }
            // 4. Coração -> RF17
            NavItem(Icons.Default.Favorite, "Desejos", Modifier.weight(1f)) {
                context.startActivity(Intent(context, TelaRF17ListaDesejosActivity::class.java))
            }
            // 5. Livro -> RF19 (Utilizando List como fallback visual para "Menu de Livros/Aluguel")
            NavItem(Icons.Default.List, "Aluguel", Modifier.weight(1f)) {
                context.startActivity(Intent(context, TelaRF19::class.java))
            }
            // 6. Pessoa -> RF18
            NavItem(Icons.Default.Person, "Amigos", Modifier.weight(1f)) {
                context.startActivity(Intent(context, TelaRF18::class.java))
            }
        }
    }
}

@Composable
private fun NavItem(icon: ImageVector, label: String, modifier: Modifier, onClick: () -> Unit) {
    IconButton(onClick = onClick, modifier = modifier) {
        Icon(icon, contentDescription = label, tint = Color.Gray)
    }
}
