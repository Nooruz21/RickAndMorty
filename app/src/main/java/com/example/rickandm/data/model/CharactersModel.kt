package com.example.rickandm.data.model

import com.example.rickandm.data.mapper.ModelMapper
import com.example.rickandm.domain.model.Character
import com.example.rickandm.domain.model.LocationC
import com.example.rickandm.domain.model.Origin
import com.example.rickandm.domain.model.Result

data class CharactersModel(
    val info: InfoDtoC,
    val results: List<ResultDto>
) : ModelMapper<Character> {
    override fun toDomain() = Character(
        info.toDomain(),
        results.map { it.toDomain() }
    )
}

data class InfoDtoC(
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
    val location: LocationDtoC,
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

data class LocationDtoC(
    val name: String,
    val url: String
) : ModelMapper<LocationC> {
    override fun toDomain() = LocationC(
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