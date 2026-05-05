package com.example.bibliounifor

import android.content.Intent // Importante para fazer a navegação
import android.os.Bundle
import android.widget.Button // Importante para reconhecer o botão
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TelaRF38ListaAlugueisADM : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.telarf38_lista_alugueis_adm)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 1. Encontrar o botão pelo ID que está no XML
        val botaoVerLivro1 = findViewById<Button>(R.id.btnVerLivro1)

        // 2. Criar a ação de clique
        botaoVerLivro1.setOnClickListener {
            // 3. Fazer a ponte (Intent) para a Tela 39
            val intent = Intent(this, TelaRF39InfoLivroADM::class.java)
            startActivity(intent)
        }
    }
}