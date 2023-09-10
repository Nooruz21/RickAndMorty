package com.example.data.model

import com.example.data.mapper.DataMapper
import com.example.domain.model.Episode

data class EpisodeDto(
    val id: Int,
    val name: String,
    val air_date: String,
    val episode: String,
    val characters: List<String>,
    val created: String,
    val url: String
) : DataMapper<Episode> {

    override fun mapToDomain() = Episode(id, name, air_date, episode, characters, created, url)
}