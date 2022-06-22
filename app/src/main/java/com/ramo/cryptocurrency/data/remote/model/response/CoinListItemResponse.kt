package com.ramo.cryptocurrency.data.remote.model.response

import com.google.gson.annotations.SerializedName
import com.ramo.cryptocurrency.domain.model.CoinItem

data class CoinListItemResponse(

    @field:SerializedName("symbol")
    val symbol: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("id")
    val id: String? = null
) {
    fun toCoinItem() = CoinItem(
        id = id ?: "",
        name = name ?: "",
        symbol = symbol ?: ""
    )
}
