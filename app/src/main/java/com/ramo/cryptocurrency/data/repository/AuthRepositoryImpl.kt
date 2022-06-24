package com.ramo.cryptocurrency.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.ramo.cryptocurrency.data.Repository
import com.ramo.cryptocurrency.domain.exception.LoginRequiredException
import com.ramo.cryptocurrency.domain.repository.AuthRepository
import kotlinx.coroutines.tasks.await

class AuthRepositoryImpl : Repository(), AuthRepository {

    private val mAuth = FirebaseAuth.getInstance()

    override suspend fun isLogin(): Boolean = mAuth.currentUser != null

    override suspend fun login(email: String, password: String): Boolean {
        return exec {
            val user = mAuth.signInWithEmailAndPassword(email, password).await()
            user != null
        }
    }

    override suspend fun register(email: String, password: String): Boolean {
        return exec {
            mAuth.createUserWithEmailAndPassword(email, password).await()
            true
        }
    }

    override suspend fun getCurrentUserId(): String {
        return mAuth.currentUser?.uid ?: throw LoginRequiredException()
    }

    override suspend fun logout() {
        return exec {
            mAuth.signOut()
        }
    }
}