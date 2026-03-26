package com.example.gerenciadordefinanas

import android.R.attr.contentDescription
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.DisplayMode.Companion.Input
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gerenciadordefinanas.ui.components.CartoesRow
import com.example.gerenciadordefinanas.ui.components.DialogAddMovimentacao
import com.example.gerenciadordefinanas.ui.components.MovimentacaoCol
import com.example.gerenciadordefinanas.ui.theme.GerenciadorDeFinançasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GerenciadorDeFinançasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    App(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun App(modifier: Modifier) {
    var addMovimentacaoVisivel by remember { mutableStateOf(false) }

    var categoria: String = remember { mutableStateOf("").toString()}



    Column(
        modifier = Modifier
        .fillMaxSize()
        .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        //Linhas que mostra os cartões que o usuario possui

        CartoesRow()

        //Coluna principal
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            DialogAddMovimentacao()

            //Coluna com as movimentações dos cartões
            MovimentacaoCol()
        }
    }

}



































@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GerenciadorDeFinançasTheme {
        App(Modifier)
    }
}