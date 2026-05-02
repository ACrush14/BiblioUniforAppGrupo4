package com.example.bibliounifor.ui.screens

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.bibliounifor.R

class TelaRF05CadastroNovoUsuario : AppCompatActivity() {

    lateinit var etNome: EditText
    lateinit var etUsuario: EditText
    lateinit var etEmail: EditText
    lateinit var etSenha: EditText
    lateinit var etConfirmaSenha: EditText
    lateinit var bntCriar: Button
    lateinit var bntEntreAqui: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        etNome = findViewById(R.id.editTextNome)
        etUsuario = findViewById(R.id.editTextUsuario)
        etSenha = findViewById(R.id.editTextTextSenha)
        etEmail = findViewById(R.id.editTextTextEmail)
        etConfirmaSenha = findViewById(R.id.editTextTextConfirmaSenha)
        bntEntreAqui = findViewById(R.id.EntreAqui)
        bntCriar = findViewById(R.id.Criar)

        bntCriar.setOnClickListener {
            Toast.makeText(this, "Cadastro realizado!", Toast.LENGTH_SHORT).show()
        }

        bntEntreAqui.setOnClickListener {
            finish()
        }
    }
}
