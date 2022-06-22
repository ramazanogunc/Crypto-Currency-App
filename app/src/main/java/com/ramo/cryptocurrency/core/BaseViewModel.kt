package com.ramo.cryptocurrency.core

import com.ramo.sweetsdk.SweetViewModel

abstract class BaseViewModel : SweetViewModel() {

    override fun handleSafeException(e: Exception) {
        when (e) {
            // TODO: hande custom exception
            else -> showError(e)
        }
    }

    protected suspend fun safeLiveData(
        loadingVisible: Boolean = true,
        customHandleException: ((Exception) -> Unit)? = null,
        block: suspend () -> Unit
    ) {
        if (loadingVisible) showLoading()
        try {
            block()
        } catch (e: Exception) {
            if (customHandleException != null)
                customHandleException.invoke(e)
            else
                handleSafeException(e)
        }
        if (loadingVisible) hideLoading()
    }
}