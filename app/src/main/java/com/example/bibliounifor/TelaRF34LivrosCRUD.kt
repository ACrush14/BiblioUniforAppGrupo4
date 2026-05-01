package com.example.bibliounifor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TelaRF34LivrosCRUD : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf34_livroscrud)

        // 👇 BOTÕES
        val btnCriar = findViewById<Button>(R.id.btnCriarMidia)
        val btnVerificar = findViewById<Button>(R.id.btnVerificarMidia)
        val btnGerenciar = findViewById<Button>(R.id.btnGerenciarUsuario)
        val btnPermissao = findViewById<Button>(R.id.btnPermissaoUsuario)
        val btnApagarUsuario = findViewById<Button>(R.id.btnApagarUsuario)
        val btnApagarMidia = findViewById<Button>(R.id.btnApagarMidia)

        // Ir para RF35
        btnCriar.setOnClickListener {
            val intent = Intent(this, TelaRF35CadastroDeLivros::class.java)
            startActivity(intent)
        }

        // Ações simples (simulação)
        btnVerificar.setOnClickListener {
            Toast.makeText(this, "Verificar mídia", Toast.LENGTH_SHORT).show()
        }

        btnGerenciar.setOnClickListener {
            Toast.makeText(this, "Gerenciar usuário", Toast.LENGTH_SHORT).show()
        }

        btnPermissao.setOnClickListener {
            Toast.makeText(this, "Alterar permissão", Toast.LENGTH_SHORT).show()
        }

        btnApagarUsuario.setOnClickListener {
            Toast.makeText(this, "Usuário apagado", Toast.LENGTH_SHORT).show()
        }

        btnApagarMidia.setOnClickListener {
            Toast.makeText(this, "Mídia apagada", Toast.LENGTH_SHORT).show()
        }

        // 👇 BARRA ADM
        val navUsuarios = findViewById<ImageView>(R.id.navUsuarios)
        val navSolicitacoes = findViewById<ImageView>(R.id.navSolicitacoes)
        val navLivros = findViewById<ImageView>(R.id.navLivrosADM)

        // Ir para RF31
        navUsuarios.setOnClickListener {
            val intent = Intent(this, TelaRF31GerenciamentoDeUsuarios::class.java)
            startActivity(intent)
        }

        // Ir para RF33
        navSolicitacoes.setOnClickListener {
            val intent = Intent(this, TelaRF33Solicitacoes::class.java)
            startActivity(intent)
        }

        // Já está na tela de livros
        navLivros.setOnClickListener {
            // não faz nada
        }
    }
}