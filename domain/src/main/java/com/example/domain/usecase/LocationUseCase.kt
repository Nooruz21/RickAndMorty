package com.example.domain.usecase

import com.example.domain.repository.LocationRepository

class LocationUseCase(private val repository: LocationRepository) {
    operator fun invoke(name: String?) = repository.fetchLocation(name)
}