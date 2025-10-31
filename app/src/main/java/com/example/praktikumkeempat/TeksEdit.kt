package com.example.praktikumkeempat

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp

@Composable
fun FormDataDiri(modifier: Modifier) {
    // Variabel - variabel untuk mengingat nilai masukan dari keyboard
    var textNama by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }
    var textJK by remember { mutableStateOf("") }

    // variable-variable untuk menyimpan data yang diperoleh dari komponen UI
    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenis by remember { mutableStateOf("") }

    val gender: List<String> = listOf("Laki-Laki", "Perempuan")

    Column(
        modifier = Modifier.padding(top = 50.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = textNama,
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.width(250.dp),
            label = { Text(text = "Nama Lengkap") },
            onValueChange = {
                textNama = it
            }
        )

        Row {
            gender.forEach { item ->
                Row(
                    modifier = Modifier.selectable(
                        selected = textJK == item,
                        onClick = { textJK = item }
                    ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = textJK == item,
                        onClick = {
                            textJK = item
                        }
                    )
                    Text(item)
                }
            }
        }

        OutlinedTextField(
            value = textAlamat,
            singleLine = true,
            modifier = Modifier.width(250.dp),
            label = { Text(text = "Alamat Lengkap") },
            onValueChange = {
                textAlamat = it
            }
        )
        Divider(
            modifier = Modifier.padding(
                bottom = dimensionResource(id = R.dimen.padding_medium),
                top = dimensionResource(id = R.dimen.padding_medium)
            ),
            thickness = dimensionResource(id = R.dimen.padding_tipis),
            color = Color.DarkGray
        )
    }
}