package com.example.bottomnav

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavHostController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        val navController = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment

        bottomNavigationView.setupWithNavController(navController.navController)

    }

    fun floatingAction(view: View) {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.adddFragment) as NavHostFragment
        val navController = navHostFragment.navController

        navController.navigate(R.id.addFragment)

    }
}