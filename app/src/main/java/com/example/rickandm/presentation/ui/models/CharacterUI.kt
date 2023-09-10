package com.example.rickandm.presentation.ui.models

import com.example.domain.model.Character
import com.example.domain.model.LocationC
import com.example.domain.model.Origin
import com.example.rickandm.presentation.base.IBaseDiffModel


data class CharacterUI(
    override val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: Origin,
    val location: LocationC,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String,
) : IBaseDiffModel<Int>


fun Character.toUI() = CharacterUI(
    id, name, status, species, type, gender, origin, location, image, episode, url, created
)