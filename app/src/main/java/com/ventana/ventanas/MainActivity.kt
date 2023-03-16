package com.ventana.ventanas

import android.widget.TextView
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {
    var campoTexto: EditText ?=null
    var txtMateria: EditText ?= null
    var txtResultado: TextView ?= null
    var txtnota1: EditText ?= null
    var txtnota2: EditText ?= null
    var txtnota3: EditText ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        campoTexto = findViewById(R.id.editTextName)
        txtMateria = findViewById(R.id.textMateria)
        txtResultado = findViewById(R.id.Resultado)
        txtnota1 = findViewById(R.id.nota1)
        txtnota2 = findViewById(R.id.nota2)
        txtnota3 = findViewById(R.id.nota3)


        val miBoton1: Button = findViewById(R.id.ingresar1)
        miBoton1.setOnClickListener { onClick(1) }

        val miButton2: Button = findViewById(R.id.Resultado1)
        miButton2.setOnClickListener { verAqui() }

    }

    private fun onClick(boton: Int) {
        when (boton) {
            1->{
                val intent = Intent(this,SegundaVentana::class.java)
                val miBundleNom:Bundle=Bundle()
                miBundleNom.putString("Nombre",campoTexto!!.text.toString())
                intent.putExtras(miBundleNom)

                val miBundleMat:Bundle=Bundle()
                miBundleMat.putString("Materia",txtMateria!!.text.toString())
                intent.putExtras(miBundleMat)

                startActivity(intent)



               var nota1: Double= txtnota1?.text.toString().toDouble()
                var nota2: Double= txtnota2?.text.toString().toDouble()
                var nota3: Double= txtnota3?.text.toString().toDouble()
                var promedio: Double= (nota1+nota2+nota3)/3



                val bundleProm:Bundle=Bundle()
                bundleProm.putString("Promedio",promedio.toString())
                intent.putExtras(bundleProm)
                startActivity(intent)
            }

        }
    }
    private fun verAqui() {
        var promedioTxt = txtResultado?.text.toString()
        var nota1: Double= txtnota1?.text.toString().toDouble()
        var nota2: Double= txtnota2?.text.toString().toDouble()
        var nota3: Double= txtnota3?.text.toString().toDouble()
        var promedio: Double= (nota1+nota2+nota3)/3
        if (promedio >= 3.5) {
            Toast.makeText(this, "Aprobado", Toast.LENGTH_SHORT).show()
            txtResultado!!.text = promedio.toString()
            txtResultado!!.setTextColor(ContextCompat.getColor(this, R.color.green))

        } else {
            Toast.makeText(this, "Reprobado", Toast.LENGTH_SHORT).show()
            txtResultado!!.text = promedio.toString()
            txtResultado!!.setTextColor(ContextCompat.getColor(this, R.color.red))
        }

    }
}


