package com.ramo.cryptocurrency.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ramo.sweetrecycler.SweetDiff

@Entity(tableName = "coin_items")
data class CoinItem(
    @PrimaryKey
    @ColumnInfo(name = "id") var id: String,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "symbol") var symbol: String,

    ) : SweetDiff {
    override val diffId: String
        get() = id
}