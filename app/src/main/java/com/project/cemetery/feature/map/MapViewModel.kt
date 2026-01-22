package com.project.cemetery.feature.map

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.project.cemetery.data.local.AppDatabase
import com.project.cemetery.feature.grave.GraveEntity
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn


class MapViewModel(application: Application)
    : AndroidViewModel(application) {

    private val dao = AppDatabase
        .getInstance(application)
        .graveDao()

    val graves: StateFlow<List<GraveEntity>> =
        dao.getAll()
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5_000),
                emptyList()
            )
}
