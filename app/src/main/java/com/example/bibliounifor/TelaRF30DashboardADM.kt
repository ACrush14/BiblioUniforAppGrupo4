package com.example.bibliounifor

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class TelaRF30DashboardADM : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf30_dashboard_adm)

        // Padronização da Navegação ADM (Barra inferior e topo)
        NavigationUtils.setupAdminNavigation(this)

        // Referência aos botões do Dashboard
        val btnTelaCrud = findViewById<MaterialButton>(R.id.btnTelaCrud)
        val btnVerAlugueis = findViewById<MaterialButton>(R.id.btnVerAlugueis)
        val btnVerTodosAtrasos = findViewById<MaterialButton>(R.id.btnVerTodosAtrasos)

        // Navegação
        btnTelaCrud?.setOnClickListener {
            startActivity(Intent(this, TelaRF30CRUD::class.java))
        }

        btnVerAlugueis?.setOnClickListener {
            startActivity(Intent(this, TelaRF38ListaAlugueisADM::class.java))
        }
        
        btnVerTodosAtrasos?.setOnClickListener {
            startActivity(Intent(this, TelaRF36FinanceiroADM::class.java))
        }
    }
}
