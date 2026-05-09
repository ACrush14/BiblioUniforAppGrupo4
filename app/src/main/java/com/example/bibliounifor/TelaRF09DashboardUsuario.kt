package com.example.bibliounifor

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class TelaRF09DashboardUsuario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf09_dashboardusuario)

        // Botões do Header
        val btnConfig = findViewById<ImageView>(R.id.btnConfig)
        val btnNotificacao = findViewById<ImageView>(R.id.btnNotificacao)
        val profileImage = findViewById<ImageView>(R.id.profile_image)
        val textNomeUsuario = findViewById<TextView>(R.id.textNomeUsuario)

        // Botões de Ações Rápidas (Cards/Buttons no ScrollView)
        val btnProcurarLivros = findViewById<MaterialButton>(R.id.btnProcurarLivros)
        val btnMinhaLivraria = findViewById<MaterialButton>(R.id.btnMinhaLivrariaDash)
        val btnListaDesejo = findViewById<MaterialButton>(R.id.btnListaDesejoDash)
        val btnAmigos = findViewById<MaterialButton>(R.id.btnAmigosDash)
        val btnHistorico = findViewById<MaterialButton>(R.id.btnHistoricoDash)
        val btnStatusAluguel = findViewById<MaterialButton>(R.id.btnStatusAluguelDash)
        val btnSair = findViewById<MaterialButton>(R.id.btnSairDash)
        val cardLivro = findViewById<androidx.cardview.widget.CardView>(R.id.cardLivro)
        val bntSalvar = findViewById<MaterialButton>(R.id.bntSalvar)

        // Navegação via Engrenagem -> Configuração (RF10)
        btnConfig.setOnClickListener {
            startActivity(Intent(this, TelaRF10Configuracao::class.java))
        }

        btnNotificacao.setOnClickListener {
            startActivity(Intent(this, TelaRF21Notificacoes::class.java))
        }

        // Ações Rápidas
        btnProcurarLivros.setOnClickListener {
            startActivity(Intent(this, TelaRF12TelaDePesquisa::class.java))
        }

        btnMinhaLivraria.setOnClickListener {
            startActivity(Intent(this, TelaRF16MinhaLivrariaActivity::class.java))
        }

        btnListaDesejo.setOnClickListener {
            startActivity(Intent(this, TelaRF17ListaDesejosActivity::class.java))
        }

        btnAmigos.setOnClickListener {
            startActivity(Intent(this, TelaRF18::class.java))
        }

        btnHistorico.setOnClickListener {
            startActivity(Intent(this, TelaRF22Historico::class.java))
        }

        btnStatusAluguel.setOnClickListener {
            startActivity(Intent(this, TelaRF19::class.java))
        }

        btnSair.setOnClickListener {
            //PopUp sair da conta
            val dialog = android.app.AlertDialog.Builder(this)
                .setTitle("ATENÇÃO!")
                .setMessage("Confirme que deseja sair da sua conta")
                .setPositiveButton("Sair") { _, _ ->

                    val intent = Intent(this, MainActivity::class.java)

                    intent.flags =
                        Intent.FLAG_ACTIVITY_NEW_TASK or
                                Intent.FLAG_ACTIVITY_CLEAR_TASK

                    startActivity(intent)
                }

                .setNegativeButton("Cancelar", null)
                .create()

            dialog.show()

            // FUNDO BRANCO
            dialog.window?.setBackgroundDrawableResource(android.R.color.white)

            // BOTÃO SAIR
            dialog.getButton(android.app.AlertDialog.BUTTON_POSITIVE)
                .setBackgroundColor(getColor(R.color.biblio_red))

            dialog.getButton(android.app.AlertDialog.BUTTON_POSITIVE)
                .setTextColor(getColor(android.R.color.white))

            // BOTÃO CANCELAR
            dialog.getButton(android.app.AlertDialog.BUTTON_NEGATIVE)
                .setBackgroundColor(android.graphics.Color.TRANSPARENT)

            dialog.getButton(android.app.AlertDialog.BUTTON_NEGATIVE)
                .setTextColor(getColor(R.color.biblio_red))

            // TÍTULO VERMELHO
            dialog.findViewById<TextView>(
                resources.getIdentifier(
                    "alertTitle",
                    "id",
                    "android"
                )
            )?.setTextColor(getColor(R.color.biblio_red))

            // MENSAGEM VERMELHA
            dialog.findViewById<TextView>(
                android.R.id.message
            )?.setTextColor(getColor(R.color.biblio_red))
        }

        cardLivro.setOnClickListener {
            startActivity(
                Intent(this, TelaRF13TelaDoLivro::class.java)
            )
        }

        bntSalvar.setOnClickListener {

            val dialog = android.app.AlertDialog.Builder(this)
                .setTitle("Sucesso!")
                .setMessage("Alterações salvas com sucesso!")
                .setPositiveButton("Voltar", null)
                .create()

            dialog.show()

            // FUNDO BRANCO
            dialog.window?.setBackgroundDrawableResource(android.R.color.white)

            // BOTÃO CIANO
            dialog.getButton(android.app.AlertDialog.BUTTON_POSITIVE)
                .setBackgroundColor(getColor(R.color.biblio_cyan))

            dialog.getButton(android.app.AlertDialog.BUTTON_POSITIVE)
                .setTextColor(getColor(android.R.color.white))

            // TÍTULO CIANO
            dialog.findViewById<TextView>(
                resources.getIdentifier(
                    "alertTitle",
                    "id",
                    "android"
                )
            )?.setTextColor(getColor(R.color.biblio_cyan))

            // TEXTO CIANO
            dialog.findViewById<TextView>(
                android.R.id.message
            )?.setTextColor(getColor(R.color.biblio_cyan))
        }

    }
}
