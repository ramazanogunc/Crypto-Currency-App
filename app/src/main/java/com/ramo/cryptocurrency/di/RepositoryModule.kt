package com.ramo.cryptocurrency.di

import com.ramo.cryptocurrency.data.remote.CoinService
import com.ramo.cryptocurrency.data.repository.CoinRepositoryImpl
import com.ramo.cryptocurrency.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideCoinRepository(
        coinService: CoinService
    ): CoinRepository = CoinRepositoryImpl(coinService)
}