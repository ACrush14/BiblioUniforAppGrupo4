package com.example.bibliounifor

import android.os.Bundle
import android.widget.Button // Importação do botão
import androidx.appcompat.app.AppCompatActivity

import android.content.Intent
import android.widget.ImageView

class TelaRF39InfoLivroADM : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf39_info_livro_adm)

        // 👇 BARRA ADM


        // 1. Encontrar o botão de voltar pelo ID do XML
        val botaoVoltar = findViewById<Button>(R.id.btnVoltar)

        // 2. Criar a ação de clique
        botaoVoltar.setOnClickListener {

            // 3. O comando mágico que fecha esta tela e volta pra anterior!
            finish()

        }
    }
}