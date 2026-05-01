package com.example.bibliounifor

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class rf4telagoogle : AppCompatActivity() {

    lateinit var etSenha: EditText;
    lateinit var etSenhaConfirmacao: EditText;
    lateinit var bntX: Button;
    lateinit var bntSalvar: Button;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.telarf41)

        etSenha = findViewById(R.id.editTextTextPassword);
        etSenhaConfirmacao = findViewById(R.id.editTextTextPasswordConfirmacao);
        bntX = findViewById(R.id.buttonX);
        bntSalvar = findViewById(R.id.buttonSalvar);

    }

    override fun onStart() {
        super.onStart()

    }
}
