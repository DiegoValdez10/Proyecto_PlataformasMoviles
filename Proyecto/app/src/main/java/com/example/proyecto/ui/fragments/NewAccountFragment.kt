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
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch

class NewAccountFragment: Fragment(R.layout.fragment_new_account) {

    private lateinit var buttonNewAccount: Button
    private lateinit var authRepository: AuthRepository
    private lateinit var inputEmail: TextInputLayout
    private lateinit var inputPassword: TextInputLayout
    private lateinit var inputConfirmPassword: TextInputLayout

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        inputEmail = view.findViewById(R.id.inputTextLayout_Email)
        inputPassword = view.findViewById(R.id.inputTextLayout_Password)
        inputConfirmPassword = view.findViewById(R.id.inputTextLayout_ConfirmPassword)
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
            val confirmPassword = inputConfirmPassword.editText!!.text.toString()

            if(newEmail.isNotEmpty() && newPassword.isNotEmpty() && confirmPassword.isNotEmpty()) {
                if (newPassword == confirmPassword) {
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(newEmail, confirmPassword)
                        .addOnCompleteListener {
                            if (it.isSuccessful) {
                                Toast.makeText(
                                    requireContext(),
                                    "Usuario registrado",
                                    Toast.LENGTH_SHORT
                                ).show()
                                requireView().findNavController()
                                    .navigate(NewAccountFragmentDirections.actionNewAccountFragmentToLoginFragment())
                            } else {
                                Toast.makeText(
                                    requireContext(),
                                    "Error al registrar usuario",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Las contraseñas no coinciden",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }else{
                Toast.makeText(requireContext(), "Verifica tus datos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
