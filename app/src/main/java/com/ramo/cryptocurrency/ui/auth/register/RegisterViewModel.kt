package com.ramo.cryptocurrency.ui.auth.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ramo.cryptocurrency.R
import com.ramo.cryptocurrency.core.BaseViewModel
import com.ramo.cryptocurrency.domain.repository.AuthRepository
import com.ramo.cryptocurrency.ui.common.EditTextState
import com.ramo.sweetsdk.lifecycle.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : BaseViewModel() {

    private val _isRegister = SingleLiveEvent<Boolean>()
    val isRegister: LiveData<Boolean> get() = _isRegister

    private val _etEmailState = MutableLiveData<EditTextState>()
    val etEmailState: LiveData<EditTextState> get() = _etEmailState

    private val _etPasswordState = MutableLiveData<EditTextState>()
    val etPasswordState: LiveData<EditTextState> get() = _etPasswordState

    var email: String = ""
    var password: String = ""

    private val isValidEverything: Boolean
        get() {
            if (etEmailState.value is EditTextState.InValid)
                return false
            if (etEmailState.value is EditTextState.InValid)
                return false
            return true
        }

    fun register() {
        _etEmailState.value = if (email.isBlank()) EditTextState.InValid(R.string.cannot_empty)
        else EditTextState.Valid
        _etPasswordState.value = if (password.isBlank())
            EditTextState.InValid(R.string.cannot_empty)
        else
            EditTextState.Valid
        if (isValidEverything.not()) return
        safeScope(
            customHandleException = {
                showError(exception = it, cancelable = true)
            }
        ) {
            _isRegister.value = authRepository.login(email, password)
        }
    }
}