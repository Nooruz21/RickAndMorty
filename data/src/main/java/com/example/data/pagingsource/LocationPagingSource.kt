package com.example.data.pagingsource

import com.example.data.base.BasePagingSource
import com.example.data.model.LocationDto
import com.example.data.remote.apiservice.LocationApiService
import com.example.domain.model.Location

class LocationPagingSource(
    private val service: LocationApiService,
    name: String?
) : BasePagingSource<LocationDto, Location>({
    service.fetchLocation(it, name)
})
