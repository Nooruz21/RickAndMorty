package com.example.domain.model



data class Character(
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
