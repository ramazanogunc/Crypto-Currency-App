package com.ramo.cryptocurrency.ui.detail

import android.util.Log
import androidx.lifecycle.*
import com.ramo.cryptocurrency.core.BaseViewModel
import com.ramo.cryptocurrency.domain.model.Prices
import com.ramo.cryptocurrency.domain.repository.CoinRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
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

    private val _price = MutableLiveData<Prices>()
    val price: LiveData<Prices> get() = _price
    private var priceJob: Job? = null

    private val _refreshTime = MutableLiveData<Int>(1)
    val refreshTime: LiveData<Int> get() = _refreshTime

    init {
        getCoinPrice()
    }

    fun getCoinPrice() {
        priceJob?.cancel()
        priceJob = viewModelScope.launch {
            safeSuspend(loadingVisible = false) {
                coinRepository.getCoinPrice(args.coinId, _refreshTime.value!!).collectLatest {
                    _price.value = it
                    Log.d("TAG", "getCoinPrice: yakalandı")
                }
            }
        }
    }
}