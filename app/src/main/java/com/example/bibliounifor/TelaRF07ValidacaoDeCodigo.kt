package com.example.bibliounifor

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TelaRF07ValidacaoDeCodigo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf07_validacao_de_codigo)

        val editCodigo = findViewById<EditText>(R.id.editCodigo)
        val textErro = findViewById<TextView>(R.id.textErro)
        val buttonVoltar = findViewById<Button>(R.id.btnVoltarTelaValidacaoCodigo)
        val buttonEnviarCodigo = findViewById<Button>(R.id.btnEnviarCodigo)

        // Inicialmente o erro fica invisível
        textErro.visibility = View.INVISIBLE

        buttonVoltar.setOnClickListener {
            val intent = Intent(this, TelaRF06RecuperacaoSenha::class.java)
            startActivity(intent)
            finish()
        }

        buttonEnviarCodigo.setOnClickListener {
            val codigoDigitado = editCodigo.text.toString()

            // Simulação de código correto (ex: 123456)
            if (codigoDigitado == "123456") {
                textErro.visibility = View.INVISIBLE
                val intent = Intent(this, TelaRF08RedefinirSenha::class.java)
                startActivity(intent)
            } else {
                // Código incorreto
                textErro.visibility = View.VISIBLE
                textErro.text = "Código incorreto. Verifique seu e-mail."
            }
        }
    }
}
