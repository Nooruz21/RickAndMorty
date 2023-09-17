package com.example.rickandm.presentation.ui.bottomsheet

import android.widget.RadioButton
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.data.local.preferences.PreferencesHelper
import com.example.domain.model.CharacterSort
import com.example.rickandm.R
import com.example.rickandm.databinding.FragmentSortBinding
import com.example.rickandm.presentation.base.BaseBottomSheetDialog
import com.example.rickandm.presentation.ui.ext.fragmentResult
import com.example.rickandm.presentation.ui.ext.setOnCheckedChangeListenerReturnsTheTextOfTheRadioButton
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SortFragment : BaseBottomSheetDialog<FragmentSortBinding>(R.layout.fragment_sort) {

    override val binding: FragmentSortBinding by viewBinding(FragmentSortBinding::bind)

    @Inject
    lateinit var preferencesHelper: PreferencesHelper

    private val characterFilter = CharacterSort()
    override fun setupListeners() = with(binding) {

        loadCheckedRadioButton(
            radioBtnAlive, radioBtnDead, radioBtnUnknownStatus,
            radioBtnHuman, radioBtnHumanoid, radioBtnAlien,
            radioBtnMale, radioBtnFemale, radioBtnUnknownGender
        )

        radioGroupStatus.setOnCheckedChangeListenerReturnsTheTextOfTheRadioButton(
            radioBtnAlive,
            radioBtnDead,
            radioBtnUnknownStatus
        ) { text ->
            characterFilter.status = text
            preferencesHelper.checkedRadioButtonStatus = text
        }

        radioGroupSpecies.setOnCheckedChangeListenerReturnsTheTextOfTheRadioButton(
            radioBtnHuman,
            radioBtnHumanoid,
            radioBtnAlien
        ) { text ->
            characterFilter.species = text
            preferencesHelper.checkedRadioButtonSpecies = text
        }

        radioGroupGender.setOnCheckedChangeListenerReturnsTheTextOfTheRadioButton(
            radioBtnMale,
            radioBtnFemale,
            radioBtnUnknownGender
        ) { text ->
            characterFilter.gender = text
            preferencesHelper.checkedRadioButtonGender = text
        }

        btnOk.setOnClickListener {
            findNavController().popBackStack()
        }
        btnReset.setOnClickListener {
            preferencesHelper.resetFilter()
            fragmentResult("filter", CharacterSort(null, null, null))
            findNavController().popBackStack()
        }
    }

    private fun loadCheckedRadioButton(vararg radioButton: RadioButton) {
        preferencesHelper.checkRadioButton.map { radioButtonText ->
            for (button in radioButton)
                if (button.text == radioButtonText) button.isChecked = true
        }
    }

}
