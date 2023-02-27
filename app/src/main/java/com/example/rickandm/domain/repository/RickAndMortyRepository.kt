package com.example.rickandm.domain.repository

import androidx.paging.PagingData
import com.example.rickandm.domain.model.charactermodel.Result
import com.example.rickandm.domain.model.episodemodel.Episode
import com.example.rickandm.domain.model.locationmodel.Location
import com.example.rickandm.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface RickAndMortyRepository {
   fun getAllCharacters(name:String?,status:String?,gender:String?,species:String?): Flow<PagingData<Result>>
   fun getAllCharacter(name:String?,status:String?,gender:String?,species:String?): Flow<Resource<List<Result>>>
   fun getAllEpisode(name:String?): Flow<PagingData<Episode>>
   fun getAllLocation(name:String?): Flow<PagingData<Location>>


}