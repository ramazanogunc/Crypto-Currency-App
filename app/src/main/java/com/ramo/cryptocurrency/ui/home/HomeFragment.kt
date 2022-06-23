package com.ramo.cryptocurrency.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import com.ramo.cryptocurrency.core.BaseFragment
import com.ramo.cryptocurrency.core.BasicViewHolder
import com.ramo.cryptocurrency.core.ext.textChangeDelayedListener
import com.ramo.cryptocurrency.databinding.FragmentHomeBinding
import com.ramo.cryptocurrency.databinding.ItemCoinBinding
import com.ramo.cryptocurrency.domain.model.CoinItem
import com.ramo.sweetsdk.ext.gone
import com.ramo.sweetsdk.ext.observeExt
import com.ramo.sweetsdk.ext.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }

    @SuppressLint("SetTextI18n")
    private fun initUi() = withVB {
        etSearch.textChangeDelayedListener {
            viewModel.search(it)
        }
        srlList.setOnRefreshListener {
            etSearch.text = null
            activity?.window?.setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
            )
            rvList.requestFocus()
            viewModel.refreshList()
        }
        rvList.render { parent: ViewGroup, _: Int, _: CoinItem ->
            return@render BasicViewHolder<ItemCoinBinding, CoinItem>(
                inflater = ItemCoinBinding::inflate,
                viewGroup = parent
            ) { binding, data ->
                binding.txtName.text = "${data.symbol} - ${data.name}"
            }
        }
        rvList.setOnItemClickListener { _, _, data: CoinItem ->
            viewModel.navigate(
                HomeFragmentDirections.actionHomeFragmentToDetailFragment(
                    data.id
                )
            )
        }
    }

    override fun initObservers() {
        observeExt(viewModel.coinList) {
            binding.rvList.setData(it)
            withVB {
                if (it.isEmpty()) {
                    binding.rvList.gone()
                    binding.emptyLayout.emptyLayout.visible()
                } else {
                    binding.rvList.visible()
                    binding.emptyLayout.emptyLayout.gone()
                }
            }
        }
    }

    override fun onChangeLoading(isLoading: Boolean) {
        binding.srlList.isRefreshing = isLoading
    }
}