package com.example.bibliounifor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.content.Intent

import android.widget.ImageView

class TelaRF30DashboardADM : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.telarf30_dashboard_adm)

        val btnTelaCRUD = findViewById<Button>(R.id.btnTelaCRUD)
        val btnVerSolicitacoes = findViewById<Button>(R.id.btnVerSolicitacoes)

        btnTelaCRUD.setOnClickListener {
            // Alterado para ir para a TelaRF34LivrosCRUD conforme solicitado
            val intent = Intent(this, TelaRF34LivrosCRUD::class.java)
            startActivity(intent)
        }

        btnVerSolicitacoes.setOnClickListener {
            val intent = Intent(this, TelaRF33VerificarMidia::class.java)
            startActivity(intent)
        }

        // 👇 BARRA ADM
        NavigationUtils.setupAdminNavigation(this)
    }
}
