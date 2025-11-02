package com.example.praktikumkeempat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FormPendaftaran(modifier: Modifier = Modifier) {
    var textNama by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }
    var textJK by remember { mutableStateOf("") }
    var textStatus by remember { mutableStateOf("") }

    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenisKelamin by remember { mutableStateOf("") }
    var statusPerkawinan by remember { mutableStateOf("") }

    val genderList = listOf("Laki-laki", "Perempuan")
    val statusList = listOf("Janda", "Lajang", "Duda")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFE6F6)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Header bagian atas
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .background(Color(0xFFFFA6D8)),
            contentAlignment = Alignment.BottomStart
        ) {
            Text(
                text = "Formulir Pendaftaran",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(start = 24.dp, bottom = 12.dp)
            )
        }

        // Jarak antar elemen
        Spacer(modifier = Modifier.height(24.dp))

        // Card utama
        Card(
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            // Column isi form
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                // Input Nama
                Text("NAMA LENGKAP", fontWeight = FontWeight.SemiBold)
                OutlinedTextField(
                    value = textNama,
                    onValueChange = { textNama = it },
                    label = { Text("Isian nama lengkap") },
                    singleLine = true,
                    shape = MaterialTheme.shapes.large,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                )

                // Pilihan jenis kelamin
                Text("JENIS KELAMIN", fontWeight = FontWeight.SemiBold)
                genderList.forEach { gender ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .selectable(
                                selected = textJK == gender,
                                onClick = { textJK = gender }
                            )
                            .padding(start = 8.dp, top = 4.dp)
                    ) {
                        RadioButton(
                            selected = textJK == gender,
                            onClick = { textJK = gender }
                        )
                        Text(gender)
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Pilihan status perkawinan
                Text("STATUS PERKAWINAN", fontWeight = FontWeight.SemiBold)
                statusList.forEach { status ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .selectable(
                                selected = textStatus == status,
                                onClick = { textStatus = status }
                            )
                            .padding(start = 8.dp, top = 4.dp)
                    ) {
                        RadioButton(
                            selected = textStatus == status,
                            onClick = { textStatus = status }
                        )
                        Text(status)
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Input alamat lengkap
                Text("ALAMAT", fontWeight = FontWeight.SemiBold)
                OutlinedTextField(
                    value = textAlamat,
                    onValueChange = { textAlamat = it },
                    label = { Text("Isian alamat lengkap") },
                    singleLine = true,
                    shape = MaterialTheme.shapes.large,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Tombol Submit dengan colorResource
                Button(
                    onClick = {
                        nama = textNama
                        jenisKelamin = textJK
                        statusPerkawinan = textStatus
                        alamat = textAlamat
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.blue_submit),
                        contentColor = Color.White,
                        disabledContainerColor = colorResource(id = R.color.blue_submit),
                        disabledContentColor = Color.White
                    ),
                    shape = RoundedCornerShape(12.dp),
                    enabled = textNama.isNotEmpty() && textJK.isNotEmpty() &&
                            textStatus.isNotEmpty() && textAlamat.isNotEmpty()
                ) {
                    Text("Submit", color = Color.White, fontSize = 16.sp)
                }
            }
        }
    }
}
