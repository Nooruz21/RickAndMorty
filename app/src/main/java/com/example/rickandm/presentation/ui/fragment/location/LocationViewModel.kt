package com.example.rickandm.presentation.ui.fragment.location

import com.example.domain.usecase.LocationUseCase
import com.example.rickandm.presentation.base.BaseViewModel
import com.example.rickandm.presentation.ui.models.toUI

class LocationViewModel (private val fetchLocationUseCase: LocationUseCase): BaseViewModel() {

    fun fetchLocation(name:String? = null) = fetchLocationUseCase(name).collectPagingRequest { it.toUI() }
}