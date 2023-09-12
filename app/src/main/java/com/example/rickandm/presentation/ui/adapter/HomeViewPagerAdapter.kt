package com.example.rickandm.presentation.ui.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.rickandm.presentation.ui.fragment.character.CharactersFragment
import com.example.rickandm.presentation.ui.fragment.episode.EpisodeFragment
import com.example.rickandm.presentation.ui.fragment.location.LocationFragment


class HomeViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CharactersFragment()
            1 -> LocationFragment()
            else -> EpisodeFragment()
        }
    }
}