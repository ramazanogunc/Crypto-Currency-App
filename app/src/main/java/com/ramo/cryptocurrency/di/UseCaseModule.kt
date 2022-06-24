package com.ramo.cryptocurrency.di

import com.ramo.cryptocurrency.domain.repository.AuthRepository
import com.ramo.cryptocurrency.domain.repository.CoinRepository
import com.ramo.cryptocurrency.domain.usecase.AddFavoriteUseCase
import com.ramo.cryptocurrency.domain.usecase.PriceChangeUseCase
import com.ramo.cryptocurrency.domain.usecase.RemoveFavoriteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun provideAddFavoriteUseCase(
        coinRepository: CoinRepository,
        authRepository: AuthRepository
    ): AddFavoriteUseCase = AddFavoriteUseCase(authRepository, coinRepository)

    @Provides
    @Singleton
    fun provideRemoveFavoriteUseCase(
        coinRepository: CoinRepository,
        authRepository: AuthRepository
    ): RemoveFavoriteUseCase = RemoveFavoriteUseCase(authRepository, coinRepository)

    @Provides
    @Singleton
    fun providePriceChangeUseCase(
        coinRepository: CoinRepository,
        authRepository: AuthRepository
    ): PriceChangeUseCase = PriceChangeUseCase(authRepository, coinRepository)

}