package com.project.cemetery.feature.grave

import kotlinx.coroutines.flow.Flow

interface GraveRepository {
    suspend fun insert(grave: GraveEntity)
    fun getAll(): Flow<List<GraveEntity>>
}
