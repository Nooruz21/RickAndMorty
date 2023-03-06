package com.example.rickandm.domain.model

import com.example.rickandm.data.model.Info

data class Character(
    val info: Info,
    val results: List<Result>
)

data class Info(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: Any
)

data class Result(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: LocationC,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)

data class LocationC(
    val name: String,
    val url: String
)

data class Origin(
    val name: String,
    val url: String
)
