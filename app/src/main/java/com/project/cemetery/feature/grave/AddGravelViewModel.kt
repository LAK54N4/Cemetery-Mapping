package com.project.cemetery.feature.grave

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.project.cemetery.data.local.AppDatabase
import com.project.cemetery.util.LocationHelper
import kotlinx.coroutines.launch

class AddGraveViewModel(application: Application) :
    AndroidViewModel(application) {

    private val db = AppDatabase.getInstance(application)
    private val dao = db.graveDao()

    private val repository = GraveRepositoryImpl(dao)
    private val locationHelper = LocationHelper(application)

    var latitude by mutableStateOf<Double?>(null)
    var longitude by mutableStateOf<Double?>(null)

    fun getLocation() {
        locationHelper.getCurrentLocation {
            latitude = it?.latitude
            longitude = it?.longitude
        }
    }

    fun saveGrave(
        name: String,
        date: String,
        block: String
    ) {
        if (latitude == null || longitude == null) return

        viewModelScope.launch {
            repository.insert(
                GraveEntity(
                    name = name,
                    dateOfDeath = date,
                    block = block,
                    latitude = latitude!!,
                    longitude = longitude!!
                )
            )
        }
        /*
        viewModelScope.launch {
            dao.insert(
                GraveEntity(
                    name = name,
                    dateOfDeath = date,
                    block = block,
                    latitude = latitude!!,
                    longitude = longitude!!
                )
            )
        }

         */
    }
}
