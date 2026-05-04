package com.example.bibliounifor

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class RF09DashboardUsuario : AppCompatActivity() {

    lateinit var navHome: ImageView
    lateinit var navPerfil: ImageView
    lateinit var navCalendario: ImageView
    lateinit var navAjuda: ImageView
    lateinit var navConfig: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.telarf09_dashboardusuario)

        navHome = findViewById(R.id.navHome)
        navPerfil = findViewById(R.id.navPerfil)
        navCalendario = findViewById(R.id.navCalendario)
        navAjuda = findViewById(R.id.navAjuda)
        navConfig = findViewById(R.id.navConfig)

    }
}
