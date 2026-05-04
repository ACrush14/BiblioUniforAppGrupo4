package com.example.bibliounifor

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class TelaRF37ConfirmarCadastroADM : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf37_confirmar_cadastro_adm)

        // 1. Encontrar o ícone da esquerda pelo ID que criamos no XML
        val iconeDashboard = findViewById<ImageView>(R.id.iconDashboard)

        // 2. Criar a ação de clique no ícone
        iconeDashboard.setOnClickListener {

            // 3. Fazer a ponte (Intent) para a Tela 30 (Dashboard)
            val intent = Intent(this, TelaRF30DashboardADM::class.java)
            startActivity(intent)

        }
    }
}