package com.example.gerenciadordefinanas.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Gray
import com.example.gerenciadordefinanas.model.CartaoModel
import com.example.gerenciadordefinanas.ui.theme.Pink40

object CartoesLista {

    val categoriasMovimentacao: List<String> = listOf(
        "Contas",
        "Lazer",
        "Comida",
        "Educação"
    )
    var cartoesLista = listOf(
            CartaoModel("Flash", 1234, 130.50, Pink40),
            CartaoModel("Itau", 5678, 5240.50, Blue),
            CartaoModel("Banco Brasil", 9876, 378.50, Gray),
        )
    var filtroCartao by mutableIntStateOf(0)

}