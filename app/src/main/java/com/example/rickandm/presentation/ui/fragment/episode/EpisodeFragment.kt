package com.example.rickandm.presentation.ui.fragment.episode

import android.widget.SearchView
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandm.R
import com.example.rickandm.databinding.FragmentEpisodeBinding
import com.example.rickandm.presentation.base.BaseFragment
import com.example.rickandm.presentation.ui.adapter.EpisodeAdapter
import com.example.rickandm.presentation.ui.adapter.paging.LoadStateAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EpisodeFragment :
    BaseFragment<EpisodeViewModel, FragmentEpisodeBinding>(R.layout.fragment_episode) {

    override val viewModel: EpisodeViewModel by viewModels()
    override val binding by viewBinding(FragmentEpisodeBinding::bind)

    private val adapter = EpisodeAdapter()

    override fun initialize() {
        setupRecyclerView()
    }

    private fun setupSearch() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    fetchLocationSearchName(newText)

                } else fetchLocationSearchName("")
                return false
            }
        })
    }

    private fun fetchLocationSearchName(name: String) {
        viewModel.fetchEpisode(name = name).collectPaging {
            adapter.submitData(it)
        }
    }

    private fun setupRecyclerView() = with(binding){
        recyclerview.layoutManager = LinearLayoutManager(requireContext())
        recyclerview.adapter = adapter.withLoadStateFooter(
            footer = LoadStateAdapter { adapter.retry() })

        adapter.addLoadStateListener { loadStates ->
            recyclerview.isVisible = loadStates.refresh is LoadState.NotLoading
            binding.loader.isVisible = loadStates.refresh is LoadState.Loading
        }
    }

    override fun setupRequests() {
        fetchEpisode()
        setupSearch()
    }

    private fun fetchEpisode() {
        viewModel.fetchEpisode().collectPaging { adapter.submitData(it) }
    }

}