package com.example.proyecto.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.example.proyecto.firebase.AuthRepository
import com.example.proyecto.firebase.AuthRepositoryImpl
import com.example.proyecto.firebase.FirebaseAuthApiImpl
import com.example.proyecto.R
import com.example.proyecto.ui.activity.SecondActivity
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginFragment: Fragment(R.layout.fragment_login) {

    private lateinit var buttonLogin: Button
    private lateinit var buttonNewAccount: Button
    private lateinit var authRepository: AuthRepository
    private lateinit var inputEmail: TextInputLayout
    private lateinit var inputPassword: TextInputLayout

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonLogin = view.findViewById(R.id.button_Login)
        buttonNewAccount = view.findViewById(R.id.button_NewAccount)
        inputEmail = view.findViewById(R.id.inputLayout_Email)
        inputPassword = view.findViewById(R.id.inputLayout_Password)

        authRepository = AuthRepositoryImpl(
            api = FirebaseAuthApiImpl()
        )

        setListeners()
    }

    private fun setListeners() {
        buttonLogin.setOnClickListener {
            val email = inputEmail.editText!!.text.toString()
            val password = inputPassword.editText!!.text.toString()

            lifecycleScope.launch {
                val id = authRepository.signInWithEmailAndPassword(email, password)
                if (!id.isNullOrEmpty()) {
                    Toast.makeText(
                        requireContext(),
                        "Bienvenido",
                        Toast.LENGTH_LONG
                    ).show()
                    Intent(requireContext(), SecondActivity::class.java).apply {
                        putExtras(bundleOf("id" to id))
                        startActivity(this)
                    }
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Usuario o contraseña incorrectos",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }

        buttonNewAccount.setOnClickListener {
            navigateToListScreen()
        }
    }

    private fun navigateToListScreen() {
        CoroutineScope(Dispatchers.Main).launch {
            requireView().findNavController().navigate(
                LoginFragmentDirections.actionLoginFragmentToNewAccountFragment()
            )
        }
    }

}