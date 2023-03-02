package com.example.rickandm.presentation.fragment

import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandm.R
import com.example.rickandm.databinding.FragmentFiltrBinding
import com.example.rickandm.domain.model.filtermodel.CharacterFilter
import com.example.rickandm.presentation.base.BaseAlertFragment
import com.example.rickandm.presentation.viewmodel.AllViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class FilterFragment : BaseAlertFragment<FragmentFiltrBinding>(R.layout.fragment_filtr) {
    private var currentFilter = CharacterFilter()
    private val viewModel: AllViewModel by sharedViewModel()
    override val binding by viewBinding<FragmentFiltrBinding>()


    override fun getCheckedFilter() {
        getCheckedStatus()?.let { binding.rgStatus.check(it) }
        getCheckedSpecies()?.let { binding.rgSpecies.check(it) }
        getCheckedGender()?.let { binding.rgGender.check(it) }
    }

    override fun filterCheckId() {
        requireDialog().setCancelable(true)
        requireDialog().setCanceledOnTouchOutside(true)
        binding.rgStatus.setOnCheckedChangeListener { group, checkedId ->
            currentFilter.status = when (checkedId) {
                R.id.status_alive -> "alive"
                R.id.status_dead -> "dead"
                R.id.status_unknown -> "unknown"
                else -> null
            }
        }
        binding.rgSpecies.setOnCheckedChangeListener { group, checkedId ->
            currentFilter.species = when (checkedId) {
                R.id.species_alien -> "alien"
                R.id.species_human -> "Human"
                R.id.species_humanoid -> "Humanoid"
                else -> null
            }
        }

        binding.rgGender.setOnCheckedChangeListener { group, checkedId ->
            currentFilter.gender = when (checkedId) {
                R.id.gender_male -> "Male"
                R.id.gender_female -> "Female"
                R.id.gender_unknown -> "unknown"
                else -> null
            }

        }
    }

    override fun initView() {
        binding.btnFiltr.setOnClickListener {
            currentFilter.apply {
                viewModel.filter(status, species, gender)
            }
        }
        binding.btnClear.setOnClickListener {
            binding.rgGender.clearCheck()
            binding.rgStatus.clearCheck()
            binding.rgSpecies.clearCheck()
            currentFilter.gender = null
            currentFilter.status = null
            currentFilter.species = null
        }
    }

    private fun getCheckedSpecies(): Int? {
        return when (currentFilter.species) {
            "alien" -> R.id.species_alien
            "Human" -> R.id.species_human
            "humanoid" -> R.id.species_humanoid
            else -> null
        }
    }

    private fun getCheckedStatus(): Int? {
        return when (currentFilter.status) {
            "alive" -> R.id.status_alive
            "dead" -> R.id.status_dead
            "unknown" -> R.id.status_unknown
            else -> null
        }
    }

    private fun getCheckedGender(): Int? {
        return when (currentFilter.gender) {
            "Male" -> R.id.gender_male
            "Female" -> R.id.gender_female
            "unknown" -> R.id.gender_unknown
            else -> null
        }
    }


}