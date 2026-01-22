package com.project.cemetery.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(nav: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(60.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Button(onClick = {
            nav.navigate("add")
            println("klik tambah")
        }) {
            Text("Tambah Makam")
        }

        Button(onClick = { nav.navigate("map") }) {
            Text("Lihat Peta")
        }

        Button(onClick = { nav.navigate("search") }) {
            Text("Cari Makam")
        }

        Button(onClick = { nav.navigate("print") }) {
            Text("Cetak Denah")
        }

        Button(onClick = { nav.navigate("list") }) {
            Text("📋 Data Makam")
        }

    }
}