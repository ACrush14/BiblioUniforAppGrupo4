package com.example.bibliounifor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class TelaRF20Solicitacoes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf20_solicitacoes)

        // 1. Localizar os botões pelos IDs do XML
        val btnPdf = findViewById<Button>(R.id.btnSolicitarPdf)
        val btnBraile = findViewById<Button>(R.id.btnSolicitarBraile)
        val btnAudio = findViewById<Button>(R.id.btnSolicitarAudiobook)
        val btnReservar = findViewById<Button>(R.id.btnReservar)

        // 2. Configurar apenas o botão PDF para levar aos Termos e Condições
        btnPdf.setOnClickListener {
            val intent = Intent(this, TelaRF20SolicitacoesTermosCondicoes::class.java)
            startActivity(intent)
        }

        // 3. Os outros botões ficam sem ação definida por enquanto
        btnBraile.setOnClickListener { /* Sem ação */ }
        btnAudio.setOnClickListener { /* Sem ação */ }
        btnReservar.setOnClickListener { /* Sem ação */ }
    }
}
