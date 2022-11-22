package com.example.proyecto.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.proyecto.R

class ListFragment: Fragment(R.layout.fragment_list) {

    private lateinit var buttonBarcelona: Button
    private lateinit var buttonRealMadrid: Button
    private lateinit var buttonArsenal: Button
    private lateinit var buttonManCity: Button
    private lateinit var buttonNapoli: Button
    private lateinit var buttonMilan: Button
    private lateinit var buttonBayern: Button
    private lateinit var buttonPSG: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonBarcelona = view.findViewById(R.id.buttonBarcelona)
        buttonRealMadrid = view.findViewById(R.id.buttonRealMadrid)
        buttonArsenal = view.findViewById(R.id.buttonArsenal)
        buttonManCity = view.findViewById(R.id.buttonManCity)
        buttonNapoli = view.findViewById(R.id.buttonNapoli)
        buttonMilan = view.findViewById(R.id.buttonMilan)
        buttonBayern = view.findViewById(R.id.buttonBayernM)
        buttonPSG = view.findViewById(R.id.buttonPSG)

        setListeners()
    }

    private fun setListeners() {
        buttonBarcelona.setOnClickListener {
            requireView().findNavController().navigate(
                ListFragmentDirections.actionListFragmentToFragmentBarcelona()
            )
        }

        buttonRealMadrid.setOnClickListener {
            requireView().findNavController().navigate(
                ListFragmentDirections.actionListFragmentToFragmentRealMadrid()
            )
        }

        buttonArsenal.setOnClickListener {
            requireView().findNavController().navigate(
                ListFragmentDirections.actionListFragmentToFragmentArsenal()
            )
        }

        buttonManCity.setOnClickListener {
            requireView().findNavController().navigate(
                ListFragmentDirections.actionListFragmentToFragmentManCity()
            )
        }

        buttonNapoli.setOnClickListener {
            requireView().findNavController().navigate(
                ListFragmentDirections.actionListFragmentToFragmentNapoli()
            )
        }

        buttonMilan.setOnClickListener {
            requireView().findNavController().navigate(
                ListFragmentDirections.actionListFragmentToFragmentMilan()
            )
        }

        buttonBayern.setOnClickListener {
            requireView().findNavController().navigate(
                ListFragmentDirections.actionListFragmentToFragmentBayern()
            )
        }

        buttonPSG.setOnClickListener {
            requireView().findNavController().navigate(
                ListFragmentDirections.actionListFragmentToFragmentPSG()
            )
        }
    }
}