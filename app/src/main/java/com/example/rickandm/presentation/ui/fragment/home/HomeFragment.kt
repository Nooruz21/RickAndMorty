package com.example.rickandm.presentation.ui.fragment.home

import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandm.R
import com.example.rickandm.databinding.FragmentHomeBinding
import com.example.rickandm.presentation.base.BaseFragmentWithoutViewModel
import com.example.rickandm.presentation.ui.adapter.HomeViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragmentWithoutViewModel<FragmentHomeBinding>(R.layout.fragment_home) {

    override val binding by viewBinding(FragmentHomeBinding::bind)

    override fun setupListeners() {
        binding.viewpager.adapter = HomeViewPagerAdapter(this)
        TabLayoutMediator(binding.tabLayout, binding.viewpager) { tab, pos ->
            when (pos) {
                0 -> tab.text = "character"
                1 -> tab.text = "location"
                2 -> tab.text = "episode"
            }
        }.attach()
    }
}
