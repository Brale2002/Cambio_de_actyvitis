package com.ventana.ventanas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class SegundaVentana : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda_ventana)

        val campoMensaje=findViewById<TextView>(R.id.textMensaje)
        val campoMateria=findViewById<TextView>(R.id.textMensaje2)
        val campoPromedio=findViewById<TextView>(R.id.textPromedio)

        var miBundleNom: Bundle?=this.intent.extras
        var miBundleMat: Bundle?=this.intent.extras
        var bundleProm: Bundle?=this.intent.extras

        if (miBundleNom != null){
            campoMensaje.text="Nombre: ${miBundleNom.getString("Nombre")} "
        }
        if (miBundleMat != null){
            campoMateria.text="Materia: ${miBundleMat.getString("Materia")}"
        }
        if (bundleProm != null){
            campoPromedio.text="Promedio: ${bundleProm.getString("Promedio")}"
        }

        if (bundleProm?.getString("Promedio").toString().toDouble() >= 3.5){
            campoPromedio.setTextColor(ContextCompat.getColor(this, R.color.green))
            Toast.makeText(this, "Gana la materia", Toast.LENGTH_SHORT).show()
        }else{
            campoPromedio.setTextColor(ContextCompat.getColor(this, R.color.red))
            Toast.makeText(this, "Pierde la materia", Toast.LENGTH_SHORT).show()
        }

        val botonSalir:Button=findViewById(R.id.botonSalir)
        botonSalir.setOnClickListener{ onClickSalir()}

    }
    private fun onClickSalir(){
        finish()
    }
}