package com.ramo.cryptocurrency.domain.repository

import com.ramo.cryptocurrency.domain.model.CoinDetail
import com.ramo.cryptocurrency.domain.model.CoinItem
import com.ramo.cryptocurrency.domain.model.Prices
import kotlinx.coroutines.flow.Flow

interface CoinRepository {
    suspend fun getAllCoins(): List<CoinItem>
    suspend fun getFavoriteCoins(userId: String): List<CoinItem>
    suspend fun searchInFavorite(query: String, userId: String): List<CoinItem>
    suspend fun search(query: String): List<CoinItem>
    suspend fun getCoinInfo(coinId: String, currentUserId: String?): CoinDetail
    fun getCoinPrice(coinId: String, perSeconds: Int): Flow<Prices>
    suspend fun changeFavorite(isFavorite: Boolean, params: CoinDetail, currentUserId: String)
}