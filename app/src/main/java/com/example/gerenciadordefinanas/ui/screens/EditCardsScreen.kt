package com.example.gerenciadordefinanas.ui.screens

import android.widget.Space
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gerenciadordefinanas.data.CartoesLista
import com.example.gerenciadordefinanas.ui.components.CartaoEditUI

@Composable
fun EditCardsScreen(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Button(
            onClick = { navController.navigate("home") }
        ) {
            Text("⬅️")
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
            CartoesLista.cartoesLista.forEach { cartaoModel ->
                CartaoEditUI(cartaoModel)
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
            }
        }
    }
}