package com.example.domain.repository

import com.example.domain.model.Character
import com.example.domain.model.Episode
import com.example.domain.model.Location
import com.example.domain.utils.RemotePagingWrapper

interface RickAndMortyRepository {
    fun getCharacters(
        name: String?,
        status: String?,
        gender: String?,
        species: String?
    ): RemotePagingWrapper<Character>

    fun getEpisode(name: String?): RemotePagingWrapper<Episode>
    fun getLocation(name: String?): RemotePagingWrapper<Location>


}