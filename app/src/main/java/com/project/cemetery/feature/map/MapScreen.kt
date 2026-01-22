package com.project.cemetery.feature.map

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.viewmodel.compose.viewModel
import com.project.cemetery.util.offsetGeoPoint
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker


@Composable
fun MapScreen(
    viewModel: MapViewModel = viewModel()
) {
    val context = LocalContext.current
    val graves by viewModel.graves.collectAsState()

    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = {
            MapView(context).apply {
                setTileSource(TileSourceFactory.MAPNIK)
                setMultiTouchControls(true)

                controller.setZoom(17.0)

                // Default posisi (jika DB kosong)
                controller.setCenter(
                    GeoPoint(-7.8591242, 110.166195)
                )
            }
        },
        update = { mapView ->

            mapView.overlays.clear()

            // set marker per 80 cm
            graves.forEachIndexed { index, grave ->

                val point = offsetGeoPoint(
                    grave.latitude,
                    grave.longitude,
                    index
                )

                val marker = Marker(mapView).apply {
                    position = point
                    title = grave.name
                    subDescription = "Blok: ${grave.block}"
                    setAnchor(
                        Marker.ANCHOR_CENTER,
                        Marker.ANCHOR_BOTTOM
                    )
                }

                mapView.overlays.add(marker)
            }

            /* original
            graves.forEach { grave ->
                val marker = Marker(mapView)
                marker.position = GeoPoint(
                    grave.latitude,
                    grave.longitude
                )
                marker.title = grave.name
                marker.subDescription = "Blok: ${grave.block}"
                marker.setAnchor(
                    Marker.ANCHOR_CENTER,
                    Marker.ANCHOR_BOTTOM
                )
                mapView.overlays.add(marker)
            }

             */

            // Fokus ke makam terakhir
            graves.lastOrNull()?.let {
                mapView.controller.animateTo(
                    GeoPoint(it.latitude, it.longitude)
                )
            }

            mapView.invalidate()
        }
    )
}
