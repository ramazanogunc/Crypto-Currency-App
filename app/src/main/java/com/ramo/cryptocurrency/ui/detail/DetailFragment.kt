package com.ramo.cryptocurrency.ui.detail

import android.os.Bundle
import android.view.View
import com.ramo.cryptocurrency.R
import com.ramo.cryptocurrency.core.BaseFragment
import com.ramo.cryptocurrency.core.ext.loadImage
import com.ramo.cryptocurrency.core.ext.toCurrencyString
import com.ramo.cryptocurrency.core.ext.toFormattedText
import com.ramo.cryptocurrency.databinding.FragmentDetailBinding
import com.ramo.cryptocurrency.ui.select.SelectBottomSheet
import com.ramo.sweetsdk.ext.gone
import com.ramo.sweetsdk.ext.observeExt
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding, DetailViewModel>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }

    private fun initUi() = withVB {
        btnChange.setOnClickListener {
            SelectBottomSheet.newInstance(
                title = context?.getString(R.string.fragment_detail_select_second) ?: "",
                list = (1..60).map { it.toString() },
                onSelect = { selected ->
                    if (isAdded.not()) return@newInstance
                    viewModel.changeRefreshTime(selected.toInt())
                }
            ).show(childFragmentManager, null)
        }
        imgFavorite.setOnClickListener {
            viewModel.changeFavorite()
        }
    }

    override fun initObservers() {
        observeExt(viewModel.price) { price ->
            withVB {
                txtPriceUsd.text =
                    price.usd.toCurrencyString(Currency.getInstance("USD"))
                txtPriceEuro.text =
                    price.euro.toCurrencyString(Currency.getInstance("EUR"))
                txtPriceTry.text =
                    price.turkishLira.toCurrencyString(Currency.getInstance("TRY"))
                txtLastUpdated.text = getString(
                    R.string.fragment_detail_last_update,
                    Date().toFormattedText("HH:mm:ss")
                )
            }
        }
        observeExt(viewModel.coin) { coin ->
            toolbarTitle = coin.name
            withVB {
                if (coin.imageUrl.isBlank()) imgLogo.gone() else imgLogo.loadImage(coin.imageUrl)
                txtDescription.text =
                    coin.description.ifBlank { getString(R.string.no_description) }
                txtHashingAlgorithm.text = getString(
                    R.string.fragment_detail_hashing_algorithm,
                    coin.hashingAlgorithm.ifBlank { getString(R.string.no_info) }
                )
                txtPriceChangePercentage.text = getString(
                    R.string.fragment_detail_price_change_percentage,
                    coin.changeLast24h
                )
                imgFavorite.setImageResource(
                    if (coin.isFavorite)
                        R.drawable.ic_round_favorite
                    else
                        R.drawable.ic_round_favorite_border
                )
            }
        }
        observeExt(viewModel.refreshTime) {
            binding.txtRefreshTime.text = getString(R.string.fragment_detail_refresh_time, it)
        }
    }

}