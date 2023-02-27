package com.example.rickandm.presentation.fragment

import android.view.LayoutInflater
import android.widget.SearchView
import com.example.rickandm.presentation.base.BaseFragment
import com.example.rickandm.presentation.viewmodel.AllViewModel
import com.example.rickandm.presentation.adapter.ViewPagerAdapter
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import com.example.rickandm.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    private val viewModel: AllViewModel by sharedViewModel()
    override fun inflate(layoutInflater: LayoutInflater): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun initView() {
        val viewPager = binding.viewPager
        viewPager.adapter = ViewPagerAdapter(requireActivity().supportFragmentManager)

        binding.searchId.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String): Boolean {
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                p0.let {
                    if (it != null) {
                        viewModel.getCharacterSearchQuery(it)
                        viewModel.getEpisodeSearchQuery(it)
                        viewModel.getLocationSearchQuery(it)
                    }
                }
                return false
            }
        })
    }
}