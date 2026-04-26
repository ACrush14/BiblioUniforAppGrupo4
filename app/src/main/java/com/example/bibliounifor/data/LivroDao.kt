package com.example.bibliounifor.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface LivroDao {
    // Insere um livro novo ou substitui se já existir
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserirLivro(livro: EntidadeLivro)

    // Busca um livro específico para a Tela 15 abrir
    @Query("SELECT * FROM books")
    fun buscarTodosLivros(): kotlinx.coroutines.flow.Flow<List<EntidadeLivro>>

    // Atualiza onde o usuário parou de ler (o scroll)
    @Update
    suspend fun atualizarProgresso(livro: EntidadeLivro)
}