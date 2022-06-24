package com.ramo.cryptocurrency.core

abstract class BaseUseCase<P, R> {
    abstract suspend fun execute(params: P): R
}