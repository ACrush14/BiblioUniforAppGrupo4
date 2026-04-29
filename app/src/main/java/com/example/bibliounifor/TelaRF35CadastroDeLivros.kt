package com.example.bibliouniforappgrupo4_v02

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class TelaRF35CadastroDeLivros : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 🔹 XML CORRETO (ATENÇÃO AQUI)
        setContentView(R.layout.telarf35_cadastro_livro)

        // 🔹 Campos (IDs exatamente iguais ao XML)
        val etTitulo = findViewById<EditText>(R.id.etTitulo)
        val etAutor = findViewById<EditText>(R.id.etAutor)
        val etISBN = findViewById<EditText>(R.id.etISBN)
        val etData = findViewById<EditText>(R.id.etData)
        val etQuantidade = findViewById<EditText>(R.id.etQuantidade)

        // 🔹 Botão
        val btnContinuar = findViewById<Button>(R.id.btnContinuar)

        // 🔹 TextView de erro
        val tvErro = findViewById<TextView>(R.id.tvErro)

        btnContinuar.setOnClickListener {

            // Esconde erro antes de validar
            tvErro.visibility = View.GONE

            // Pegando os valores
            val titulo = etTitulo.text.toString().trim()
            val autor = etAutor.text.toString().trim()
            val isbn = etISBN.text.toString().trim()
            val data = etData.text.toString().trim()
            val quantidade = etQuantidade.text.toString().trim()

            // 🔴 VALIDAÇÃO
            if (titulo.isEmpty() ||
                autor.isEmpty() ||
                isbn.isEmpty() ||
                data.isEmpty() ||
                quantidade.isEmpty()
            ) {

                tvErro.visibility = View.VISIBLE

            } else {

                // ✅ SUCESSO
                Toast.makeText(
                    this,
                    "Livro cadastrado com sucesso!",
                    Toast.LENGTH_SHORT
                ).show()

                // 🔹 Volta para o CRUD (RF34)
                val intent = Intent(this, TelaRF34LivrosCRUD::class.java)
                startActivity(intent)

                finish()
            }
        }
    }
}