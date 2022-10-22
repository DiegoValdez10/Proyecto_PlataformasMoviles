package com.example.proyecto

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class NewAccountFragment: Fragment(R.layout.fragment_new_account) {

    private lateinit var buttonNewAccount: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonNewAccount= view.findViewById(R.id.button_Account)

        setListeners()
    }

    private fun setListeners() {
        buttonNewAccount.setOnClickListener {
            requireView().findNavController().navigate(NewAccountFragmentDirections.actionNewAccountFragmentToLoginFragment())
        }
    }
}