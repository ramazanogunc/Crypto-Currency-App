package com.ramo.cryptocurrency.domain.model

data class PriceChange(
    val coinDetail: CoinDetail,
    var changePercentRange: Float,
)
