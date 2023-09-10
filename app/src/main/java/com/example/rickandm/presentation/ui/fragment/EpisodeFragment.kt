package com.example.rickandm.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.SearchView
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandm.R
import com.example.rickandm.databinding.FragmentEpisodeBinding
import com.example.rickandm.presentation.adapter.EpisodeAdapter
import com.example.rickandm.presentation.base.BaseFragment
import com.example.rickandm.presentation.ui.adapter.EpisodeAdapter
import com.example.rickandm.presentation.ui.viewmodel.RickAndMortyViewModel
import com.example.rickandm.presentation.viewmodel.RickAndMortyViewModel
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class EpisodeFragment :
    BaseFragment<RickAndMortyViewModel, FragmentEpisodeBinding>(R.layout.fragment_episode) {
    override val viewModel: RickAndMortyViewModel by sharedViewModel()
    override val binding by viewBinding(FragmentEpisodeBinding::bind)
    private lateinit var adapter: EpisodeAdapter

    override fun initialize() {
        setupRecyclerView()
        setupSearch()
    }

    private fun setupSearch() {
        binding.searchId.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String): Boolean = false

            override fun onQueryTextChange(p0: String?): Boolean {
                p0?.let { query ->
                    viewModel.characterSearchQuery(query)
                    viewModel.episodeSearchQuery(query)
                }
                return false
            }
        })
    }

    private fun setupRecyclerView() {
        adapter = EpisodeAdapter()
        binding.episodeRecycler.layoutManager = LinearLayoutManager(context)
        binding.episodeRecycler.adapter = adapter

        adapter.addLoadStateListener { loadStates ->
            binding.episodeRecycler.isVisible = loadStates.refresh is LoadState.NotLoading
        }
    }

    override fun setupRequests() {
        safeFlowGather {
            viewModel.observeEpisodePaging().collectPaging {
                adapter.submitData(it)
            }
        }
    }

    override fun setupSubscribers() {
        safeFlowGather {
            viewModel.episodeSearch.collectLatest {
                viewModel.observeEpisodePaging().collectPaging {
                    adapter.submitData(it)
                }
            }
        }
    }
}