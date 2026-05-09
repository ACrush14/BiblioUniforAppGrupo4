package com.example.bibliounifor

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class TelaRF30DashboardADM : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf30_dashboard_adm)

        // Padronização da Navegação ADM (Barra inferior e topo)


        // 1. Botões de Navegação Principal
        val btnTelaCrud = findViewById<MaterialButton>(R.id.btnTelaCrud)
        val btnVerAlugueis = findViewById<MaterialButton>(R.id.btnVerAlugueis)
        val btnVerTodosAtrasos = findViewById<MaterialButton>(R.id.btnVerTodosAtrasos)

        // 2. Novos Botões Adicionados
        val btnVerCadastros = findViewById<MaterialButton>(R.id.btnVerCadastros)
        val btnVerSolicitacoes = findViewById<MaterialButton>(R.id.btnVerSolicitacoesDashboard)
        val btnVerRenovacoes = findViewById<MaterialButton>(R.id.btnVerRenovacoes)

        // --- Listeners Principais ---
        btnTelaCrud?.setOnClickListener {
            startActivity(Intent(this@TelaRF30DashboardADM, TelaRF30CrudADM::class.java))
        }

        btnVerAlugueis?.setOnClickListener {
            startActivity(Intent(this@TelaRF30DashboardADM, TelaRF38ListaAlugueisADM::class.java))
        }
        
        btnVerTodosAtrasos?.setOnClickListener {
            startActivity(Intent(this@TelaRF30DashboardADM, TelaRF36FinanceiroADM::class.java))
        }

        // --- Novos Listeners ---
        btnVerCadastros?.setOnClickListener {
            startActivity(Intent(this@TelaRF30DashboardADM, TelaRF37ConfirmarCadastroADM::class.java))
        }

        btnVerSolicitacoes?.setOnClickListener {
            startActivity(Intent(this@TelaRF30DashboardADM, TelaRF33VerificarMidia::class.java))
        }

        btnVerRenovacoes?.setOnClickListener {
            showRenovacoesPopup()
        }
    }

    private fun showRenovacoesPopup() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Renovações Pendentes")
        builder.setMessage("Usuário: Cícero Correia\nLivro: Pessoas Ansiosas\nData: 5 de Maio\n\n(Deseja aprovar esta renovação?)")
        builder.setPositiveButton("Aprovar") { dialog, _ ->
            Toast.makeText(this, "Renovação aprovada!", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        builder.setNegativeButton("Fechar") { dialog, _ ->
            dialog.dismiss()
        }
        builder.show()
    }
}
