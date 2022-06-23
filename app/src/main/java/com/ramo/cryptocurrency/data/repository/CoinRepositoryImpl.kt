package com.ramo.cryptocurrency.data.repository

import com.ramo.cryptocurrency.data.Repository
import com.ramo.cryptocurrency.data.local.dao.CoinDao
import com.ramo.cryptocurrency.data.remote.CoinService
import com.ramo.cryptocurrency.domain.model.CoinDetail
import com.ramo.cryptocurrency.domain.model.CoinItem
import com.ramo.cryptocurrency.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val coinService: CoinService,
    private val coinDao: CoinDao
) : Repository(), CoinRepository {

    override suspend fun getAllCoins(): List<CoinItem> {
        return exec {
            val response = coinService.coinList()
            val list = response.map { it.toCoinItem() }
            coinDao.insert(list)
            list
        }
    }

    override suspend fun search(query: String): List<CoinItem> {
        return exec {
            coinDao.search(query)
        }
    }

    override suspend fun getCoinInfo(coinId: String): CoinDetail {
        return exec {
            coinService.coinDetail(coinId).toCoinDetail()
        }
    }
}