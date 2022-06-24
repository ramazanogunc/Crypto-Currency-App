package com.ramo.cryptocurrency.data.repository

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObjects
import com.google.firebase.ktx.Firebase
import com.ramo.cryptocurrency.data.Repository
import com.ramo.cryptocurrency.data.local.dao.CoinDao
import com.ramo.cryptocurrency.data.remote.CoinService
import com.ramo.cryptocurrency.domain.model.CoinDetail
import com.ramo.cryptocurrency.domain.model.CoinItem
import com.ramo.cryptocurrency.domain.model.Prices
import com.ramo.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val coinService: CoinService,
    private val coinDao: CoinDao
) : Repository(), CoinRepository {

    override suspend fun getAllCoins(): List<CoinItem> {
        return exec {
            val response = coinService.coinList()
            val list = response.map { it.toCoinItem() }
            coinDao.insert(list)
            list
        }
    }

    override suspend fun getFavoriteCoins(userId: String): List<CoinDetail> {
        return exec {
            getFirestoreRef(userId).get().await().toObjects()
        }
    }

    override suspend fun searchInFavorite(query: String, userId: String): List<CoinItem> {
        return exec {
            getFirestoreRef(userId).whereGreaterThanOrEqualTo("name", query).get().await()
                .toObjects<CoinDetail>().map { it.toCoinItem() }
        }
    }

    override suspend fun search(query: String): List<CoinItem> {
        return exec {
            coinDao.search(query)
        }
    }

    override suspend fun getCoinInfo(coinId: String, currentUserId: String?): CoinDetail {
        return exec {
            val data = coinService.coinDetail(coinId).toCoinDetail()
            if (currentUserId != null)
                data.isFavorite =
                    getFirestoreRef(currentUserId).document(data.id).get().await().exists()
            data
        }
    }

    override fun getCoinPrice(coinId: String, perSeconds: Int): Flow<Prices> = flow {
        exec {
            while (true) {
                val prices = coinService.coinDetail(coinId).toCoinDetail().price
                emit(prices)
                delay(perSeconds * 1000L)
            }
        }
    }

    override suspend fun changeFavorite(
        isFavorite: Boolean,
        params: CoinDetail,
        currentUserId: String
    ) {
        exec {
            val refCol = getFirestoreRef(currentUserId)
            if (isFavorite)
                refCol.document(params.id).set(params).await()
            else
                refCol.document(params.id).delete().await()
        }
    }

    override suspend fun updateFirebase(params: CoinDetail, currentUserId: String) {
        exec {
            val refCol = getFirestoreRef(currentUserId)
            refCol.document(params.id).set(params).await()
        }
    }

    private fun getFirestoreRef(userId: String) =
        Firebase.firestore.document("favorites/$userId")
            .collection("coins")
}