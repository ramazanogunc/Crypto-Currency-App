package com.ramo.cryptocurrency.domain.usecase

import com.ramo.cryptocurrency.core.BaseUseCase
import com.ramo.cryptocurrency.domain.exception.LoginRequiredException
import com.ramo.cryptocurrency.domain.model.CoinDetail
import com.ramo.cryptocurrency.domain.repository.AuthRepository
import com.ramo.cryptocurrency.domain.repository.CoinRepository
import javax.inject.Inject

class RemoveFavoriteUseCase @Inject constructor(
    private val authRepository: AuthRepository,
    private val coinRepository: CoinRepository
) : BaseUseCase<CoinDetail, Unit>() {

    override suspend fun execute(params: CoinDetail) {
        if (authRepository.isLogin().not()) throw LoginRequiredException()
        coinRepository.changeFavorite(false, params, authRepository.getCurrentUserId())
    }
}