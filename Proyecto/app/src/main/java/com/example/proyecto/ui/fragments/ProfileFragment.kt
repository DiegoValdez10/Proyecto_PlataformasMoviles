package com.example.proyecto.ui.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.proyecto.R
import com.example.proyecto.ui.activity.MainActivity
import com.example.proyecto.ui.activity.SecondActivity

class ProfileFragment: Fragment(R.layout.fragment_profile) {

    private lateinit var buttonPremier: Button
    private lateinit var buttonLiga: Button
    private lateinit var buttonBundes: Button
    private lateinit var buttonSerieA: Button
    private lateinit var buttonLigue1: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonPremier = view.findViewById(R.id.buttonPremierLeague)
        buttonLiga = view.findViewById(R.id.buttonLaLiga)
        buttonBundes = view.findViewById(R.id.buttonBundesliga)
        buttonSerieA = view.findViewById(R.id.buttonSerieA)
        buttonLigue1 = view.findViewById(R.id.buttonLigue1)

        setListeners()

    }

    private fun setListeners() {
        buttonPremier.setOnClickListener {
            val link = "https://www.premierleague.com/tables"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(intent)
        }

        buttonLiga.setOnClickListener {
            val link = "https://www.laliga.com/laliga-santander/clasificacion"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(intent)
        }

        buttonBundes.setOnClickListener {
            val link = "https://www.legaseriea.it/en/serie-a/classifica"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(intent)
        }

        buttonSerieA.setOnClickListener {
            val link = "https://www.bundesliga.com/es/bundesliga/clasificacion"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(intent)
        }

        buttonLigue1.setOnClickListener {
            val link = "https://www.ligue1.com/ranking"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(intent)
        }
    }
}