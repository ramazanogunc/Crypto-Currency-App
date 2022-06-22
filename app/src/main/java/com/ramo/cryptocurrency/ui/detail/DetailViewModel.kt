package com.ramo.cryptocurrency.ui.detail

import com.ramo.cryptocurrency.core.BaseViewModel
import com.ramo.cryptocurrency.domain.repository.CoinRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val coinRepository: CoinRepository
) : BaseViewModel() {
}