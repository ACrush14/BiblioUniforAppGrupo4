package com.example.bibliounifor.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.bibliounifor.ui.theme.BiblioCyan
import com.example.bibliounifor.ui.theme.BiblioDark

@Composable
fun BiblioBottomNav(
    currentRoute: String,
    onNavigate: (String) -> Unit
) {
    NavigationBar(
        containerColor = Color.White
    ) {
        val items = listOf(
            Triple("livraria", Icons.Default.Home, "Minha Livraria"),
            Triple("pesquisa", Icons.Default.Search, "Pesquisar Livros"),
            Triple("desejos", Icons.Default.Favorite, "Desejos"),
            Triple("alugados", Icons.AutoMirrored.Filled.List, "Alugados"),
            Triple("amigos", Icons.Default.AccountCircle, "Amigos")
        )

        items.forEach { (route, icon, label) ->
            NavigationBarItem(
                icon = { Icon(icon, contentDescription = label) },
                selected = currentRoute == route,
                onClick = {
                    if (currentRoute != route) onNavigate(route)
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = BiblioDark,
                    unselectedIconColor = Color.Gray,
                    indicatorColor = BiblioCyan
                )
            )
        }
    }
}