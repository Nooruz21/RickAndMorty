package com.example.rickandm.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandm.databinding.FragmentCharactersBinding
import com.example.rickandm.presentation.adapter.CharactersAdapter
import com.example.rickandm.presentation.base.BaseFragment
import com.example.rickandm.presentation.viewmodel.RickAndMortyViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.merge
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class CharactersFragment : BaseFragment<FragmentCharactersBinding>() {

    private val viewModel: RickAndMortyViewModel by sharedViewModel()

    private lateinit var adapter: CharactersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = CharactersAdapter()
    }

    override fun inflate(layoutInflater: LayoutInflater): FragmentCharactersBinding {
        return FragmentCharactersBinding.inflate(layoutInflater)
    }

    override fun initListener() {
        binding.charactersRecycler.layoutManager = LinearLayoutManager(context)
        binding.charactersRecycler.adapter = adapter

        adapter.addLoadStateListener { loadStates ->
            binding.charactersRecycler.isVisible = loadStates.refresh is LoadState.NotLoading
        }

        viewModel.characterPaging().collectPaging {
            adapter.submitData(it)
        }
    }

    override fun initView() {
        binding.filter.setOnClickListener {
            val filter = SortFragment()
            filter.show((activity as AppCompatActivity).supportFragmentManager, "filter")
        }

        safeFlowGather {
            merge(
                viewModel.charactersSearch,
                viewModel.statusFilter,
                viewModel.genderSort,
                viewModel.speciesSort
            ).collectLatest {
                viewModel.characterPaging().collectPaging {
                    binding.charactersRecycler.adapter = adapter
                    adapter.submitData(it)
                }
            }
        }
    }


}
