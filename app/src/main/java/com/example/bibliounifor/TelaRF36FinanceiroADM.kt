package com.example.bibliounifor

import android.content.Intent // Importação para a navegação
import android.os.Bundle
import android.widget.ImageView // Importação para reconhecer imagens/ícones
import androidx.appcompat.app.AppCompatActivity

class TelaRF36FinanceiroADM : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Mantive o nome do layout exatamente como você enviou
        setContentView(R.layout.telarf36_finaceiro_adm)

        // 👇 BARRA ADM
        NavigationUtils.setupAdminNavigation(this)
    }
}