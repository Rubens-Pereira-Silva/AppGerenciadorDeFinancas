package com.example.gerenciadordefinanas.ui.components

import android.R.attr.enabled
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.gerenciadordefinanas.data.CartoesLista
import com.example.gerenciadordefinanas.model.MovimentacaoCartao

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DialogAddMovimentacao(
    aberto: Boolean,
    onDismiss: () -> Unit
){
    var finalCartao by remember { mutableStateOf("") }
    var valor by remember { mutableStateOf("") }
    var categoria by remember { mutableStateOf("") }
    var expandedInputFinalCartao by remember { mutableStateOf(false) }
    var expandedInputCateoria by remember { mutableStateOf(false) }

    if(aberto){
        Dialog(
            onDismissRequest = { onDismiss() },
        ){

            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(Black)
                    .width(400.dp)
                    .padding(40.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                DropDownInput(
                    placeholder = "Final do Cartão",
                    value = finalCartao,
                    expanded = expandedInputFinalCartao,
                    list = CartoesLista.cartoesLista.map{cartao -> cartao.numero.toString()},
                    onExpandedChange = { expandedInputFinalCartao = it },
                    onItemSelect = {finalCartao = it},
                )

                Spacer(
                    modifier = Modifier.height(20.dp)
                )

                TextField(
                    value = valor,
                    onValueChange = { valor = it },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    placeholder = {Text("Valor Movimentado")},
                    modifier = Modifier.height(70.dp)
                )

                Spacer(
                    modifier = Modifier.height(20.dp)
                )

                DropDownInput(
                    placeholder = "Categoria",
                    value = categoria,
                    expanded = expandedInputCateoria,
                    list = CartoesLista.categoriasMovimentacao,
                    onExpandedChange = { expandedInputCateoria = it },
                    onItemSelect = {categoria = it},
                )

                Spacer(
                    modifier = Modifier.height(20.dp)
                )

                Button(
                    onClick = {
                        val cartao = CartoesLista.cartoesLista.find{it.numero == finalCartao.toInt()}
                        cartao?.movimentacaoLista?.add(MovimentacaoCartao(valor.toDouble(), categoria))

                        valor = ""
                        categoria = ""
                    }
                ) {
                    Text("Adicionar")
                }
            }
        }

    }
}
