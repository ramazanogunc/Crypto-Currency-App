package com.ramo.cryptocurrency.ui.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.liveData
import com.ramo.cryptocurrency.core.BaseViewModel
import com.ramo.cryptocurrency.domain.repository.CoinRepository
import dagger.assisted.Assisted
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val state: SavedStateHandle,
    private val coinRepository: CoinRepository
) : BaseViewModel() {

    val args: DetailFragmentArgs
        get() = DetailFragmentArgs.fromSavedStateHandle(state)

    val coin = liveData {
        safeSuspend {
            emit(coinRepository.getCoinInfo(args.coinId))
        }
    }

    init {
        getCoinPrice()
    }

    private fun getCoinPrice() {

    }
}