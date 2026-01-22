package com.project.cemetery.feature.grave.gravelist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.project.cemetery.data.local.AppDatabase
import com.project.cemetery.feature.grave.GraveEntity
import com.project.cemetery.feature.grave.GraveRepositoryImpl
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class GraveListViewModel(application: Application) :
    AndroidViewModel(application) {

    private val dao = AppDatabase
        .getInstance(application)
        .graveDao()

    private val repository = GraveRepositoryImpl(dao)

    val graves: StateFlow<List<GraveEntity>> =
        repository.getAll()
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5000),
                emptyList()
            )
}
