package com.example.data.repository

import com.example.data.base.BaseDataRepository
import com.example.data.remote.pagingsource.LocationPagingSource
import com.example.data.remote.apiservice.LocationApiService
import com.example.domain.repository.LocationRepository

class LocationRepositoryImpl(private val service: LocationApiService) :
    BaseDataRepository(), LocationRepository {
    override fun fetchLocation(name: String?) = doPagingRequest(LocationPagingSource(service, name))
}