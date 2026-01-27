package com.example.projectofinal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var btnContinuar : Button
    lateinit var btnSalir : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnContinuar = findViewById(R.id.btnContinuar)
        btnSalir = findViewById(R.id.btnSalir)


         btnContinuar.setOnClickListener {
             val viewLogin = Intent(this, LoginActivity::class.java)
             startActivity(viewLogin)
         }

        btnSalir.setOnClickListener {
            val builder: AlertDialog.Builder = AlertDialog.Builder(this)
            builder
                .setTitle("Cerrar APP")
                .setMessage("¿Desea salir de la aplicación?")
                .setPositiveButton("Si"){ dialog, which ->
                    Toast.makeText(applicationContext, "Aplicacion cerrada", Toast.LENGTH_SHORT).show()
                    finishAffinity()
                }
                .setNegativeButton("No"){ dialog, which ->
                    Toast.makeText(applicationContext, "Cancelado", Toast.LENGTH_SHORT).show()
                }
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
    }
}