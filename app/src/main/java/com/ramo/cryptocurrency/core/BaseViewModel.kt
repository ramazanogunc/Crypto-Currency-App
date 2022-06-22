package com.ramo.cryptocurrency.core

import com.ramo.sweetsdk.SweetViewModel

abstract class BaseViewModel : SweetViewModel() {

    override fun handleSafeException(e: Exception) {
        when (e) {
            else -> showError(e)
        }
    }
}