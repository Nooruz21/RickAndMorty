package com.example.rickandm.data.pagingsource

import com.example.rickandm.data.base.BasePagingSource
import com.example.rickandm.data.model.LocationDto
import com.example.rickandm.data.remote.RickAndMortyService
import com.example.rickandm.domain.model.Location

class LocationPagingSource(
    private val service: RickAndMortyService,
    name: String?
) : BasePagingSource<LocationDto, Location>({
    service.getLocation(it, name)
})
