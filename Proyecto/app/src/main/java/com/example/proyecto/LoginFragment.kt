package com.example.proyecto

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class LoginFragment: Fragment(R.layout.fragment_login) {

    private lateinit var buttonLogin: Button
    private lateinit var buttonNewAccount: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonLogin= view.findViewById(R.id.button_Login)
        buttonNewAccount= view.findViewById(R.id.button_NewAccount)

        setListeners()
    }

    private fun setListeners() {
        buttonLogin.setOnClickListener {
            val intent = Intent(this.activity, SecondActivity::class.java)
            startActivity(intent)
        }

        buttonNewAccount.setOnClickListener {
            requireView().findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToNewAccountFragment())
        }
    }
}