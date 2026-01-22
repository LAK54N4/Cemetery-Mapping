package com.project.cemetery.feature.grave

import kotlinx.coroutines.flow.Flow

class GraveRepositoryImpl(
    private val dao: GraveDao
) : GraveRepository {

    override suspend fun insert(grave: GraveEntity) {
        dao.insert(grave)
    }

    override fun getAll(): Flow<List<GraveEntity>> {
        return dao.getAll()
    }
}
