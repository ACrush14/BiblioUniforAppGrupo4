package com.example.bibliounifor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class TelaRF20Solicitacoes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf20_solicitacoes)

        val buttonSolicitarPDF = findViewById<Button>(R.id.btnSolicitarPdf)
        val buttonSolicitarBraile = findViewById<Button>(R.id.btnSolicitarBraile)
        val buttonSolicitarAudiobook = findViewById<Button>(R.id.btnSolicitarAudiobook)
        val buttonReservar = findViewById<Button>(R.id.btnReservar)

        buttonSolicitarPDF.setOnClickListener {
            val intent = Intent(this, TelaRF20SolicitacoesTermosCondicoes::class.java)
            startActivity(intent)
        }

        buttonSolicitarBraile.setOnClickListener {
            val intent = Intent(this, TelaRF20SolicitacoesTermosCondicoes::class.java)
            startActivity(intent)
        }

        buttonSolicitarAudiobook.setOnClickListener {
            val intent = Intent(this, TelaRF20SolicitacoesTermosCondicoes::class.java)
            startActivity(intent)
        }

        buttonReservar.setOnClickListener {
            val intent = Intent(this, TelaRF20SolicitacoesTermosCondicoes::class.java)
            startActivity(intent)
        }

    }
}