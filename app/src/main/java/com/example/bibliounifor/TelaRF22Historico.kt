package com.example.bibliounifor

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class TelaRF22Historico : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf22_historico)

        // Padronização da Navegação e Cabeçalho


        val buttonRemoverHistorico = findViewById<Button>(R.id.btnRemoverHIstorico)
        buttonRemoverHistorico?.setOnClickListener {
            // Lógica para remover item do histórico
        }
    }
}
