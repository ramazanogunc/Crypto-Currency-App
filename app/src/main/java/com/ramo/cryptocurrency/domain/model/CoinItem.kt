package com.ramo.cryptocurrency.domain.model

import com.ramo.sweetrecycler.SweetDiff

data class CoinItem(
    val id: String,
    val name: String,
    val symbol: String,
    override val diffId: String = id
) : SweetDiff