package com.example.gerenciadordefinanas.ui.components

import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.gerenciadordefinanas.data.CartoesLista


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDownInput(
        placeholder: String,
        value: String,
        expanded: Boolean,
        list : List<String>,
        onExpandedChange: (Boolean) -> Unit,
        onItemSelect: (String) -> Unit){
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange =  {onExpandedChange(!expanded)}
    ) {

        TextField(
            value = value,
            onValueChange = {},
            readOnly = true,
            placeholder = { Text(placeholder)},
            modifier = Modifier
                .menuAnchor()
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = {}
        ) {
            list.forEach { Item ->
                DropdownMenuItem(
                    text = { Text(Item)},
                    onClick = {
                        onItemSelect(Item)
                        onExpandedChange(false)
                    }
                )
            }
        }
    }
}

