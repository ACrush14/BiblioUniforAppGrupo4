package com.example.bibliounifor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
class TelaRF23RenovacaoOnline : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf23_renovacao_online)

        val buttonConfirmarData = findViewById<Button>(R.id.btnConfirmarData)
        val buttonVoltar = findViewById<Button>(R.id.textVoltarDaRenovacao)


        buttonConfirmarData.setOnClickListener {
            val intent = Intent(this, TelaRF19::class.java) //precisa criar a actiivty do RF19
            startActivity(intent)
        }

        buttonVoltar.setOnClickListener {
            val intent = Intent(this, TelaRF19::class.java)
            startActivity(intent)
        }

    }
}
