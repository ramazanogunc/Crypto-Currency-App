package com.ramo.cryptocurrency.domain.model

data class CoinDetail(
    var id: String = "",
    var name: String = "",
    var symbol: String = "",
    var price: Prices = Prices(),
    var description: String = "",
    var imageUrl: String = "",
    var hashingAlgorithm: String = "",
    var changeLast24h: Double = 0.0,
    var isFavorite: Boolean = false,
) {

    fun toCoinItem() = CoinItem(
        id = id,
        name = name,
        symbol = symbol
    )
}

data class Prices(
    var turkishLira: Double = 0.0,
    var usd: Double = 0.0,
    var euro: Double = 0.0
)
