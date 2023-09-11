package com.example.rickandm.presentation.ui.fragment.location

import android.widget.SearchView
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandm.R
import com.example.rickandm.databinding.FragmentLocationBinding
import com.example.rickandm.presentation.base.BaseFragment
import com.example.rickandm.presentation.ui.adapter.LocationAdapter
import com.example.rickandm.presentation.ui.adapter.paging.LoadStateAdapter

class LocationFragment :
    BaseFragment<LocationViewModel, FragmentLocationBinding>(R.layout.fragment_location) {

    override val viewModel: LocationViewModel by viewModels()
    override val binding by viewBinding(FragmentLocationBinding::bind)

    private val adapter = LocationAdapter()

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
        viewModel.fetchLocation(name = name).collectPaging {
            adapter.submitData(it)
        }
    }

    private fun setupRecyclerView() = with(binding) {
        recyclerview.layoutManager = LinearLayoutManager(context)
        recyclerview.adapter = adapter.withLoadStateFooter(
            footer = LoadStateAdapter { adapter.retry() })

        adapter.addLoadStateListener { loadStates ->
            recyclerview.isVisible = loadStates.refresh is LoadState.NotLoading
            binding.loader.isVisible = loadStates.refresh is LoadState.Loading
        }
    }

    override fun setupRequests() {
        fetchCharacter()
        setupSearch()
    }

    private fun fetchCharacter() {
        viewModel.fetchLocation().collectPaging { adapter.submitData(it) }
    }


}