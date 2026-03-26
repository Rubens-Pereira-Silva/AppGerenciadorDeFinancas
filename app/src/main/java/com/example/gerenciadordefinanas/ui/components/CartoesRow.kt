package com.example.gerenciadordefinanas.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gerenciadordefinanas.data.CartoesLista

@Composable
fun CartoesRow(){
    Row(
        modifier = Modifier
            .horizontalScroll(rememberScrollState())
            .padding(20.dp)
    ) {
        CartoesLista.cartoesLista.forEach { cartaoModel ->
            CartaoUI(cartaoModel)

            Spacer(
                modifier = Modifier
                    .width(20.dp)
            )
        }
    }
}