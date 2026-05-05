package com.example.bibliounifor

import android.content.Intent // Importação para a navegação
import android.os.Bundle
import android.widget.ImageView // Importação para reconhecer imagens/ícones
import androidx.appcompat.app.AppCompatActivity

class TelaRF36FinanceiroADM : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Mantive o nome do layout exatamente como você enviou
        setContentView(R.layout.telarf36_finaceiro_adm)

        // 1. Encontrar o ícone da esquerda pelo ID que acabamos de criar no XML
        val iconeDashboard = findViewById<ImageView>(R.id.iconDashboard)

        // 2. Criar a ação de clique no ícone
        iconeDashboard.setOnClickListener {

            // 3. Fazer a ponte (Intent) para a Tela 30
            val intent = Intent(this, TelaRF30DashboardADM::class.java)
            startActivity(intent)

        }
    }
}