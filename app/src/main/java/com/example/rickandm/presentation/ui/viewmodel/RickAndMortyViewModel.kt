package com.example.rickandm.presentation.ui.viewmodel

import com.example.domain.usecase.CharactersUseCase
import com.example.domain.usecase.EpisodeUseCase
import com.example.domain.usecase.LocationUseCase
import com.example.rickandm.presentation.base.BaseViewModel
import com.example.rickandm.presentation.ui.models.toUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class RickAndMortyViewModel(
    private val charactersUseCase: CharactersUseCase,
    private val episodeUseCase: EpisodeUseCase,
    private val locationUseCase: LocationUseCase
) : BaseViewModel() {

    private val _charactersSearch = MutableStateFlow<String?>(null)
    val charactersSearch = _charactersSearch.asStateFlow()


    private val _locationSearch = MutableStateFlow<String?>(null)
    val locationSearch = _charactersSearch.asStateFlow()

    private val _episodeSearch = MutableStateFlow<String?>(null)
    val episodeSearch = _charactersSearch.asStateFlow()

    private var _statusSort = MutableStateFlow<String?>(null)
    val statusFilter = _statusSort.asStateFlow()

    private val _speciesSort = MutableStateFlow<String?>(null)
    private val _genderSort = MutableStateFlow<String?>(null)

    val speciesSort = _speciesSort.asStateFlow()
    val genderSort = _genderSort.asStateFlow()


    fun observeLocationPaging() = locationUseCase(_locationSearch.value).collectPagingRequest { it.toUI() }

    fun observeEpisodePaging() = episodeUseCase(_episodeSearch.value).collectPagingRequest { it.toUI() }


    fun characterPaging(
        status: String? = null,
        gender: String? = null,
        species: String? = null
    ) = charactersUseCase(
        _charactersSearch.value,
        _statusSort.value,
        _genderSort.value,
        _speciesSort.value
    ).collectPagingRequest { it.toUI() }

    fun sort(status: String?, species: String?, gender: String?) {
        _statusSort.value = status
        _speciesSort.value = species
        _genderSort.value = gender
    }

    fun characterSearchQuery(character: String?) = run { _charactersSearch.value = character }

    fun episodeSearchQuery(episode: String?) = run { _episodeSearch.value = episode }

    fun locationSearchQuery(location: String?) = run { _locationSearch.value = location }

}