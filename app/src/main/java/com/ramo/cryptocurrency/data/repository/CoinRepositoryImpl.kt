package com.ramo.cryptocurrency.data.repository

import android.util.Log
import com.ramo.cryptocurrency.data.Repository
import com.ramo.cryptocurrency.data.local.dao.CoinDao
import com.ramo.cryptocurrency.data.remote.CoinService
import com.ramo.cryptocurrency.domain.model.CoinDetail
import com.ramo.cryptocurrency.domain.model.CoinItem
import com.ramo.cryptocurrency.domain.model.Prices
import com.ramo.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
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

    override fun getCoinPrice(coinId: String, perSeconds: Int): Flow<Prices> = flow {
        exec {
            while (true) {
                val prices = coinService.coinDetail(coinId).toCoinDetail().price
                emit(prices)
                Log.d("TAG", "getCoinPrice: gönderildi")
                delay(perSeconds * 1000L)
            }
        }
    }
}