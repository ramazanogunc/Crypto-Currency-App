package com.ramo.cryptocurrency.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.ramo.cryptocurrency.data.local.dao.base.BaseDao
import com.ramo.cryptocurrency.domain.model.CoinItem

@Dao
interface CoinDao : BaseDao<CoinItem> {

    @Query(
        """
        SELECT * FROM coin_items 
        WHERE name LIKE '%' || :query || '%' 
        OR  symbol LIKE '%' || :query || '%'
        """
    )
    suspend fun search(query: String): List<CoinItem>
}