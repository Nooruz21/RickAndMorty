package com.example.rickandm.presentation.ui.fragment

import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandm.R
import com.example.rickandm.databinding.FragmentCharactersBinding
import com.example.rickandm.presentation.base.BaseFragment
import com.example.rickandm.presentation.ui.adapter.CharactersAdapter
import com.example.rickandm.presentation.ui.viewmodel.RickAndMortyViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.merge
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class CharactersFragment :
    BaseFragment<RickAndMortyViewModel, FragmentCharactersBinding>(R.layout.fragment_characters) {

    override val viewModel: RickAndMortyViewModel by sharedViewModel()
    override val binding by viewBinding(FragmentCharactersBinding::bind)
    private lateinit var adapter: CharactersAdapter


    override fun initialize() {
        setupRecyclerView()
        setupSearch()
        setupFilter()
    }

    private fun setupFilter() {
        binding.filter.setOnClickListener {
            val filter = SortFragment()
            filter.show((activity as AppCompatActivity).supportFragmentManager, "filter")
        }
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
        adapter = CharactersAdapter()
        binding.charactersRecycler.layoutManager = GridLayoutManager(context, 2)
        binding.charactersRecycler.adapter = adapter

        adapter.addLoadStateListener { loadStates ->
            binding.charactersRecycler.isVisible = loadStates.refresh is LoadState.NotLoading
        }
    }

    override fun setupRequests() {
        viewModel.characterPaging().collectPaging {
            adapter.submitData(it)
        }
    }

    override fun setupSubscribers() {
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
