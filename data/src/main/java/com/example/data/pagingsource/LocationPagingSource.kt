package com.example.data.pagingsource

import com.example.data.base.BasePagingSource
import com.example.data.model.LocationDto
import com.example.data.remote.RickAndMortyService
import com.example.domain.model.Location

class LocationPagingSource(
    private val service: RickAndMortyService,
    name: String?
) : BasePagingSource<LocationDto, Location>({
    service.getLocation(it, name)
})
