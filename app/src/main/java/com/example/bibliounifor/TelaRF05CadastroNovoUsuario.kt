package com.example.bibliounifor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class TelaRF05CadastroNovoUsuario : AppCompatActivity() {

    private lateinit var etNome: EditText
    private lateinit var etUsuario: EditText
    private lateinit var etEmail: EditText
    private lateinit var etSenha: EditText
    private lateinit var etConfirmaSenha: EditText
    private lateinit var btnCriar: Button
    private lateinit var btnEntreAqui: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.telarf05_cadastrar_novo_usuario)

        etNome = findViewById(R.id.editTextNome)
        etUsuario = findViewById(R.id.editTextUsuario)
        etSenha = findViewById(R.id.editTextTextSenha)
        etEmail = findViewById(R.id.editTextTextEmail)
        etConfirmaSenha = findViewById(R.id.editTextTextConfirmaSenha)
        btnEntreAqui = findViewById(R.id.EntreAqui)
        btnCriar = findViewById(R.id.Criar)

        btnCriar.setOnClickListener {
            val nome = etNome.text.toString()
            if (nome.isNotEmpty()) {
                Toast.makeText(this, "Cadastro de $nome realizado!", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Preencha o nome pelo menos", Toast.LENGTH_SHORT).show()
            }
        }

        btnEntreAqui.setOnClickListener {
            val intent = Intent(this, TelaRF03LoginAluno::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
        }
    }
}
