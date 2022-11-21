package com.example.listview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.listview.databinding.ActivityTeamBinding

class activity_team : AppCompatActivity() {
    private lateinit var binding : ActivityTeamBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nombre = intent.getStringExtra("Nombre:")
        val partidosJugados = intent.getStringExtra("Partidos Jugados:")
        val partidosGanados = intent.getStringExtra("Partidos Ganados:")
        val partidosPerdidos = intent.getStringExtra("Partidos Perdidos:")
        val partidosEmpatados = intent.getStringExtra("Partidos Empatados:")
        val maximoGoleador = intent.getStringExtra("Maximo Goleador:")
        val maximoAsistidor = intent.getStringExtra("Maximo asistididor")
        val imageId = intent.getIntExtra("imageId",R.drawable.barca)

        binding.nombreEquipo.text = nombre
        binding.PartidosJ.text = partidosJugados
        binding.PartidosG.text = partidosGanados
        binding.PartidosP.text = partidosPerdidos
        binding.PartidosE.text = partidosEmpatados
        binding.goaler.text = maximoGoleador
        binding.asistencia.text = maximoAsistidor
        binding.imagenPerfil.setImageResource(imageId)


    }
}
