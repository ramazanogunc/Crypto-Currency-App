package com.ramo.cryptocurrency.ui.auth.register

import android.os.Bundle
import android.text.Editable
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.navigation.fragment.findNavController
import com.ramo.cryptocurrency.core.BaseFragment
import com.ramo.cryptocurrency.core.ext.setState
import com.ramo.cryptocurrency.databinding.FragmentRegisterBinding
import com.ramo.sweetsdk.ext.observeExt
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : BaseFragment<FragmentRegisterBinding, RegisterViewModel>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }

    private fun initUi() = withVB {
        btnLogin.setOnClickListener {
            viewModel.register()
        }
        btnLogin.setOnClickListener {
            findNavController().navigate(
                RegisterFragmentDirections.actionGlobalLoginFragment()
            )
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

        observeExt(viewModel.isRegister) { isLogin ->
            if (isLogin)
                findNavController().navigate(
                    RegisterFragmentDirections.actionRegisterFragmentToHomeFragment()
                )
        }
    }
}