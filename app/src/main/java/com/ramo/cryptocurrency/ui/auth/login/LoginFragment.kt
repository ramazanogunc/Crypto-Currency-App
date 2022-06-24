package com.ramo.cryptocurrency.ui.auth.login

import android.os.Bundle
import android.text.Editable
import android.view.View
import androidx.core.widget.doAfterTextChanged
import com.ramo.cryptocurrency.core.BaseFragment
import com.ramo.cryptocurrency.core.ext.setState
import com.ramo.cryptocurrency.databinding.FragmentLoginBinding
import com.ramo.sweetsdk.ext.observeExt
import com.ramo.sweetsdk.state.NavEvent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding, LoginViewModel>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }

    private fun initUi() = withVB {
        btnLogin.setOnClickListener {
            viewModel.login()
        }
        btnRegister.setOnClickListener {
            // TODO: go ro register page
        }
        etEMail.doAfterTextChanged { text: Editable? ->
            viewModel.email = text?.toString() ?: ""
        }
        etPassword.doAfterTextChanged { text: Editable? ->
            viewModel.password = text?.toString() ?: ""
        }
    }

    override fun initObservers() {
        observeExt(viewModel.etEmailState) {
            binding.tilEMail.setState(it)
        }
        observeExt(viewModel.etPasswordState) {
            binding.tilPassword.setState(it)
        }

        observeExt(viewModel.isLogin) { isLogin ->
            if (isLogin)
                onNavigate(NavEvent.Navigate(LoginFragmentDirections.actionLoginFragmentToHomeFragment()))
        }
    }
}