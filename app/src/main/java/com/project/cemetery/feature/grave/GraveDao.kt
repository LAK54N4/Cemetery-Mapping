package com.project.cemetery.feature.grave

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface GraveDao {

    @Insert
    suspend fun insert(grave: GraveEntity)

    @Query("SELECT * FROM graves")
    fun getAll(): Flow<List<GraveEntity>>
}