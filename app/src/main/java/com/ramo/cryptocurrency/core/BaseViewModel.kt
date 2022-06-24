package com.ramo.cryptocurrency.core

import com.ramo.cryptocurrency.domain.exception.LoginRequiredException
import com.ramo.cryptocurrency.ui.auth.login.LoginFragmentDirections
import com.ramo.sweetsdk.SweetViewModel

abstract class BaseViewModel : SweetViewModel() {

    override fun handleSafeException(e: Exception) {
        when (e) {
            is LoginRequiredException -> navigate(LoginFragmentDirections.actionGlobalLoginFragment())
            else -> showError(e)
        }
    }
}