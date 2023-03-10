package com.example.rickandm.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.SearchView
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandm.databinding.FragmentLocationBinding
import com.example.rickandm.presentation.adapter.LocationAdapter
import com.example.rickandm.presentation.base.BaseFragment
import com.example.rickandm.presentation.viewmodel.RickAndMortyViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class LocationFragment : BaseFragment<FragmentLocationBinding>() {
    private val viewModel: RickAndMortyViewModel by sharedViewModel()
    private lateinit var adapter: LocationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = LocationAdapter()
    }

    override fun inflate(layoutInflater: LayoutInflater): FragmentLocationBinding {
        return FragmentLocationBinding.inflate(layoutInflater)
    }

    override fun initListener() {
        binding.charactersRecycler.layoutManager = LinearLayoutManager(context)
        binding.charactersRecycler.adapter = adapter

        adapter.addLoadStateListener { loadStates ->
            binding.charactersRecycler.isVisible = loadStates.refresh is LoadState.NotLoading
        }

        lifecycleScope.launch {
            viewModel.observeLocationPaging().collectPaging {
                adapter.submitData(it)
            }
        }
    }

    override fun search() {
        super.search()
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

    override fun initView() {
        safeFlowGather {
            viewModel.locationSearch.collectLatest {
                viewModel.observeLocationPaging().collectPaging {
                    adapter.submitData(it)
                }
            }
        }

    }
}