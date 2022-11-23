package com.example.proyecto.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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
                R.id.page_Home -> setFragment(ListFragment())
                R.id.page_Search -> setFragment(NewsFragment())
                R.id.page_List -> setFragment(HomeFragment())
                R.id.page_Fav -> setFragment(ProfileFragment())

                else -> setFragment(ListFragment())
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
