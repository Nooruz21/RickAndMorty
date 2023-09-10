package com.example.rickandm.presentation.ui.models

import com.example.domain.model.Episode
import com.example.rickandm.presentation.base.IBaseDiffModel


data class EpisodeUI(
    override val id: Int,
    val name: String,
    val airDate: String,
    val episode: String,
    val characters: List<String>,
    val url: String,
    val created: String
) : IBaseDiffModel<Int>

fun Episode.toUI() = EpisodeUI(id, name, air_date, episode, characters, url, created)