package com.example.teste

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class `04UsuarioGoogle` : AppCompatActivity() {

    lateinit var emailGoogle: EditText
    lateinit var bntProximo: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.telarf4_usuariogoogle)

        emailGoogle = findViewById(R.id.edtEmailGoogle)
        bntProximo = findViewById(R.id.btnProxima)


    }
}
