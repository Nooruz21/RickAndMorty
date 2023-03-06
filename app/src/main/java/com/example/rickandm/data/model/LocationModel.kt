package com.example.rickandm.data.model

import com.example.rickandm.data.mapper.ModelMapper
import com.example.rickandm.domain.model.InfoLocation
import com.example.rickandm.domain.model.Location

data class LocationModel(
    val info: InfoL,
    val results: List<LocationDto>
)

data class InfoL(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: Any
)


data class LocationDto(
    val created: String,
    val dimension: String,
    val id: Int,
    val name: String,
    val residents: List<String>,
    val type: String,
    val url: String
) : ModelMapper<Location> {
    override fun toDomain() = Location(
        created, dimension, id, name, residents, type, url
    )
}