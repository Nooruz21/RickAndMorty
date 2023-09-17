package com.example.data.remote.dto

import com.example.data.mapper.DataMapper
import com.example.domain.model.LocationC
import com.example.domain.model.Origin
import com.example.domain.model.Character

data class CharacterDto(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: LocationDtoC,
    val name: String,
    val origin: OriginDto,
    val species: String,
    val status: String,
    val type: String,
    val url: String
) : DataMapper<Character> {

    override fun mapToDomain() = Character(
        created,
        episode,
        gender,
        id,
        image,
        location.mapToDomain(),
        name,
        origin.mapToDomain(),
        species,
        status,
        type,
        url
    )
}

data class LocationDtoC(
    val name: String,
    val url: String
) : DataMapper<LocationC> {
    override fun mapToDomain() = LocationC(name, url)
}

data class OriginDto(
    val name: String,
    val url: String
) : DataMapper<Origin> {
    override fun mapToDomain() = Origin(name, url)

}