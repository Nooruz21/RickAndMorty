package com.example.rickandm.presentation.fragment

import android.view.LayoutInflater
import android.widget.SearchView
import com.example.rickandm.databinding.FragmentTablayoutBinding
import com.example.rickandm.presentation.adapter.ViewPagerAdapter
import com.example.rickandm.presentation.base.BaseFragment
import com.example.rickandm.presentation.viewmodel.RickAndMortyViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class TabLayoutFragment : BaseFragment<FragmentTablayoutBinding>() {
    private val viewModel: RickAndMortyViewModel by sharedViewModel()
    override fun inflate(layoutInflater: LayoutInflater): FragmentTablayoutBinding {
        return FragmentTablayoutBinding.inflate(layoutInflater)
    }

    override fun initView() {
        val viewPager = binding.viewPager
        viewPager.adapter = ViewPagerAdapter(requireActivity().supportFragmentManager)

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
}