package com.example.data.model

import com.example.data.mapper.DataMapper
import com.example.domain.model.Episode

data class EpisodeDto(
    val air_date: String,
    val characters: List<String>,
    val created: String,
    val episode: String,
    val id: Int,
    val name: String,
    val url: String
) : DataMapper<Episode> {

    override fun mapToDomain() = Episode(air_date, characters, created, episode, id, name, url)
}