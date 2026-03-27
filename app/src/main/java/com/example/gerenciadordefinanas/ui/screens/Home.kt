package com.example.gerenciadordefinanas.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gerenciadordefinanas.ui.components.CartoesRow
import com.example.gerenciadordefinanas.ui.components.DialogAddMovimentacao
import com.example.gerenciadordefinanas.ui.components.MovimentacaoCol

@Composable
fun Home(navController: NavController) {
    var addMovimentacaoVisivel by remember { mutableStateOf(false) }
    var abrirDialogAddMovimentacao by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        //Linhas que mostra os cartões que o usuario possui

        CartoesRow()

        Button(
            onClick = { abrirDialogAddMovimentacao = true}
        ) {
            Text("Adicionar Movimentação")
        }

        Button(
            onClick = { navController.navigate("editcardsscreen")}
        ){
            Text("Cartões")
        }


        //Coluna principal
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DialogAddMovimentacao(abrirDialogAddMovimentacao, onDismiss = { abrirDialogAddMovimentacao = false})

            //Coluna com as movimentações dos cartões
            MovimentacaoCol()
        }
    }

}
