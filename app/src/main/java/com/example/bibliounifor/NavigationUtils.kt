package com.example.bibliounifor

import android.app.Activity
import android.content.Intent
import android.widget.ImageView

object NavigationUtils {
    fun setupBottomNavigation(activity: Activity) {
        // 1. Casa -> RF09
        activity.findViewById<ImageView>(R.id.navHome)?.setOnClickListener {
            if (activity !is TelaRF09DashboardUsuario) {
                activity.startActivity(Intent(activity, TelaRF09DashboardUsuario::class.java))
            }
        }
        // 2. Tenda -> RF16
        activity.findViewById<ImageView>(R.id.navLivraria)?.setOnClickListener {
            activity.startActivity(Intent(activity, TelaRF16MinhaLivrariaActivity::class.java))
        }
        // 3. Lupa -> RF12
        activity.findViewById<ImageView>(R.id.navSearch)?.setOnClickListener {
            if (activity !is TelaRF12TelaDePesquisa) {
                activity.startActivity(Intent(activity, TelaRF12TelaDePesquisa::class.java))
            }
        }
        // 4. Coração -> RF17
        activity.findViewById<ImageView>(R.id.navDesejos)?.setOnClickListener {
            activity.startActivity(Intent(activity, TelaRF17ListaDesejosActivity::class.java))
        }
        // 5. Livro -> RF19
        activity.findViewById<ImageView>(R.id.navAluguel)?.setOnClickListener {
            activity.startActivity(Intent(activity, TelaRF19::class.java))
        }
        // 6. Pessoa -> RF18
        activity.findViewById<ImageView>(R.id.navAmigos)?.setOnClickListener {
            activity.startActivity(Intent(activity, TelaRF18::class.java))
        }
    }

    fun setupTopBar(activity: Activity) {
        // Sino -> Notificações (RF21)
        activity.findViewById<ImageView>(R.id.btnNotificacao)?.setOnClickListener {
            activity.startActivity(Intent(activity, TelaRF21Notificacoes::class.java))
        }
        // Engrenagem -> Configurações (RF10)
        activity.findViewById<ImageView>(R.id.btnConfig)?.setOnClickListener {
            activity.startActivity(Intent(activity, TelaRF10Configuracao::class.java))
        }
    }
}
