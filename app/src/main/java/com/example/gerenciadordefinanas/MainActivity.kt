package com.example.gerenciadordefinanas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gerenciadordefinanas.ui.screens.EditCardsScreen
import com.example.gerenciadordefinanas.ui.screens.Home
import com.example.gerenciadordefinanas.ui.theme.GerenciadorDeFinançasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GerenciadorDeFinançasTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "home"){
                    composable("home") { Home(navController)}
                    composable("editcardsscreen") { EditCardsScreen(navController) }
                }
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GerenciadorDeFinançasTheme {
        Home(navController = rememberNavController())
    }
}