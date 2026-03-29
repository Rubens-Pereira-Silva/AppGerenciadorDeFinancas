package com.example.gerenciadordefinanas.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gerenciadordefinanas.data.CartoesLista
import com.example.gerenciadordefinanas.ui.components.AlertExcluirCartao
import com.example.gerenciadordefinanas.ui.components.CartaoEditUI
import com.example.gerenciadordefinanas.ui.components.DialogCreateCartao

@Composable
fun EditCardsScreen(navController: NavController){

    var openAlertDialog by remember { mutableStateOf(false) }
    var openDialogCreateCartao by remember { mutableStateOf(false) }
    var cartaoParaExcluir by remember { mutableIntStateOf(-1) }

    if(openAlertDialog){
        AlertExcluirCartao(
            { openAlertDialog = false},
            {
                    CartoesLista.cartoesLista.removeAt(cartaoParaExcluir)
                    openAlertDialog = false
            },
            "Excluir Cartão?",
            "Tem certeza que deseja excluir esse cartão?"
        )
    }

    if(openDialogCreateCartao){
        DialogCreateCartao(openDialogCreateCartao, { openDialogCreateCartao = false })
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        )
        {
            Button(
                onClick = { navController.navigate("home") }
            ) {
                Text("⬅️")
            }

            Button(
                onClick = {openDialogCreateCartao = true}
            ) {
                Text("➕")
            }
        }



        Spacer(
            modifier = Modifier
                .height(20.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CartoesLista.cartoesLista.forEachIndexed { index, cartaoModel ->
                CartaoEditUI(
                    cartaoModel,
                    onClickExcluir = {
                        cartaoParaExcluir = index
                        openAlertDialog = true
                    }
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
            }
        }
    }
}