package com.example.rickandm.data.model.characters

import com.example.rickandm.data.mapper.DataMapper
import com.example.rickandm.domain.model.charactermodel.Info
import com.example.rickandm.domain.model.charactermodel.Location
import com.example.rickandm.domain.model.charactermodel.Character
import com.example.rickandm.domain.model.charactermodel.Origin
import com.example.rickandm.domain.model.charactermodel.Result

data class CharactersModelDto(
    val info: InfoDto,
    val results: List<ResultDto>
) : DataMapper<Character> {
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
) : DataMapper<Info> {
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
) : DataMapper<Result> {

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
) : DataMapper<Location> {
    override fun toDomain() = Location(
        name, url
    )
}

data class OriginDto(
    val name: String,
    val url: String
) : DataMapper<Origin> {
    override fun toDomain() = Origin(
        name, url
    )
}