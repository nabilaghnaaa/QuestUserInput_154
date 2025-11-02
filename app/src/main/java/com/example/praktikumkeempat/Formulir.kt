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

    // variabel buat nyimpen inputan sementara dari user
    var textNama by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }
    var textJK by remember { mutableStateOf("") }
    var textStatus by remember { mutableStateOf("") }

    // variabel ini buat nampung data yang udah disubmit (hasil akhir)
    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenisKelamin by remember { mutableStateOf("") }
    var statusPerkawinan by remember { mutableStateOf("") }

    // list pilihan buat radio button jenis kelamin
    val genderList = listOf("Laki-laki", "Perempuan")
    // list pilihan buat status perkawinan
    val statusList = listOf("Janda", "Lajang", "Duda")

    // tampilan utama pakai column biar ke bawah urut
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFE6F6)) // warna background pink muda
            .padding(0.dp), // biar header nempel ke pinggir
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // bagian header (kotak warna pink tua di atas)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp) // tinggi headernya
                .background(Color(0xFFFFA6D8)), // warna pink lebih tua
            contentAlignment = Alignment.BottomStart // teksnya di bawah kiri
        ) {
            // teks judul di header
            Text(
                text = "Formulir Pendaftaran",
                fontSize = 26.sp, // ukuran huruf agak gede
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(start = 24.dp, bottom = 12.dp) // jarak teks dari pinggir
            )
        }

        // jarak antara header sama card
        Spacer(modifier = Modifier.height(24.dp))

        // card utama yang isinya form input
        Card(
            shape = RoundedCornerShape(16.dp), // biar sudutnya ga kaku
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White), // warna putih di dalem card
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp) // jarak kanan kiri biar ga mepet layar
        ) {
            // isi dari form
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                // label nama
                Text("NAMA LENGKAP", fontWeight = FontWeight.SemiBold)
                OutlinedTextField(
                    value = textNama,
                    onValueChange = { textNama = it }, // kalo diketik langsung ke-update
                    label = { Text("Isian nama lengkap") },
                    singleLine = true, // cuma satu baris input
                    shape = MaterialTheme.shapes.large,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                )

                // bagian jenis kelamin
                Text("JENIS KELAMIN", fontWeight = FontWeight.SemiBold)
                genderList.forEach { gender -> // looping tiap pilihan gender
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .selectable(
                                selected = textJK == gender, // kalo ini yang dipilih, tandain
                                onClick = { textJK = gender } // pas diklik ubah nilainya
                            )
                            .padding(start = 8.dp, top = 4.dp)
                    ) {
                        // tombol radio
                        RadioButton(
                            selected = textJK == gender,
                            onClick = { textJK = gender }
                        )
                        // teks di sebelah radio
                        Text(gender)
                    }
                }

                // jarak dikit biar ga dempet
                Spacer(modifier = Modifier.height(12.dp))

                // bagian status perkawinan
                Text("STATUS PERKAWINAN", fontWeight = FontWeight.SemiBold)
                statusList.forEach { status -> // looping pilihan status
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

                // jarak lagi biar rapi
                Spacer(modifier = Modifier.height(16.dp))

                // label dan kolom input alamat
                Text("ALAMAT", fontWeight = FontWeight.SemiBold)
                OutlinedTextField(
                    value = textAlamat,
                    onValueChange = { textAlamat = it },
                    label = { Text("Isian alamat lengkap") },
                    singleLine = true,
                    shape = MaterialTheme.shapes.large,
                    modifier = Modifier.fillMaxWidth()
                )

                // jarak sebelum tombol
                Spacer(modifier = Modifier.height(16.dp))

                // tombol submit
                Button(
                    onClick = {
                        // pas diklik tombolnya, data disimpan ke variabel hasil
                        nama = textNama
                        jenisKelamin = textJK
                        statusPerkawinan = textStatus
                        alamat = textAlamat
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.blue_submit), // ambil warna dari colors.xml
                        contentColor = Color.White,
                        disabledContainerColor = colorResource(id = R.color.blue_submit),
                        disabledContentColor = Color.White
                    ),
                    shape = RoundedCornerShape(12.dp), // sudut tombolnya agak melengkung
                    enabled = textNama.isNotEmpty() && textJK.isNotEmpty() && textStatus.isNotEmpty() && textAlamat.isNotEmpty() // tombol baru aktif kalo semua udah diisi
                ) {
                    Text("Submit", color = Color.White, fontSize = 16.sp)
                }
            }
        }
    }
}

aku disuruh nge commit sebanyak 15 kali bantu aku untuk ngebagiin ini sebanyak 15 kali nama + kodingannya agar pas aku commit tidak error