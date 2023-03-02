package com.example.rickandm.presentation.viewmodel

import com.example.rickandm.domain.usecase.CharactersUseCase
import com.example.rickandm.domain.usecase.EpisodeUseCase
import com.example.rickandm.domain.usecase.LocationUseCase
import com.example.rickandm.presentation.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AllViewModel(
    private val charactersUseCase: CharactersUseCase,
    private val episodeUseCase: EpisodeUseCase,
    private val locationUseCase: LocationUseCase
) : BaseViewModel() {

    private val _getAllCharactersSearch = MutableStateFlow<String?>(null)
    val getAllCharactersSearch = _getAllCharactersSearch.asStateFlow()

    private val _getAllLocationSearch = MutableStateFlow<String?>(null)
    val getAllLocationSearch = _getAllCharactersSearch.asStateFlow()

    private val _getAllEpisodeSearch = MutableStateFlow<String?>(null)
    val getAllEpisodeSearch = _getAllCharactersSearch.asStateFlow()

    private var _statusFilter = MutableStateFlow<String?>(null)
    val statusFilter = _statusFilter.asStateFlow()

    private val _speciesFilter = MutableStateFlow<String?>(null)
    private val _genderFilter = MutableStateFlow<String?>(null)

    val speciesFilter = _speciesFilter.asStateFlow()
    val genderFilter = _genderFilter.asStateFlow()


    fun getLocationPaging() =
        locationUseCase(_getAllLocationSearch.value).collectPagingRequest { it }

    fun getEpisodePaging() = episodeUseCase(_getAllEpisodeSearch.value).collectPagingRequest { it }


    fun getCharacterPaging(
        status: String? = null,
        gender: String? = null,
        species: String? = null
    ) = charactersUseCase(
        _getAllCharactersSearch.value,
        _statusFilter.value, _genderFilter.value, _speciesFilter.value
    ).collectPagingRequest { it }

    fun getCharacterSearchQuery(newQuery: String?) {
        _getAllCharactersSearch.value = newQuery
    }

    fun filter(status: String?, species: String?, gender: String?) {

        _statusFilter.value = status
        _speciesFilter.value = species
        _genderFilter.value = gender
    }


    fun getEpisodeSearchQuery(newQuery: String?) {
        _getAllEpisodeSearch.value = newQuery
    }

    fun getLocationSearchQuery(newQuery: String?) {
        _getAllLocationSearch.value = newQuery
    }

}