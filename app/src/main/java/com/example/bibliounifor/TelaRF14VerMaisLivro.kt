package com.example.bibliounifor

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class RF14TelaVerMaisLivro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.telarf14_telavermaislivro)

        // Configura o botão voltar (ID: materialButton22 no XML)
        findViewById<Button>(R.id.materialButton22).setOnClickListener {
            finish() // Fecha esta tela e volta para a anterior (RF13)
        }
    }
}
