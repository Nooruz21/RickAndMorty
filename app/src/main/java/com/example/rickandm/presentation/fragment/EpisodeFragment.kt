package com.example.rickandm.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandm.databinding.FragmentEpisodeBinding
import com.example.rickandm.presentation.adapter.EpisodeAdapter
import com.example.rickandm.presentation.base.BaseFragment
import com.example.rickandm.presentation.viewmodel.AllViewModel
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class EpisodeFragment : BaseFragment<FragmentEpisodeBinding>() {
    private val viewModel: AllViewModel by sharedViewModel()
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
            viewModel.getEpisodePaging().collectPaging {
                adapter.submitData(it)
            }
        }
    }

    override fun initListener() {
        safeFlowGather {
            viewModel.getAllEpisodeSearch.collectLatest {
                viewModel.getEpisodePaging().collectPaging {
                    adapter.submitData(it)
                }
            }
        }
    }
}