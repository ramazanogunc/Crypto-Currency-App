package com.ramo.cryptocurrency.ui.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ramo.cryptocurrency.core.BaseFragment
import com.ramo.cryptocurrency.databinding.FragmentDetailBinding
import com.ramo.sweetsdk.ext.observeExt
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding, DetailViewModel>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }

    private fun initUi() = withVB {

    }

    override fun initObservers() {
        observeExt(viewModel.coin) { coin ->
            toolbarTitle = coin.name
        }
    }

}