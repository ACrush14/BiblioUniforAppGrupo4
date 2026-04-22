package com.example.bibliouniforapp_final

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
// Tela Intermediaria
class TelaIntermediaria : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_intermediaria)

        val botaoEstudante = findViewById<Button>(R.id.btnEstudante)

        botaoEstudante.setOnClickListener {
            val intent = Intent(this, LoginEstudante::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }
    }
}