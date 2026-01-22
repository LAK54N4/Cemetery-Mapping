package com.project.cemetery.util

import org.osmdroid.util.GeoPoint

fun offsetGeoPoint(
    lat: Double,
    lon: Double,
    index: Int,
    spacingMeter: Double = 0.8
): GeoPoint {

    val meterToDegree = spacingMeter / 111_320.0

    val row = index / 10
    val col = index % 5

    return GeoPoint(
        lat + (row * meterToDegree),
        lon + (col * meterToDegree)
    )
}
