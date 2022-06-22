package com.ramo.cryptocurrency.ui.home

import androidx.lifecycle.liveData
import com.ramo.cryptocurrency.core.BaseViewModel
import com.ramo.cryptocurrency.domain.repository.CoinRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val coinRepository: CoinRepository
) : BaseViewModel() {

    val coinList = liveData {
        safeLiveData {
            emit(coinRepository.getAllCoins())
        }
    }
}