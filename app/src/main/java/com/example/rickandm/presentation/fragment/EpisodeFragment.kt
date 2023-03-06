package com.example.rickandm.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.SearchView
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandm.databinding.FragmentEpisodeBinding
import com.example.rickandm.presentation.adapter.EpisodeAdapter
import com.example.rickandm.presentation.base.BaseFragment
import com.example.rickandm.presentation.viewmodel.RickAndMortyViewModel
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class EpisodeFragment : BaseFragment<FragmentEpisodeBinding>() {
    private val viewModel: RickAndMortyViewModel by sharedViewModel()
    private lateinit var adapter: EpisodeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = EpisodeAdapter()
    }

    override fun inflate(layoutInflater: LayoutInflater): FragmentEpisodeBinding {
        return FragmentEpisodeBinding.inflate(layoutInflater)
    }

    override fun initView() {
        binding.episodeRecycler.layoutManager = LinearLayoutManager(context)
        binding.episodeRecycler.adapter = adapter

        adapter.addLoadStateListener { loadStates ->
            binding.episodeRecycler.isVisible = loadStates.refresh is LoadState.NotLoading
        }

        safeFlowGather {
            viewModel.observeEpisodePaging().collectPaging {
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
                }
                return false
            }
        })
    }

    override fun initListener() {
        safeFlowGather {
            viewModel.episodeSearch.collectLatest {
                viewModel.observeEpisodePaging().collectPaging {
                    adapter.submitData(it)
                }
            }
        }
    }
}