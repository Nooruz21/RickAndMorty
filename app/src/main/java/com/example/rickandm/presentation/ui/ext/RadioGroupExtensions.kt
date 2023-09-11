package com.example.rickandm.presentation.ui.ext

import android.widget.RadioButton
import android.widget.RadioGroup

fun RadioGroup.setOnCheckedChangeListenerReturnsTheTextOfTheRadioButton(
    vararg radioButton: RadioButton,
    selectedRadioButton: (radioButtonText: String) -> Unit,
) {
    setOnCheckedChangeListener { _, checked ->
        for (button in radioButton) if (checked == button.id) {
            selectedRadioButton(button.text.toString())
        }
    }
}