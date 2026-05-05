package com.example.bibliounifor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class TelaRF20SolicitacoesVoltarBiblioteca : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf20_solicitacoes_voltar_biblioteca)

        val buttonVoltarBiblioteca = findViewById<Button>(R.id.btnVoltarBiblioteca)

        buttonVoltarBiblioteca.setOnClickListener {
            val intent = Intent(this@TelaRF20SolicitacoesVoltarBiblioteca, TelaRF13TelaDoLivro::class.java)
            startActivity(intent)
        }


    }
}
