package com.ramo.cryptocurrency.data


abstract class Repository {

    protected suspend fun <T> exec(func: suspend () -> T): T {
        return try {
            func.invoke()
        } catch (exception: Exception) {
            throw exception
        }
    }

}
