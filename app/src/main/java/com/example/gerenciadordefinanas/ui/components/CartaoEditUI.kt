package com.example.gerenciadordefinanas.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.gerenciadordefinanas.model.CartaoModel

@Composable
fun CartaoEditUI(cartao: CartaoModel, onClickExcluir: () -> Unit){
    Column(
        modifier = Modifier
            .width(270.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(cartao.cor)
            .padding(15.dp)
            .height(140.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //variaveis
        val btnTamanho : Int = 60

        //Linha parte de cima do cartão
        Row(
            modifier = Modifier
                .width(250.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            //Nome do cartão
            Text(
                text = cartao.nome
            )
        }


        Spacer(
            modifier = Modifier
                .height(10.dp)
        )

        //Ultimos 4 digitos
        Text(
            text = "XXXX XXXX XXXX " + cartao.numero
        )

        Spacer(
            modifier = Modifier
                .height(10.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth(0.9f),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
            onClick = {

            }
            ) {
                Text("✏️")
            }

            Button(
                onClick = { onClickExcluir() }
            ) {
                Text("🗑️")
            }}

    }
}
