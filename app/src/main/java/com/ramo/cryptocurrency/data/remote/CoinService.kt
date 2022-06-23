package com.ramo.cryptocurrency.data.remote

import com.ramo.cryptocurrency.data.remote.model.response.CoinDetailResponse
import com.ramo.cryptocurrency.data.remote.model.response.CoinListItemResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinService {

    @GET("coins/list")
    suspend fun coinList(): List<CoinListItemResponse>

    @GET("coins/{coinId}")
    suspend fun coinDetail(@Path("coinId") coinId: String): CoinDetailResponse
}