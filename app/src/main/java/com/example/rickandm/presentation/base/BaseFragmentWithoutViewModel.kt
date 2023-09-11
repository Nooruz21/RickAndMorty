package com.example.rickandm.presentation.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragmentWithoutViewModel<Binding : ViewBinding>(
    @LayoutRes layoutId: Int,
) : Fragment(layoutId) {

    protected abstract val binding: Binding

    final override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListeners()
        setupRequests()
        setupSubscribers()
    }

    protected open fun setupSubscribers() {}

    protected open fun setupRequests() {}

    protected open fun setupListeners() {}

    protected open fun initialize() {}
}