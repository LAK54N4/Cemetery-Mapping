package com.project.cemetery.feature.grave

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.project.cemetery.util.RequestLocationPermission

@Composable
fun AddGraveScreen(
    viewModel: AddGraveViewModel = viewModel()
) {
    var name by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    var block by remember { mutableStateOf("") }

    val lat = viewModel.latitude
    val lng = viewModel.longitude

    RequestLocationPermission()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nama Almarhum") }
        )

        OutlinedTextField(
            value = date,
            onValueChange = { date = it },
            label = { Text("Tanggal Wafat") }
        )

        OutlinedTextField(
            value = block,
            onValueChange = { block = it },
            label = { Text("Blok Makam") }
        )

        Button(onClick = {
            viewModel.getLocation()
        }) {
            Text("📍 Ambil Lokasi GPS")
        }

        if (lat != null && lng != null) {
            Text("Lat: $lat")
            Text("Lng: $lng")
        }

        Button(
            onClick = {
                viewModel.saveGrave(name, date, block)
            },
            enabled = lat != null
        ) {
            Text("💾 Simpan Makam")
        }
    }
}
