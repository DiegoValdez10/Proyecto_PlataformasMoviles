package com.example.listview

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter(private val context : Activity, private val arrayList : ArrayList<Team>) : ArrayAdapter<Team>(context,
    R.layout.activity_list_item,arrayList) {

    @SuppressLint("ViewHolder", "InflateParams")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.activity_list_item, null)

        val imageView: ImageView = view.findViewById(R.id.imagen_perfil)
        val equipo: TextView = view.findViewById(R.id.nombre)
        val partidosJugados: TextView = view.findViewById(R.id.jugados)
        val partidosGanados: TextView = view.findViewById(R.id.Ganados)
        val partidosPerdidos: TextView = view.findViewById(R.id.perdidos)
        val partidosEmpatados: TextView = view.findViewById(R.id.empatados)
        val maximoGoleador: TextView = view.findViewById(R.id.goleador)
        val ligaequipo : TextView = view.findViewById(R.id.liga)
        val maximoAsistidor: TextView = view.findViewById(R.id.asistidor)

        imageView.setImageResource(arrayList[position].imageId)
        equipo.text = arrayList[position].nombre
        partidosJugados.text = arrayList[position].jugados
        partidosGanados.text = arrayList[position].Ganados
        partidosPerdidos.text = arrayList[position].perdidos
        partidosEmpatados.text = arrayList[position].empatados
        maximoGoleador.text = arrayList[position].goleador
        maximoAsistidor.text = arrayList[position].asistidor
        ligaequipo.text = arrayList[position].ligas

        return view
    }
}