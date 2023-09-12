package com.example.rickandm.presentation.ui.fragment.character

import android.widget.SearchView
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.domain.model.CharacterSort
import com.example.rickandm.R
import com.example.rickandm.databinding.FragmentCharactersBinding
import com.example.rickandm.presentation.base.BaseFragment
import com.example.rickandm.presentation.ui.adapter.CharactersAdapter
import com.example.rickandm.presentation.ui.adapter.paging.LoadStateAdapter
import com.example.rickandm.presentation.ui.ext.resultListener

class CharactersFragment :
    BaseFragment<CharacterViewModel, FragmentCharactersBinding>(R.layout.fragment_characters) {

    override val viewModel: CharacterViewModel by viewModels()
    override val binding by viewBinding(FragmentCharactersBinding::bind)

    private val adapter = CharactersAdapter()


    override fun initialize() {
        setupRecyclerView()
        setupFilter()
    }

    private fun setupFilter() {
        binding.btnFilterDialog.setOnClickListener {
            findNavController().navigate(R.id.filterFragment)
        }
    }

    private fun setupSearch() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
               newText.let {
                   viewModel.setCharacterName(newText)
               }
                return false
            }
        })
    }

    private fun setupRecyclerView() = with(binding) {
        recyclerview.layoutManager = LinearLayoutManager(context)
        recyclerview.adapter = adapter.withLoadStateFooter(
            footer = LoadStateAdapter { adapter.retry() }
        )

        adapter.addLoadStateListener { loadStates ->
            recyclerview.isVisible = loadStates.refresh is LoadState.NotLoading
            binding.loader.isVisible = loadStates.refresh is LoadState.Loading
        }
    }

    override fun setupRequests() {
        fetchCharacter()
        setupSearch()
    }

    override fun setupListeners() {
        resultListener()
    }

    private fun fetchCharacter() {
        viewModel.fetchCharacter().collectPaging { adapter.submitData(it) }
    }


    private fun resultListener() {
        val filter = resultListener<CharacterSort>("filter")
        filter?.let { viewModel.setCharacterFilters(it) }
    }
}
