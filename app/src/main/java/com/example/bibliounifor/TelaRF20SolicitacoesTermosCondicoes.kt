package com.example.bibliounifor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class TelaRF20SolicitacoesTermosCondicoes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf20_solicitacoes_termos_condicoes)

        val buttonContinuar = findViewById<Button>(R.id.btnContinuarSolicitacoes)

        buttonContinuar.setOnClickListener {
            val intent = Intent(this, TelaRF20SolicitacoesVoltarBiblioteca::class.java)
            startActivity(intent)
        }

    }
}