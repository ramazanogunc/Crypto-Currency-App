package com.ramo.cryptocurrency.ui.common

import androidx.annotation.StringRes

sealed class EditTextState {
    object Valid : EditTextState()
    data class InValid(@StringRes val messageId: Int) : EditTextState()
}
