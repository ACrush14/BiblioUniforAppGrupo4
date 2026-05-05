package com.example.bibliounifor

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton // Importação do botão

class TelaRF40ConfigADM : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf40_config_adm)

        // 1. Encontrar o botão e o ícone pelos IDs que criamos no XML
        val iconeDashboard = findViewById<ImageView>(R.id.iconDashboard)
        val btnVoltarDashboard = findViewById<MaterialButton>(R.id.btnVoltarDashboard)

        // 2. Criar a ação de clique para o ÍCONE
        iconeDashboard.setOnClickListener {
            val intent = Intent(this, TelaRF30DashboardADM::class.java)
            startActivity(intent)
        }

        // 3. Criar a ação de clique para o BOTÃO
        btnVoltarDashboard.setOnClickListener {
            val intent = Intent(this, TelaRF30DashboardADM::class.java)
            startActivity(intent)
        }
    }
}