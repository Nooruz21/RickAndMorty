package com.example.data.local.preferences

import android.content.Context
import android.content.SharedPreferences
import com.example.data.local.preferences.PreferencesConst.SAVE_GENDER_BTN
import com.example.data.local.preferences.PreferencesConst.SAVE_SPECIES_BTN
import com.example.data.local.preferences.PreferencesConst.SAVE_STATUS_BTN

class PreferencesHelper(context: Context) {

    private val preferences: SharedPreferences =
        context.getSharedPreferences("rick.preferences", Context.MODE_PRIVATE)

    private fun remove(key: String) {
        preferences.edit().remove(key).apply()
    }
    val checkRadioButton =
        arrayListOf(checkedRadioButtonStatus, checkedRadioButtonSpecies, checkedRadioButtonGender)

    var checkedRadioButtonStatus: String?
        get() = preferences.getString(SAVE_STATUS_BTN, "")
        set(value) = preferences.edit().putString(SAVE_STATUS_BTN, value).apply()

    var checkedRadioButtonSpecies: String?
        get() = preferences.getString(SAVE_SPECIES_BTN, "")
        set(value) = preferences.edit().putString(SAVE_SPECIES_BTN, value).apply()

    var checkedRadioButtonGender: String?
        get() = preferences.getString(SAVE_GENDER_BTN, "")
        set(value) = preferences.edit().putString(SAVE_GENDER_BTN, value).apply()

    fun resetFilter() {
        checkedRadioButtonStatus = ""
        checkedRadioButtonSpecies = ""
        checkedRadioButtonGender = ""
    }

}