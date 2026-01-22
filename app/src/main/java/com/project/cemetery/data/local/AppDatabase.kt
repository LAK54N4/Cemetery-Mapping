package com.project.cemetery.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.project.cemetery.feature.grave.GraveDao
import com.project.cemetery.feature.grave.GraveEntity

@Database(entities = [GraveEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun graveDao(): GraveDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "cemetery.db"
                ).build().also { INSTANCE = it }
            }
    }
}
