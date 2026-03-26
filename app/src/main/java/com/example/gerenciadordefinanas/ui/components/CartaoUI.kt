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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import com.example.gerenciadordefinanas.model.CartaoModel
import com.example.gerenciadordefinanas.ui.theme.Pink40
import com.example.gerenciadordefinanas.ui.theme.Pink80

@Composable
fun CartaoUI(cartao: CartaoModel){

    Column(
        modifier = Modifier
            .width(270.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(cartao.cor)
            .padding(15.dp)
    ) {
        //Nome do cartão
        Text(
            text = cartao.nome
        )

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
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            //Saldo da conta / visivel ou não
            Text(
                text =  "${if (cartao.valorVisivel) cartao.valorCalulado() else "XXXX"}"
            )

            //Botão para trocar entre salvo visivel ou não visivel
            Button(
                onClick = { cartao.trocarVisibilidade() }
            ) {
                Text(
                    text = "👁️‍🗨️"
                )
            }

            Button(
                onClick = { cartao.addMovimentacaoCartao() }
            ) {
                Text(
                    text = "add"
                )
            }
        }

    }
}
