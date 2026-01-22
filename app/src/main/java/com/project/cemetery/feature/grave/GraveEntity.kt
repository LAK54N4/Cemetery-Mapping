package com.project.cemetery.feature.grave

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "graves")
data class GraveEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val dateOfDeath: String,
    val block: String,
    val latitude: Double,
    val longitude: Double
)