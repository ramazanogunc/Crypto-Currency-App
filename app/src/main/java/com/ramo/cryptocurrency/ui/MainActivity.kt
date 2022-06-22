package com.ramo.cryptocurrency.ui

import android.os.Bundle
import com.ramo.cryptocurrency.core.BaseActivity
import com.ramo.cryptocurrency.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}