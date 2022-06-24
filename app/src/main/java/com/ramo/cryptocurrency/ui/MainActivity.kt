package com.ramo.cryptocurrency.ui

import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.ramo.cryptocurrency.R
import com.ramo.cryptocurrency.core.BaseActivity
import com.ramo.cryptocurrency.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initNavigation()
    }


    private fun initNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        val toolbar = binding.toolbar
        setSupportActionBar(binding.toolbar)
        toolbar.setupWithNavController(navController, appBarConfiguration)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id != R.id.homeFragment) {
                toolbar.setNavigationIcon(R.drawable.ic_round_arrow_back)
                toolbar.setNavigationIconTint(
                    ContextCompat.getColor(
                        this@MainActivity,
                        R.color.white
                    )
                )
            } else
                toolbar.navigationIcon = null

        }
        binding.bottomNav.setupWithNavController(navController)

/*
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.userAvatarFragment) {
                binding.bottomNav.gone()
            } else {
                binding.bottomNav.visible()
            }
        }
        */

    }
}