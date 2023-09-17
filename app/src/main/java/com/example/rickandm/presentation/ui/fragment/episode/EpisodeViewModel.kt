package com.example.rickandm.presentation.ui.fragment.episode

import com.example.domain.usecase.EpisodeUseCase
import com.example.rickandm.presentation.base.BaseViewModel
import com.example.rickandm.presentation.ui.models.toUI
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EpisodeViewModel @Inject constructor(
    private val fetchEpisodeUseCase: EpisodeUseCase
):BaseViewModel() {
    fun fetchEpisode(name:String? = null) = fetchEpisodeUseCase(name).collectPagingRequest { it.toUI() }
}