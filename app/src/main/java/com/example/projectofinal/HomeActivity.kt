package com.example.projectofinal


import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class HomeActivity : AppCompatActivity()  {

    lateinit var btnCerrarLoginD : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.home_main)

        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = ""

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnCerrarLoginD = findViewById(R.id.btnCerrarLoginD)


        btnCerrarLoginD.setOnClickListener {
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


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.mapa -> startActivity(Intent(this, MapaActivity::class.java))
            R.id.nosotros ->startActivity(Intent(this, NosotrosActivity::class.java))
            R.id.mision -> startActivity(Intent(this, MisionActivity::class.java))
            R.id.vision -> startActivity(Intent(this, VisionActivity::class.java))
            R.id.panel -> startActivity(Intent(this, PanelActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }


}
