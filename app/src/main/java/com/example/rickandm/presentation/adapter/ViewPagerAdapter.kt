package com.example.rickandm.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.rickandm.presentation.fragment.CharactersFragment
import com.example.rickandm.presentation.fragment.EpisodeFragment
import com.example.rickandm.presentation.fragment.LocationFragment


class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> CharactersFragment()
            1 -> EpisodeFragment()
            2 -> LocationFragment()
            else -> CharactersFragment()
        }
    }

    override fun getCount(): Int = 3

    override fun getPageTitle(position: Int): CharSequence {
        when (position) {
            0 -> return "Character"
            1 -> return "Episode"
            2 -> return "Location"
        }
        return ""
    }

}
