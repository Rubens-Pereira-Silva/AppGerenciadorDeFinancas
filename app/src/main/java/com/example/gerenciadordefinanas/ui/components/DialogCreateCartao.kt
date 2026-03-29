package com.example.gerenciadordefinanas.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.gerenciadordefinanas.data.CartoesLista
import com.example.gerenciadordefinanas.model.CartaoModel
import com.github.skydoves.colorpicker.compose.HsvColorPicker
import com.github.skydoves.colorpicker.compose.rememberColorPickerController

@SuppressLint("InvalidColorHexValue")
@Composable
fun DialogCreateCartao(
    aberto: Boolean,
    onDismiss: () -> Unit
){

    var nomeDoCartao by remember { mutableStateOf("") }
    var finalCartao by remember { mutableStateOf("") }

    var corCartao by remember { mutableStateOf(Color(0xFFFFFFF))}
    val controller = rememberColorPickerController()

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

                TextField(
                    value = nomeDoCartao,
                    placeholder = { Text("Nome do Cartão") },
                    onValueChange = { nomeDoCartao = it},
                )

                TextField(
                    value = finalCartao,
                    placeholder = { Text("Final do Cartão") },
                    onValueChange = { finalCartao = it},
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    )
                )

                HsvColorPicker(
                    onColorChanged = {
                        corCartao = controller.selectedColor.value
                    },
                    controller = controller,
                    modifier = Modifier
                        .height(300.dp),
                )


                Button(
                    onClick = {
                        CartoesLista.cartoesLista.add(CartaoModel(nomeDoCartao, finalCartao.toInt(), 0.0, corCartao))
                    }
                ) {
                    Text("Adicionar")
                }
            }
        }

    }
}
