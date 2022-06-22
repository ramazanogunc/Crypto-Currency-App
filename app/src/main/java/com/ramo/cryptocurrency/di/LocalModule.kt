package com.ramo.cryptocurrency.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.ramo.cryptocurrency.data.local.CoinDatabase
import com.ramo.cryptocurrency.data.local.dao.CoinDao
import com.ramo.cryptocurrency.data.remote.CoinService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton



@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    @Singleton
    fun provideCoinDb(
        @ApplicationContext context: Context
    ): CoinDatabase {
        return CoinDatabase.getDatabase(context)
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        coinDatabase: CoinDatabase
    ): CoinDao {
        return coinDatabase.coinDao
    }


}