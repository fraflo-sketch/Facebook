package me.keynerfranco

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import me.keynerfranco.ui.screen.FeedScreen
import me.keynerfranco.ui.screens.FacebookLoginScreen
import me.keynerfranco.ui.screens.FacebookRegisterScreen
import me.keynerfranco.ui.screens.ForgotPasswordScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val myNavController = rememberNavController()

            NavHost(
                navController = myNavController,
                startDestination = Routes.Login,
                modifier = Modifier.fillMaxWidth()
            ) {
                composable(route = Routes.Login) {
                    FacebookLoginScreen(
                        onClickRegister = {
                            myNavController.navigate(route = Routes.Register)
                        },
                        onClickIniciarSesion = {
                            myNavController.navigate(route = Routes.Feed) {
                                popUpTo(route = Routes.Login) {
                                    inclusive = true
                                }
                            }
                        },
                        onClickForgotPassword = {
                            myNavController.navigate(route = Routes.ForgotPassword)
                        }
                    )
                }
                composable(route = Routes.Register) {
                    FacebookRegisterScreen(
                        onClickBack = {
                            myNavController.popBackStack()
                        }
                    )
                }
                composable(route = Routes.ForgotPassword) {
                    ForgotPasswordScreen(
                        onClickBack = {
                            myNavController.popBackStack()
                        }
                    )
                }
                composable(route = Routes.Feed) {
                    FeedScreen()
                }
            }
        }
    }
}
