package com.example.bibliounifor.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bibliounifor.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaLeituraScreen(
    livroId: Int = 1,
    onVoltarClick: () -> Unit = {},
    viewModel: XXLeituraViewModel = viewModel()
) {
    val livro by viewModel.livroAtual.collectAsState()
    val scrollState = rememberScrollState()
    var isModoFoco by remember { mutableStateOf(false) }

    LaunchedEffect(livroId) {
        viewModel.carregarLivro(livroId)
    }

    LaunchedEffect(livro) {
        livro?.let {
            if (scrollState.value != it.lastPosition && it.lastPosition > 0) {
                scrollState.scrollTo(it.lastPosition)
            }
        }
    }

    LaunchedEffect(scrollState.isScrollInProgress) {
        if (!scrollState.isScrollInProgress && scrollState.value > 0) {
            viewModel.salvarProgresso(scrollState.value)
        }
    }

    if (livro == null) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = androidx.compose.ui.Alignment.Center) {
            CircularProgressIndicator(color = BiblioCyan)
        }
        return
    }

    val progress = if (scrollState.maxValue > 0) {
        (scrollState.value.toFloat() / scrollState.maxValue.toFloat() * 100).toInt()
    } else 0

    Scaffold(
        topBar = {
            AnimatedVisibility(visible = !isModoFoco) {
                TopAppBar(
                    title = {
                        Column {
                            Text(livro!!.title, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = BiblioDark)
                            Text("${livro!!.author} • $progress% lido", fontSize = 12.sp, color = BiblioDark.copy(alpha = 0.7f))
                        }
                    },
                    navigationIcon = {
                        IconButton(onClick = onVoltarClick) {
                            Icon(Icons.Default.ArrowBack, contentDescription = "Voltar", tint = BiblioDark)
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = BiblioCyan)
                )
            }
        },
        bottomBar = {
            AnimatedVisibility(visible = !isModoFoco) {
                LinearProgressIndicator(
                    progress = { if (scrollState.maxValue > 0) scrollState.value.toFloat() / scrollState.maxValue else 0f },
                    modifier = Modifier.fillMaxWidth().height(6.dp),
                    color = BiblioDark,
                    trackColor = androidx.compose.ui.graphics.Color.LightGray,
                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(BiblioBg)
                .verticalScroll(scrollState)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null
                ) {
                    isModoFoco = !isModoFoco
                }
                .padding(24.dp)
        ) {
            Text(
                text = livro!!.content,
                fontSize = 18.sp,
                lineHeight = 28.sp,
                color = BiblioDark,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(150.dp))
            if (progress >= 99) {
                Text(
                    text = "Fim do Livro",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    color = BiblioCyan
                )
            }
        }
    }
}
