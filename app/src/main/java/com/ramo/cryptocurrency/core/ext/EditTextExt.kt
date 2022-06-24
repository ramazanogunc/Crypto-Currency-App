package com.ramo.cryptocurrency.core.ext

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import com.google.android.material.textfield.TextInputLayout
import com.ramo.cryptocurrency.ui.common.EditTextState
import java.util.*

fun EditText.textChangeDelayedListener(delayTime: Long = 700L, textChange: (String) -> Unit) {
    addTextChangedListener(object : TextWatcher {
        private var timer = Timer()
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            timer.cancel()
        }

        override fun afterTextChanged(text: Editable?) {
            timer = Timer()
            timer.schedule(object : TimerTask() {
                override fun run() {
                    val query = text?.toString()
                    textChange.invoke(query ?: "")
                }
            }, delayTime)
        }
    })
}

fun TextInputLayout.setState(editTextState: EditTextState) {
    when (editTextState) {
        is EditTextState.Valid -> this.error = null
        is EditTextState.InValid -> this.error = context.getString(editTextState.messageId)
    }
}