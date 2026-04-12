package com.example.bibliounifor.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bibliounifor.ui.screens.ForgotPasswordScreen
import com.example.bibliounifor.ui.screens.LoginScreen
import com.example.bibliounifor.ui.screens.ValidationScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {

        composable("login") {
            LoginScreen(
                onNavigateToForgot = { navController.navigate("forgotPassword") },
                onNavigateToRegister = { navController.navigate("register") },
            )
        }
        composable("forgotPassword") {
            ForgotPasswordScreen(
                onNavigateBack = { navController.popBackStack() },
                onNavigateToValidation = { navController.navigate("validation") }
            )
        }

        composable("validation") {
            ValidationScreen(onNavigateBack = { navController.popBackStack() })
        }

        composable("register") {
            RegisterScreen(
                onNavigateBack = { navController.popBackStack() },
                onNavigateToLogin = {
                    navController.navigate("login") {
                        popUpTo("login") { inclusive = true }
                    }
                }
            )
        }
    }
}

