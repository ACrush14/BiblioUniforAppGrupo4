package com.example.bibliounifor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class TelaRF08RedefinirSenha : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.telarf08_redefinicao_de_senha)

        val buttonVoltar = findViewById<Button>(R.id.btnVoltarTelaRedefinirSenha)
        val buttonRedefinir = findViewById<Button>(R.id.btnRedefinirSenha1)

        buttonVoltar.setOnClickListener {
            val intent = Intent(this, TelaRF07ValidacaoDeCodigo::class.java)
            startActivity(intent)
        }

        buttonRedefinir.setOnClickListener {
            val intent = Intent(this, TelaRF08ConfirmarRedefinirSenha::class.java)


        }
    }
}