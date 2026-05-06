package com.example.bibliounifor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class TelaRF42VerificarMidia : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf42_verificar_midia)

        // Navegação ADM
        NavigationUtils.setupAdminTopBar(this)
        NavigationUtils.setupAdminBottomNavigation(this)
    }
}
