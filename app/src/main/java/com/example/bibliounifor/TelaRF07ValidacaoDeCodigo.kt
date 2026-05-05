package com.example.bibliounifor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class TelaRF07ValidacaoDeCodigo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.telarf07_validacao_de_codigo)

        val buttonVoltar = findViewById<Button>(R.id.btnVoltarTelaValidacaoCodigo)
        val buttonEnviarCodigo = findViewById<Button>(R.id.btnEnviarCodigo)

        buttonVoltar.setOnClickListener {
            val intent = Intent(this, TelaRF06RecuperacaoSenha::class.java)
            startActivity(intent)
        }

        buttonEnviarCodigo.setOnClickListener {
            val intent = Intent(this, TelaRF08RedefinirSenha::class.java)
            startActivity(intent)
        }
    }
}