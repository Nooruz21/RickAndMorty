package com.example.rickandm.presentation.ui.fragment

import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandm.R
import com.example.rickandm.databinding.FragmentTablayoutBinding
import com.example.rickandm.presentation.base.BaseFragment
import com.example.rickandm.presentation.base.BaseFragmentWithoutViewModel
import com.example.rickandm.presentation.ui.adapter.ViewPagerAdapter
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class TabLayoutFragment : BaseFragmentWithoutViewModel<FragmentTablayoutBinding>(R.layout.fragment_tablayout) {
    override val binding by viewBinding( FragmentTablayoutBinding::bind)
    override fun initialize() {
        val viewPager = binding.viewPager
        viewPager.adapter = ViewPagerAdapter(requireActivity().supportFragmentManager)
    }

}