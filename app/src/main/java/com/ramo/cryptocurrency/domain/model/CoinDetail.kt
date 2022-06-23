package com.ramo.cryptocurrency.domain.model

data class CoinDetail(
    val id: String,
    val name: String,
    val symbol: String,
    val price: Prices,
    val description: String?,
    val imageUrl: String,
)

data class Prices(
    var turkishLira: Double = 0.0,
    var usd: Double = 0.0,
    var euro: Double = 0.0
)
