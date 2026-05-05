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

    fun setupAdminNavigation(activity: Activity) {
        val navDashboard = activity.findViewById<ImageView>(R.id.navDashboard)
        val navFinanceiro = activity.findViewById<ImageView>(R.id.navFinanceiro)
        val navSolicitacoes = activity.findViewById<ImageView>(R.id.navSolicitacoes)
        val navLivrosADM = activity.findViewById<ImageView>(R.id.navLivrosADM)
        val navUsuarios = activity.findViewById<ImageView>(R.id.navUsuarios)

        navDashboard?.setOnClickListener {
            if (activity !is TelaRF30DashboardADM) {
                activity.startActivity(Intent(activity, TelaRF30DashboardADM::class.java))
            }
        }

        navFinanceiro?.setOnClickListener {
            if (activity !is TelaRF36FinanceiroADM) {
                activity.startActivity(Intent(activity, TelaRF36FinanceiroADM::class.java))
            }
        }

        navSolicitacoes?.setOnClickListener {
            if (activity !is TelaRF33Solicitacoes) {
                activity.startActivity(Intent(activity, TelaRF33Solicitacoes::class.java))
            }
        }

        navLivrosADM?.setOnClickListener {
            if (activity !is TelaRF34LivrosCRUD) {
                activity.startActivity(Intent(activity, TelaRF34LivrosCRUD::class.java))
            }
        }

        navUsuarios?.setOnClickListener {
            if (activity !is TelaRF31GerenciamentoDeUsuarios) {
                activity.startActivity(Intent(activity, TelaRF31GerenciamentoDeUsuarios::class.java))
            }
        }

        // Tint active icon
        val activeColor = 0xFF6EC1C3.toInt() // Cyan/Turquoise from many screens
        when (activity) {
            is TelaRF30DashboardADM -> navDashboard?.setColorFilter(activeColor)
            is TelaRF36FinanceiroADM -> navFinanceiro?.setColorFilter(activeColor)
            is TelaRF33Solicitacoes -> navSolicitacoes?.setColorFilter(activeColor)
            is TelaRF34LivrosCRUD,
            is TelaRF35CadastroDeLivros,
            is TelaRF35_3InfosAdicionais,
            is TelaRF35_4Versoes,
            is TelaRF38ListaAlugueisADM,
            is TelaRF39InfoLivroADM -> navLivrosADM?.setColorFilter(activeColor)
            is TelaRF31GerenciamentoDeUsuarios,
            is TelaRF32UsuariosParaADM,
            is TelaRF37ConfirmarCadastroADM -> navUsuarios?.setColorFilter(activeColor)
            is TelaRF40ConfigADM,
            is TelaRF41RedefinirADMInterno -> {
                // No specific icon for settings in bottom nav, but maybe we want to untint others
            }
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
