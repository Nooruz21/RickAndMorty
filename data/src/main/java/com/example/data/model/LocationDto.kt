package com.example.data.model

import com.example.data.mapper.DataMapper
import com.example.domain.model.Location

data class LocationDto(
    val created: String,
    val dimension: String,
    val id: Int,
    val name: String,
    val residents: List<String>,
    val type: String,
    val url: String
) : DataMapper<Location> {
    override fun mapToDomain() = Location(created, dimension, id, name, residents, type, url)
}