package com.example.bibliounifor.ui.screens

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.bibliounifor.data.AppDatabase
import com.example.bibliounifor.data.EntidadeLivro
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class XXLeituraViewModel(application: Application) : AndroidViewModel(application) {

    private val dao = AppDatabase.getDatabase(application).livroDao()

    private val _livroAtual = MutableStateFlow<EntidadeLivro?>(null)
    val livroAtual: StateFlow<EntidadeLivro?> = _livroAtual

    fun carregarLivro(livroId: Int) {
        viewModelScope.launch {
            var livro = dao.buscarLivroPorId(livroId)
            if (livro == null) {
                livro = EntidadeLivro(
                    id = livroId,
                    title = "O Alienista",
                    author = "Machado de Assis",
                    content = "Capítulo 1\n\nAs crônicas da vila de Itaguaí dizem que em tempos remotos vivera ali um certo médico, o Dr. Simão Bacamarte, filho da nobreza da terra e o maior dos médicos do Brasil, de Portugal e das Espanhas...",
                    lastPosition = 0
                )
                dao.inserirLivro(livro)
            }
            _livroAtual.value = livro
        }
    }

    fun salvarProgresso(posicaoScroll: Int) {
        val livro = _livroAtual.value ?: return
        if (livro.lastPosition != posicaoScroll) {
            viewModelScope.launch {
                val livroAtualizado = livro.copy(lastPosition = posicaoScroll)
                dao.atualizarProgresso(livroAtualizado)
                _livroAtual.value = livroAtualizado
            }
        }
    }
}
