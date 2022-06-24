package com.ramo.cryptocurrency.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.ramo.cryptocurrency.core.BaseViewModel
import com.ramo.cryptocurrency.domain.model.CoinDetail
import com.ramo.cryptocurrency.domain.model.Prices
import com.ramo.cryptocurrency.domain.repository.CoinRepository
import com.ramo.cryptocurrency.domain.usecase.AddFavoriteUseCase
import com.ramo.cryptocurrency.domain.usecase.RemoveFavoriteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val state: SavedStateHandle,
    private val coinRepository: CoinRepository,
    private val addFavoriteUseCase: AddFavoriteUseCase,
    private val removeFavoriteUseCase: RemoveFavoriteUseCase,
) : BaseViewModel() {

    val args: DetailFragmentArgs
        get() = DetailFragmentArgs.fromSavedStateHandle(state)

    private val _coin = MutableLiveData<CoinDetail>()
    val coin: LiveData<CoinDetail> get() = _coin


    private val _price = MutableLiveData<Prices>()
    val price: LiveData<Prices> get() = _price
    private var priceJob: Job? = null

    private val _refreshTime = MutableLiveData(5)
    val refreshTime: LiveData<Int> get() = _refreshTime

    init {
        safeScope {
            _coin.value = coinRepository.getCoinInfo(args.coinId)
        }
        getCoinPrice()
    }

    private fun getCoinPrice() {
        priceJob?.cancel()
        priceJob = viewModelScope.launch {
            safeSuspend(loadingVisible = false, customHandleException = {}) {
                coinRepository.getCoinPrice(args.coinId, _refreshTime.value!!).collectLatest {
                    _price.value = it
                }
            }
        }
    }

    fun changeRefreshTime(newTime: Int) {
        _refreshTime.value = newTime
        getCoinPrice()
    }

    fun changeFavorite() {
        val coin = coin.value ?: return
        val newFavoriteState = coin.isFavorite.not()
        val useCase = if (newFavoriteState) addFavoriteUseCase else removeFavoriteUseCase
        safeScope {
            useCase.execute(coin)
            _coin.value = coin.copy(isFavorite = newFavoriteState)
        }
    }
}