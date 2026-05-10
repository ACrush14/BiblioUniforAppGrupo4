package com.example.bibliounifor

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class TelaRF18_2AdicionarAmigo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf18_2_adicionar_amigo)

        val btnProcurar = findViewById<MaterialButton>(R.id.btnProcurarAmigo)
        btnProcurar.setOnClickListener {
            val intent = Intent(this@TelaRF18_2AdicionarAmigo, TelaRF18BuscaAmigos::class.java)
            startActivity(intent)
        }

        findViewById<android.widget.ImageView>(R.id.btnFiltroAmigo).setOnClickListener {
            // Placeholder para filtro
        }
    }
}
