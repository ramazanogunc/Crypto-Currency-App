package com.ramo.cryptocurrency.data.repository

import com.ramo.cryptocurrency.data.Repository
import com.ramo.cryptocurrency.data.remote.CoinService
import com.ramo.cryptocurrency.domain.model.CoinItem
import com.ramo.cryptocurrency.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val coinService: CoinService
) : Repository(), CoinRepository {

    override suspend fun getAllCoins(): List<CoinItem> {
        return exec {
            val response = coinService.coinList()
            response.map { it.toCoinItem() }
        }
    }
}