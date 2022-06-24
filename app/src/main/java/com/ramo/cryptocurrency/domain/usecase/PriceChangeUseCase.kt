package com.ramo.cryptocurrency.domain.usecase

import com.ramo.cryptocurrency.core.BaseUseCase
import com.ramo.cryptocurrency.domain.model.PriceChange
import com.ramo.cryptocurrency.domain.repository.AuthRepository
import com.ramo.cryptocurrency.domain.repository.CoinRepository
import javax.inject.Inject

class PriceChangeUseCase @Inject constructor(
    private val authRepository: AuthRepository,
    private val coinRepository: CoinRepository
) : BaseUseCase<Any?, List<PriceChange>>() {

    override suspend fun execute(params: Any?): List<PriceChange> {
        val userId = authRepository.getCurrentUserId()
        val favoriteCoins = coinRepository.getFavoriteCoins(userId)
        if (favoriteCoins.isEmpty()) return listOf()
        val changeList = mutableListOf<PriceChange>()
        favoriteCoins.forEach { coinItem ->
            val response = coinRepository.getCoinInfo(coinItem.id, userId)
            val change = (((response.price.usd / coinItem.price.usd) - 1) * 100).toFloat()
            if (change > 1)
                changeList.add(PriceChange(response, change))
        }
        return changeList.toList()
    }
}