package com.example.bibliouniforappgrupo4_v02

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TelaRF34LivrosCRUD : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 🔹 XML CORRETO
//        setContentView(R.layout.telarf34_livroscrud)

        // 🔹 Botões principais
        val btnCriarMidia = findViewById<Button>(R.id.btnCriarMidia)
        val btnVerificarMidia = findViewById<Button>(R.id.btnVerificarMidia)
        val btnGerenciarUsuario = findViewById<Button>(R.id.btnGerenciarUsuario)
        val btnPermissaoUsuario = findViewById<Button>(R.id.btnPermissaoUsuario)

        // 🔹 Botões perigosos
        val btnApagarUsuario = findViewById<Button>(R.id.btnApagarUsuario)
        val btnApagarMidia = findViewById<Button>(R.id.btnApagarMidia)

        // 🔹 RF34 → RF35 (Cadastro de livro)
        btnCriarMidia.setOnClickListener {
            val intent = Intent(this, TelaRF35CadastroDeLivros::class.java)
            startActivity(intent)
        }

        // 🔹 RF34 → RF31 (Gerenciar usuários)
        btnGerenciarUsuario.setOnClickListener {
            val intent = Intent(this, TelaRF31GerenciamentoDeUsuarios::class.java)
            startActivity(intent)
        }

        // 🔹 Ações simuladas
        btnVerificarMidia.setOnClickListener {
            Toast.makeText(this, "Verificando mídias...", Toast.LENGTH_SHORT).show()
        }

        btnPermissaoUsuario.setOnClickListener {
            Toast.makeText(this, "Alterando permissões...", Toast.LENGTH_SHORT).show()
        }

        btnApagarUsuario.setOnClickListener {
            Toast.makeText(this, "Usuário apagado (simulação)", Toast.LENGTH_SHORT).show()
        }

        btnApagarMidia.setOnClickListener {
            Toast.makeText(this, "Mídia apagada (simulação)", Toast.LENGTH_SHORT).show()
        }
    }
}