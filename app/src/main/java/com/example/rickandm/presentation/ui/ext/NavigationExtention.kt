package com.example.rickandm.presentation.ui.ext

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

fun <T> Fragment.fragmentResult(key: String, result: T?) {
    findNavController().previousBackStackEntry?.savedStateHandle?.set(key, result)
}

fun <T> Fragment.resultListener(key: String): T? {
    return findNavController().currentBackStackEntry?.savedStateHandle?.get<T>(key)
}