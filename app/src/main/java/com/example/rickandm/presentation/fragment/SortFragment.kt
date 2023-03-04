package com.example.rickandm.presentation.fragment

import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandm.R
import com.example.rickandm.databinding.FragmentSortBinding
import com.example.rickandm.domain.model.sortmodel.CharacterSort
import com.example.rickandm.presentation.base.BaseBottomSheetDialog
import com.example.rickandm.presentation.viewmodel.RickAndMortyViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class SortFragment : BaseBottomSheetDialog<FragmentSortBinding>(R.layout.fragment_sort) {
    private var currentFilter = CharacterSort()
    private val viewModel: RickAndMortyViewModel by sharedViewModel()
    override val binding by viewBinding<FragmentSortBinding>()

    override fun checkSort() {
        val checkedStatus = checkStatus()
        val checkedSpecies = checkSpecies()
        val checkedGender = checkGender()

        binding.rgStatus.check(checkedStatus ?: return)
        binding.rgSpecies.check(checkedSpecies ?: return)
        binding.rgGender.check(checkedGender ?: return)
    }

    override fun checkId() {
        requireDialog().apply {
            setCancelable(true)
            setCanceledOnTouchOutside(true)
        }
        binding.rgStatus.setOnCheckedChangeListener { _, checkedId ->
            currentFilter.status = when (checkedId) {
                R.id.status_alive -> "alive"
                R.id.status_dead -> "dead"
                R.id.status_unknown -> "unknown"
                else -> null
            }
        }
        binding.rgSpecies.setOnCheckedChangeListener { _, checkedId ->
            currentFilter.species = when (checkedId) {
                R.id.species_alien -> "alien"
                R.id.species_human -> "Human"
                R.id.species_humanoid -> "Humanoid"
                else -> null
            }
        }
        binding.rgGender.setOnCheckedChangeListener { _, checkedId ->
            currentFilter.gender = when (checkedId) {
                R.id.gender_male -> "Male"
                R.id.gender_female -> "Female"
                R.id.gender_unknown -> "unknown"
                else -> null
            }
        }
    }

    override fun initView() {
        binding.btnFilter.setOnClickListener {
            currentFilter.apply {
                viewModel.sort(status, species, gender)
            }
        }
        binding.btnClear.setOnClickListener {
            binding.rgGender.clearCheck()
            binding.rgStatus.clearCheck()
            binding.rgSpecies.clearCheck()
            currentFilter = CharacterSort()
        }
    }

    private fun checkSpecies(): Int? = when (currentFilter.species) {
        "alien" -> R.id.species_alien
        "Human" -> R.id.species_human
        "humanoid" -> R.id.species_humanoid
        else -> null
    }

    private fun checkStatus(): Int? = when (currentFilter.status) {
        "alive" -> R.id.status_alive
        "dead" -> R.id.status_dead
        "unknown" -> R.id.status_unknown
        else -> null

    }

    private fun checkGender(): Int? = when (currentFilter.gender) {
        "Male" -> R.id.gender_male
        "Female" -> R.id.gender_female
        "unknown" -> R.id.gender_unknown
        else -> null
    }
}
