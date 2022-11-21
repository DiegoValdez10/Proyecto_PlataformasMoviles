package com.example.listview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.listview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var userArrayList : ArrayList<Team>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageId = intArrayOf(

            R.drawable.barca,R.drawable.real,R.drawable.arsenal,R.drawable.city,R.drawable.bayern,
            R.drawable.friburgo,R.drawable.napoli,R.drawable.milan,R.drawable.bayern,R.drawable.friburgo

        )

        val nombre = arrayOf(

            "Fc Barcelona",
            "Real Madrid CF",
            "Arsenal",
            "Manchester City",
            "Bayern Munich",
            "Friburgo",
            "Paris Saint-Germain",
            "Olympique de Lyon",
            "Napoli CF",
            "AC Milan"
        )
        val ligas = arrayOf(
            "La Liga","La Liga","Premier League","Premier League","Bundesliga",
            "Bundesliga","Ligue 1","Ligue 1","Serie A","Serie A"
        )
        val jugados = arrayOf(

            "12","12","13","13?","14",
            "14","12","12","13","13"

        )

        val Ganados = arrayOf(

            "10","10","12","10","13",
            "12","10","9","11","10"


        )

        val perdidos = arrayOf(

            "1","2","1","1","0",
            "2","1","2","1","2"

        )

        val empatados = arrayOf(
            "1","0","0","1","1",
            "2","1","1","1","1"
        )
        val goleador = arrayOf(
            "Robert Lewandowski","Vinicius Junior","Martin Odegaard","Erling Halaand","Jamal Musiala",
            "Vicenzo Grifo","Kylian Mbappe","Alexander Lacazzette","Victor Osihmen","Rafael Leao"
        )
        val asistidor = arrayOf(
            "Alejandro Baldé","Federico Valverde","Bukayo Saka", "Kevin de Bruyne", "Musiala",
            "Michael Gregoritsch", "Leonel Messi", "Victor Cherki", "Khvicha Kvaratskhelia", "Rafael Leao"
        )

        userArrayList = ArrayList()

        for( i in nombre.indices){

            val team = Team(nombre[i],jugados[i],Ganados[i],perdidos[i],empatados[i],goleador[i],asistidor[i],ligas[i],imageId[i])
            userArrayList.add(team)

        }

        binding.listview.isClickable = true
        binding.listview.adapter = MyAdapter(this,userArrayList)
        binding.listview.setOnItemClickListener { parent, view, position, id ->

            val nombre = nombre[position]
            val jugados = jugados[position]
            val Ganados = Ganados[position]
            val perdidos = perdidos[position]
            val empatados = empatados[position]
            val goleador = goleador[position]
            val asistidor = asistidor[position]
            val ligas = ligas[position]
            val imageId = imageId[position]

            val i = Intent(this,activity_team::class.java)
            i.putExtra("Nombre",nombre)
            i.putExtra("Juega en la liga:",ligas)
            i.putExtra("Partidos Jugados:",jugados)
            i.putExtra("Partidos Ganados:",Ganados)
            i.putExtra("Partidos Perdidos:",perdidos)
            i.putExtra("Partidos Empatados:",empatados)
            i.putExtra("Maximo Goleador",goleador)
            i.putExtra("Maximo asistidor",asistidor)
            i.putExtra("country",ligas)
            i.putExtra("imageId",imageId)
            startActivity(i)


        }

    }
}