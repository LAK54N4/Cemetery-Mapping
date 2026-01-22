package com.project.cemetery.feature.grave.gravelist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun GraveListScreen(
    viewModel: GraveListViewModel = viewModel()
) {
    val graves by viewModel.graves.collectAsState()

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(graves) { grave ->
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(12.dp)
                ) {
                    Text(
                        text = grave.name,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text("Blok: ${grave.block}")
                    Text("Lat: ${grave.latitude}")
                    Text("Lng: ${grave.longitude}")
                }
            }
        }
    }
}
