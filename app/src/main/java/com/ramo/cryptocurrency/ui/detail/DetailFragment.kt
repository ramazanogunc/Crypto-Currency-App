package com.ramo.cryptocurrency.ui.detail

import android.os.Bundle
import android.view.View
import com.ramo.cryptocurrency.core.BaseFragment
import com.ramo.cryptocurrency.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentHomeBinding, DetailViewModel>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }

    private fun initUi() = withVB {

    }

    override fun initObservers() {

    }

}