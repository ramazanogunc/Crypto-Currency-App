package com.ramo.cryptocurrency.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ramo.cryptocurrency.core.BaseViewModel
import com.ramo.cryptocurrency.domain.model.CoinItem
import com.ramo.cryptocurrency.domain.repository.AuthRepository
import com.ramo.cryptocurrency.domain.repository.CoinRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val coinRepository: CoinRepository,
    private val authRepository: AuthRepository,
) : BaseViewModel() {


    private val _coinList = MutableLiveData<List<CoinItem>>()
    val coinList: LiveData<List<CoinItem>> get() = _coinList
    private var _searchJob: Job? = null

    fun getList() {
        safeScope {
            val userId: String = authRepository.getCurrentUserId()
            _coinList.value = coinRepository.getFavoriteCoins(userId)
        }
    }

    fun search(query: String) {
        if (query.isBlank().not() && query.length < 2) return
        _searchJob?.cancel()
        _searchJob = viewModelScope.launch {
            safeSuspend(customHandleException = {}) {
                val userId: String = authRepository.getCurrentUserId()
                _coinList.value = coinRepository.searchInFavorite(query, userId)
            }
        }
    }

}