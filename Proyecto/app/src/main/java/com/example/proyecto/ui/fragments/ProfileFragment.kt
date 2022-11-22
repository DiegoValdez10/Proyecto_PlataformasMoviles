package com.example.proyecto.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.proyecto.R
import com.example.proyecto.ui.activity.MainActivity
import com.example.proyecto.ui.activity.SecondActivity

class ProfileFragment: Fragment(R.layout.fragment_profile) {
    private lateinit var button: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button = view.findViewById(R.id.buttonOut)

        setListeners()
    }

    private fun setListeners() {
        button.setOnClickListener {
            Intent(requireContext(), MainActivity::class.java).apply {
                putExtras(bundleOf("id" to id))
                startActivity(this)
            }
        }
    }

}