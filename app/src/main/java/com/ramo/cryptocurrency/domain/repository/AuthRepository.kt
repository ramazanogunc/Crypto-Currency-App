package com.ramo.cryptocurrency.domain.repository

interface AuthRepository {
    suspend fun isLogin(): Boolean
    suspend fun login(email: String, password: String): Boolean
    suspend fun register(name: String, email: String, password: String): Boolean
    suspend fun getCurrentUserId(): String
    suspend fun logout()
}