package com.ramo.cryptocurrency.domain.repository

import com.ramo.cryptocurrency.domain.model.CoinItem

interface CoinRepository {
    suspend fun getAllCoins(): List<CoinItem>
    suspend fun search(query: String): List<CoinItem>
}