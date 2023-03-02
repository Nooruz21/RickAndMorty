package com.example.rickandm.presentation.base

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.viewbinding.ViewBinding
import com.example.rickandm.R

abstract class BaseDialogFragment<VB : ViewBinding>(
    @LayoutRes private val layoutId: Int
) : AppCompatDialogFragment() {

    protected abstract val binding: VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog?.apply {
            setCancelable(false)
            setCanceledOnTouchOutside(false)
            requestWindowFeature(Window.FEATURE_ACTION_BAR)
            window?.setBackgroundDrawable(ColorDrawable(Color.WHITE))
        }
        return inflater.inflate(R.layout.fragment_sort, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        checkId()
        checkSort()
    }

    abstract fun checkSort()
    abstract fun checkId()
    abstract fun initView()
}