package com.example.rickandm.presentation.ui.fragment

import android.widget.RadioButton
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.data.PreferencesButton
import com.example.domain.model.CharacterSort
import com.example.rickandm.R
import com.example.rickandm.databinding.FragmentSortBinding
import com.example.rickandm.presentation.base.BaseBottomSheetDialog
import com.example.rickandm.presentation.ui.ext.fragmentResult
import com.example.rickandm.presentation.ui.ext.setOnCheckedChangeListenerReturnsTheTextOfTheRadioButton
import org.koin.android.ext.android.inject

class SortFragment : BaseBottomSheetDialog<FragmentSortBinding>(R.layout.fragment_sort) {
    override val binding by viewBinding<FragmentSortBinding>()
    private val sharedPreferences by inject<PreferencesButton>()
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
            sharedPreferences.checkedRadioButtonStatus = text
        }

        radioGroupSpecies.setOnCheckedChangeListenerReturnsTheTextOfTheRadioButton(
            radioBtnHuman,
            radioBtnHumanoid,
            radioBtnAlien
        ) { text ->
            characterFilter.species = text
            sharedPreferences.checkedRadioButtonSpecies = text
        }

        radioGroupGender.setOnCheckedChangeListenerReturnsTheTextOfTheRadioButton(
            radioBtnMale,
            radioBtnFemale,
            radioBtnUnknownGender
        ) { text ->
            characterFilter.gender = text
            sharedPreferences.checkedRadioButtonGender = text
        }

        btnOk.setOnClickListener {
            findNavController().popBackStack()
        }
        btnReset.setOnClickListener {
            sharedPreferences.resetFilter()
            fragmentResult("filter", CharacterSort(null, null, null))
            findNavController().popBackStack()
        }
    }

    private fun loadCheckedRadioButton(vararg radioButton: RadioButton) {
        sharedPreferences.checkRadioButton.map { radioButtonText ->
            for (button in radioButton)
                if (button.text == radioButtonText) button.isChecked = true
        }
    }

}
