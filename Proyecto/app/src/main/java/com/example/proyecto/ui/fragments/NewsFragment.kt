package com.example.proyecto.ui.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.proyecto.R
import com.google.android.material.textfield.TextInputLayout

class NewsFragment: Fragment(R.layout.fragment_news_fragment) {
    private lateinit var buttonNews: Button
    private lateinit var buttonNews2: Button
    private lateinit var buttonNews3: Button
    private lateinit var buttonNews4: Button
    private lateinit var buttonNews5: Button
    private lateinit var buttonNews6: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonNews = view.findViewById(R.id.buttonNews1)
        buttonNews2 = view.findViewById(R.id.buttonNews2)
        buttonNews3 = view.findViewById(R.id.buttonNews3)
        buttonNews4 = view.findViewById(R.id.buttonNews4)
        buttonNews5 = view.findViewById(R.id.buttonNews5)
        buttonNews6 = view.findViewById(R.id.buttonNews6)

        setListeners()
    }

    private fun setListeners() {
        buttonNews.setOnClickListener {
            val link = "https://www.sport.es/es/noticias/apuestas-deportivas/mejor-arranque-liga-134-anos-77941213#:~:text=El%20Arsenal%20de%20Mikel%20Arteta,en%2012%20jornadas%20de%20Liga."
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(intent)
        }

        buttonNews2.setOnClickListener {
            val link = "https://www.sport.es/es/noticias/mundial-futbol/les-jugadores-barca-participan-mundial-78854630"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(intent)
        }

        buttonNews3.setOnClickListener {
            val link = "https://elpais.com/deportes/2022-11-12/el-brentford-da-la-sorpresa-ante-el-manchester-city-y-el-arsenal-se-ira-lider-de-la-premier-al-paron-por-el-mundial.html#:~:text=El%20Brentford%2C%20con%20el%20espa%C3%B1ol,arreglar%20esta%20vez%20la%20tarde."
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(intent)
        }

        buttonNews4.setOnClickListener {
            val link = "https://www.marca.com/futbol/liga-francesa/2022/10/28/635b8ced22601d19728b4595.html"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(intent)
        }

        buttonNews5.setOnClickListener {
            val link = "https://www.marca.com/futbol/real-madrid/2022/11/14/636fdeb8e2704e13678b4598.html"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(intent)
        }

        buttonNews6.setOnClickListener {
            val link = "https://www.latimes.com/espanol/deportes/articulo/2022-10-29/puntero-napoli-golea-a-sassuolo-4-0-en-serie-a-italiana"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(intent)
        }
    }
}