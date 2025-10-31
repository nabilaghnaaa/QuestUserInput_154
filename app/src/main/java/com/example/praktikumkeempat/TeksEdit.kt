package com.example.praktikumkeempat

import android.R
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable

fun FormDataDiri(modifier: Modifier
){
    //Variabel - variabel untuk mengingat nilai masukan dari keyboard
    var textName by remember { mutableStateOf("") }
    var textAlamat by remember {mutableStateOf("")}
    var textJK by remember {mutableStateOf("")}
}