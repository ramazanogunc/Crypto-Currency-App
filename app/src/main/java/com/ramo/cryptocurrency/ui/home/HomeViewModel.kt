package com.ramo.cryptocurrency.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ramo.cryptocurrency.core.BaseViewModel
import com.ramo.cryptocurrency.domain.model.CoinItem
import com.ramo.cryptocurrency.domain.repository.CoinRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val coinRepository: CoinRepository
) : BaseViewModel() {

    private val _coinList = MutableLiveData<List<CoinItem>>()
    val coinList: LiveData<List<CoinItem>> get() = _coinList


    private var _searchJob: Job? = null

    init {
        getList()
    }


    private fun getList() {
        safeScope {
            _coinList.value = coinRepository.getAllCoins()
        }
    }


    fun refreshList() {
        getList()
    }

    fun search(query: String) {
        if (query.length < 2) return
        _searchJob?.cancel()
        _searchJob = viewModelScope.launch {
            safeSuspend {
                _coinList.value = coinRepository.search(query)
            }
        }
    }
}