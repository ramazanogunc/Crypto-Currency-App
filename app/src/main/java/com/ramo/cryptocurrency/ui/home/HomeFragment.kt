package com.ramo.cryptocurrency.ui.home

import android.os.Bundle
import android.view.View
import com.ramo.cryptocurrency.core.BaseFragment
import com.ramo.cryptocurrency.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}