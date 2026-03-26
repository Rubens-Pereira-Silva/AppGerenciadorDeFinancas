package com.example.gerenciadordefinanas.ui.components

import android.app.AlertDialog
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.gerenciadordefinanas.data.CartoesLista
import com.example.gerenciadordefinanas.model.MovimentacaoCartao

@Composable
fun DialogAddMovimentacao(
){
    var finalCartao by remember { mutableStateOf("") }
    var valor by remember { mutableStateOf("") }
    var categoria by remember { mutableStateOf("") }

    TextField(
        value = finalCartao,
        onValueChange = { finalCartao = it },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        ),
        placeholder = {Text("Final Cartao")},
        modifier = Modifier.height(70.dp)
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

    TextField(
        value = categoria,
        onValueChange = { categoria = it },
        placeholder = {Text("Categoria")},
        modifier = Modifier.height(70.dp)
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
