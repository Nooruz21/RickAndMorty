package com.example.rickandm.presentation.ui.activity

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.rickandm.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation_view)
        bottomNavigation.setupWithNavController(findNavController(R.id.nav_host_fragment))
    }
}