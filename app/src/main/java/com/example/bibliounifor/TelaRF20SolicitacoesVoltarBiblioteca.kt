package com.example.bibliounifor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.teste.TelaRF13Livro

class TelaRF20SolicitacoesVoltarBiblioteca : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf20_solicitacoes_voltar_biblioteca)

        val buttonVoltarBiblioteca = findViewById<Button>(R.id.btnVoltarBiblioteca)

        buttonVoltarBiblioteca.setOnClickListener {
            val intent = Intent(this, TelaRF13Livro::class.java)
            startActivity(intent)
        }


    }
}