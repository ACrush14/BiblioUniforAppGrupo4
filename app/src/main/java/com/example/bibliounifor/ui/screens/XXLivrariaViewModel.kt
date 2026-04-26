package com.example.bibliounifor.ui.screens

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.bibliounifor.data.AppDatabase
import com.example.bibliounifor.data.EntidadeLivro
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class XXLivrariaViewModel(application: Application) : AndroidViewModel(application) {

    private val dao = AppDatabase.getDatabase(application).livroDao()

    val meusLivros: StateFlow<List<EntidadeLivro>> = dao.buscarTodosLivros()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun removerLivro(livro: EntidadeLivro) {
        viewModelScope.launch {
            // Lógica de remoção se necessário
        }
    }
}
