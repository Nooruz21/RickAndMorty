package com.example.rickandm.domain.model.charactermodel

import com.example.rickandm.data.mapper.ModelMapper
import com.example.rickandm.data.model.characters.*

data class Character(
    val info: Info,
    val results: List<Result>
) : ModelMapper<CharactersModel> {
    override fun toDomain() = CharactersModel(
        info.toDomain(),
        results.map { it.toDomain() }

    )
}

data class Info(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: Any
) : ModelMapper<InfoDto> {
    override fun toDomain() = InfoDto(
        count, next, pages, prev
    )
}

data class Result(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
) : ModelMapper<ResultDto> {

    override fun toDomain() = ResultDto(
        created,
        episode,
        gender,
        id,
        image,
        location.toDomain(),
        name,
        origin.toDomain(),
        species,
        status,
        type,
        url
    )
}

data class Location(
    val name: String,
    val url: String
) : ModelMapper<LocationDto> {
    override fun toDomain() = LocationDto(
        name, url
    )
}

data class Origin(
    val name: String,
    val url: String
) : ModelMapper<OriginDto> {
    override fun toDomain() = OriginDto(
        name, url
    )
}