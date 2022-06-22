package com.ramo.cryptocurrency.data.remote

import com.ramo.cryptocurrency.data.remote.model.response.CoinListItemResponse
import retrofit2.http.GET

interface CoinService {

    @GET("coins/list")
    suspend fun coinList(): List<CoinListItemResponse>
}