package com.example.rickandm.presentation.ui.fragment

import android.widget.SearchView
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandm.R
import com.example.rickandm.databinding.FragmentLocationBinding
import com.example.rickandm.presentation.base.BaseFragment
import com.example.rickandm.presentation.ui.adapter.LocationAdapter
import com.example.rickandm.presentation.ui.viewmodel.RickAndMortyViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class LocationFragment :
    BaseFragment<RickAndMortyViewModel, FragmentLocationBinding>(R.layout.fragment_location) {

    override val viewModel: RickAndMortyViewModel by sharedViewModel()
    override val binding by viewBinding(FragmentLocationBinding::bind)

    private lateinit var adapter: LocationAdapter

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
                    viewModel.locationSearchQuery(query)
                }
                return false
            }
        })
    }

    private fun setupRecyclerView() {
        adapter = LocationAdapter()
        binding.charactersRecycler.layoutManager = LinearLayoutManager(context)
        binding.charactersRecycler.adapter = adapter

        adapter.addLoadStateListener { loadStates ->
            binding.charactersRecycler.isVisible = loadStates.refresh is LoadState.NotLoading
        }
    }

    override fun setupRequests() {
        lifecycleScope.launch {
            viewModel.observeLocationPaging().collectPaging {
                adapter.submitData(it)
            }
        }
    }

    override fun setupSubscribers() {
        safeFlowGather {
            viewModel.locationSearch.collectLatest {
                viewModel.observeLocationPaging().collectPaging {
                    adapter.submitData(it)
                }
            }
        }
    }

}