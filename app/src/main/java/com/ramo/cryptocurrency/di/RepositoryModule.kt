package com.ramo.cryptocurrency.di

import com.ramo.cryptocurrency.data.local.dao.CoinDao
import com.ramo.cryptocurrency.data.remote.CoinService
import com.ramo.cryptocurrency.data.repository.AuthRepositoryImpl
import com.ramo.cryptocurrency.data.repository.CoinRepositoryImpl
import com.ramo.cryptocurrency.domain.repository.AuthRepository
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
        coinService: CoinService,
        coinDao: CoinDao
    ): CoinRepository = CoinRepositoryImpl(coinService, coinDao)

    @Provides
    @Singleton
    fun provideAuthRepository(): AuthRepository = AuthRepositoryImpl()
}