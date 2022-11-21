package com.example.proyecto.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.proyecto.*
import com.example.proyecto.ui.fragments.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class SecondActivity : AppCompatActivity() {

    private lateinit var navigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        navigation = findViewById(R.id.NavigationBottom)
        navigation.setOnNavigationItemSelectedListener{item->
            when(item.itemId){
                R.id.page_Home -> setFragment(HomeFragment())
                R.id.page_Search -> setFragment(SearchFragment())
                R.id.page_Fav -> setFragment(FavoriteFragment())
                R.id.page_Profile -> setFragment(ProfileFragment())
                else -> setFragment(HomeFragment())

            }
            true
        }
    }

    private fun setFragment(fragment: Fragment) {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.fragmentContainerView,fragment)
        }
    }
}