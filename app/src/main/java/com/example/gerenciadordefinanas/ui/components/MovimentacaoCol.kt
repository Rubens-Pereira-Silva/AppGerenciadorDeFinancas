package com.example.gerenciadordefinanas.ui.components

import android.R.attr.background
import android.R.id.background
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.gerenciadordefinanas.data.CartoesLista
import com.example.gerenciadordefinanas.data.CartoesLista.cartoesLista
import com.example.gerenciadordefinanas.model.MovimentacaoCartao

@Composable
fun MovimentacaoCol(){

    Column() {
        if(CartoesLista.filtroCartao.equals(0)){
            cartoesLista.forEach { cartaoModel ->
                cartaoModel.movimentacaoLista.forEach { movimentacaoCartao ->
                    Row(
                        modifier = Modifier
                            .clip(RoundedCornerShape(16.dp))
                            .background(cartaoModel.cor)
                            .padding(10.dp)
                    ) {
                        Text(
                            text = "Valor: ${movimentacaoCartao.valor} | Categoria: ${movimentacaoCartao.categoria}"
                        )
                    }

                    Spacer(
                        modifier = Modifier
                            .height(15.dp)
                    )
                }
            }
        }else{
            cartoesLista.forEach { cartaoModel ->
                if(cartaoModel.numero.equals(CartoesLista.filtroCartao))
                    cartaoModel.movimentacaoLista.forEach { movimentacaoCartao ->
                        Row(
                            modifier = Modifier
                                .clip(RoundedCornerShape(16.dp))
                                .background(cartaoModel.cor)
                                .padding(10.dp)
                        ) {
                            Text(
                                text = "Valor: ${movimentacaoCartao.valor} | Categoria: ${movimentacaoCartao.categoria}"
                            )
                        }

                        Spacer(
                            modifier = Modifier
                                .height(15.dp)
                        )
                }
            }
        }
    }
}
