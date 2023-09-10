package com.example.rickandm.presentation.ui.models

import com.example.domain.model.Location
import com.example.rickandm.presentation.base.IBaseDiffModel


data class LocationUI(
    override val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: List<String>,
    val url: String,
    val created: String
): IBaseDiffModel<Int>

fun Location.toUI()= LocationUI(id,name,type,dimension,residents, url, created)