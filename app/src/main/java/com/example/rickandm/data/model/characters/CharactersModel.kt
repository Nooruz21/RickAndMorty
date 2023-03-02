package com.example.rickandm.data.model.characters

import com.example.rickandm.data.mapper.ModelMapper
import com.example.rickandm.domain.model.charactermodel.*

data class CharactersModel(
    val info: InfoDto,
    val results: List<ResultDto>
) : ModelMapper<Character> {
    override fun toDomain() = Character(
        info.toDomain(),
        results.map { it.toDomain() }
    )
}

data class InfoDto(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: Any
) : ModelMapper<Info> {
    override fun toDomain() = Info(
        count,
        next, pages, prev
    )
}

data class ResultDto(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: LocationDto,
    val name: String,
    val origin: OriginDto,
    val species: String,
    val status: String,
    val type: String,
    val url: String
) : ModelMapper<Result> {

    override fun toDomain() = Result(
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

data class LocationDto(
    val name: String,
    val url: String
) : ModelMapper<Location> {
    override fun toDomain() = Location(
        name, url
    )
}

data class OriginDto(
    val name: String,
    val url: String
) : ModelMapper<Origin> {
    override fun toDomain() = Origin(
        name, url
    )
}