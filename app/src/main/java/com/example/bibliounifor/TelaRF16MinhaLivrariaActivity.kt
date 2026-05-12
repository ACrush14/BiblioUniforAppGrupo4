package com.example.bibliounifor

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class TelaRF16MinhaLivrariaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf16_minhalivraria)

        // 🔽 FILTRO DA LIVRARIA

        val btnFiltro = findViewById<ImageButton>(R.id.btnFiltroLivros)

        btnFiltro.setOnClickListener {

            val popup = PopupMenu(this, btnFiltro)

            popup.menu.add("Lido")
            popup.menu.add("Lendo")
            popup.menu.add("Não lido")

            popup.setOnMenuItemClickListener {
                Toast.makeText(
                    this,
                    "Filtro: ${it.title}",
                    Toast.LENGTH_SHORT
                ).show()
                true
            }
            popup.show()
        }

        // 📚 CARD DO LIVRO

        val cardLivro = findViewById<View>(R.id.cardLivro1)

        // CAPA
        val imgLivro = cardLivro.findViewById<ImageView>(R.id.imgLivroMinhaLivraria)

        // 3 PONTOS
        val btnVerMais = cardLivro.findViewById<ImageButton>(R.id.btnVerMaisLivro)

        // REMOVER
        val btnRemover = cardLivro.findViewById<MaterialButton>(R.id.btnRemoverLivro)

        // 📖 ABRIR TELA DO LIVRO

        imgLivro.setOnClickListener {
            startActivity(
                Intent(this, TelaRF13TelaDoLivro::class.java))
        }

        // ⋮ MENU VER MAIS

        btnVerMais.setOnClickListener {
            val popup = PopupMenu(this, btnVerMais)
            popup.menu.add("Ver mais")
            popup.setOnMenuItemClickListener {
                startActivity(Intent(this, TelaRF14VerMaisLivro::class.java))
                true
            }
            popup.show()
        }

        // ❌ REMOVER LIVRO

        btnRemover.setOnClickListener {
            Toast.makeText(this, "Livro removido", Toast.LENGTH_SHORT).show()
        }
    }
}