package com.example.proyecto.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.example.proyecto.R
import com.example.proyecto.firebase.AuthRepository
import com.example.proyecto.firebase.AuthRepositoryImpl
import com.example.proyecto.firebase.FirebaseAuthApiImpl
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.launch

class NewAccountFragment: Fragment(R.layout.fragment_new_account) {

    private lateinit var buttonNewAccount: Button
    private lateinit var authRepository: AuthRepository
    private lateinit var inputEmail: TextInputLayout
    private lateinit var inputPassword: TextInputLayout

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        inputEmail = view.findViewById(R.id.inputTextLayout_Email)
        inputPassword = view.findViewById(R.id.inputTextLayout_Password)
        buttonNewAccount = view.findViewById(R.id.button_Account)


        authRepository = AuthRepositoryImpl(
            api = FirebaseAuthApiImpl()
        )

        setListeners()
    }

    private fun setListeners() {
        buttonNewAccount.setOnClickListener {
            val newEmail = inputEmail.editText!!.text.toString()
            val newPassword = inputPassword.editText!!.text.toString()

            lifecycleScope.launch {
                val user = authRepository.createUserWithEmailAndPassword(newEmail, newPassword)
                if (!user.isNullOrEmpty()) {
                    Toast.makeText(
                        requireContext(),
                        "Usuario registrado",
                        Toast.LENGTH_LONG
                    ).show()
                    requireView().findNavController()
                        .navigate(NewAccountFragmentDirections.actionNewAccountFragmentToLoginFragment())
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Error al registrar",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }
}
