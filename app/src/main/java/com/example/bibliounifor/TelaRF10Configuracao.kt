package com.example.bibliounifor

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class TelaRF10Configuracao : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf10_configuracao)

        // Localizando os botões do layout
        val btnRedefinir = findViewById<MaterialButton>(R.id.btnRedefinirSenha)
        val btnVoltar = findViewById<MaterialButton>(R.id.btnVoltarTelaInicial)
        val btnApagar = findViewById<MaterialButton>(R.id.btnApagarConta)

        // Configurando a navegação: Configuração -> Redefinir Senha
        btnRedefinir.setOnClickListener {
            val intent = Intent(this, TelaRF11RedefinirSenha::class.java)
            startActivity(intent)
        }

        // Configurando o botão para voltar à tela anterior
        btnVoltar.setOnClickListener {
            finish()
        }

        // Botão para apagar conta (lógica pode ser adicionada depois)
        btnApagar.setOnClickListener {
            // Lógica de exclusão
        }
    }
}
