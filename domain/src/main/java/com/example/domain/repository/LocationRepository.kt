package com.example.domain.repository

import com.example.domain.model.Location
import com.example.domain.utils.RemotePagingWrapper

interface LocationRepository {
    fun fetchLocation(name: String?): RemotePagingWrapper<Location>
}