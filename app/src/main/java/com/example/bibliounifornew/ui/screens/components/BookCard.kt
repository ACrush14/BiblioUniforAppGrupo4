package com.example.bibliounifor.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Reutilizando sua paleta
val BiblioCyan = Color(0xFF87DEDE)
val BiblioDark = Color(0xFF1B3434)
val BiblioCardBg = Color(0xFFFFFFFF)
val BiblioRed = Color(0xFFD9534F) // Para botões de remover ou status atrasado

@Composable
fun BookCard(
    title: String,
    author: String,
    extraInfo: String, // Ex: "18 dez. 2019" ou "Validade: 10 de ago"
    statusText: String? = null, // Ex: "Status: Lido"
    statusColor: Color = BiblioDark,
    imageColor: Color = Color.LightGray, // Placeholder até termos as imagens reais
    onOptionsClick: (() -> Unit)? = null, // Menu de 3 pontinhos
    actionButtons: @Composable () -> Unit = {} // Aqui entra a mágica do Slot API
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = BiblioCardBg)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Placeholder da Capa do Livro
            Box(
                modifier = Modifier
                    .width(70.dp)
                    .height(105.dp)
                    .background(imageColor, RoundedCornerShape(4.dp))
            )

            Spacer(modifier = Modifier.width(16.dp))

            // Textos e Ações
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = title,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = BiblioDark,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = "por $author",
                            fontSize = 12.sp,
                            color = BiblioDark.copy(alpha = 0.7f),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = extraInfo,
                            fontSize = 12.sp,
                            color = BiblioDark.copy(alpha = 0.5f)
                        )
                    }

                    if (onOptionsClick != null) {
                        IconButton(
                            onClick = onOptionsClick,
                            modifier = Modifier.size(24.dp)
                        ) {
                            Icon(Icons.Default.MoreVert, contentDescription = "Opções", tint = BiblioDark)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Linha inferior: Status na esquerda, Botões na direita
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom
                ) {
                    if (statusText != null) {
                        Text(
                            text = statusText,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = statusColor
                        )
                    } else {
                        Spacer(modifier = Modifier.weight(1f))
                    }

                    // A injeção dos botões vai acontecer aqui
                    Column(
                        horizontalAlignment = Alignment.End,
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        actionButtons()
                    }
                }
            }
        }
    }
}