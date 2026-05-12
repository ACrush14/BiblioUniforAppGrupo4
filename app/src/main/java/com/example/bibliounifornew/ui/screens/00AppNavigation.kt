package com.example.bibliounifor.ui.screens

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bibliounifor.TelaRF30DashboardADM

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val context = LocalContext.current

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(
                onNavigateToForgot = { navController.navigate("forgot_password") },
                onNavigateToRegister = { navController.navigate("register") },
                onLoginSuccess = {
                    // Navega para o Dashboard após login bem-sucedido
                    val intent = Intent(context, TelaRF30DashboardADM::class.java)
                    context.startActivity(intent)
                },
                onNavigateBack = {
                    // Se estiver em um NavHost, tenta voltar na pilha ou encerra a navegação
                    if (!navController.popBackStack()) {
                        // Opcional: fechar a activity se não houver para onde voltar no NavHost
                    }
                }
            )
        }
        composable("register") {
            RegisterScreen(
                onNavigateBack = { navController.popBackStack() },
                onNavigateToLogin = { navController.navigate("login") }
            )
        }
        composable("forgot_password") {
            ForgotPasswordScreen(
                onNavigateBack = { navController.popBackStack() },
                onNavigateToValidation = { navController.navigate("validation") }
            )
        }
        composable("validation") {
            ValidationScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}
