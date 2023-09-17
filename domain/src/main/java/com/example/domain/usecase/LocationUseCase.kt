package com.example.domain.usecase

import com.example.domain.repository.LocationRepository
import javax.inject.Inject

class LocationUseCase @Inject constructor(
    private val repository: LocationRepository
) {
    operator fun invoke(name: String?) = repository.fetchLocation(name)
}