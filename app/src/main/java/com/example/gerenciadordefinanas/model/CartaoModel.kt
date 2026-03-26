package com.example.gerenciadordefinanas.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

data class CartaoModel(
    val nome: String,
    val numero: Int,
    var valor: Double,
    val cor: Color,
    ){

    var movimentacaoLista: MutableList<MovimentacaoCartao> = mutableStateListOf(
        MovimentacaoCartao(100.00, "Comida"),
        MovimentacaoCartao(100.00, "Comida"),
    )

    //Visibilidade do valor no cartão
    var valorVisivel by mutableStateOf(false)
    fun trocarVisibilidade(){
        if(valorVisivel){
            valorVisivel = false
        }else{
            valorVisivel = true
        }
    }

    fun addMovimentacaoCartao(){
           movimentacaoLista.add(MovimentacaoCartao(147.90, "Roupa"))
    }

    fun valorCalulado(): Double{
        var valorCauculado: Double = valor
        movimentacaoLista.forEach { movimentacao ->
            valorCauculado += movimentacao.valor
        }
        return valorCauculado
    }
}