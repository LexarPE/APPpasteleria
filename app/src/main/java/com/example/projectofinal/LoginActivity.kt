package com.example.projectofinal


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class LoginActivity : AppCompatActivity()  {

    lateinit var btnRegresarMenu : ImageButton
    lateinit var btnCloseAppLogin : Button
    lateinit var btnValidarLogin : Button



    lateinit var usuario : EditText
    lateinit var pass : EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.login_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnRegresarMenu = findViewById(R.id.btnRegresarLogin)
        btnValidarLogin = findViewById(R.id.btnValidarLogin)
        btnCloseAppLogin = findViewById(R.id.btnCerrarLogin)


        usuario = findViewById(R.id.usuario)
        pass = findViewById(R.id.pass)


        btnRegresarMenu.setOnClickListener {
            val viewHome = Intent(this, MainActivity::class.java)
            startActivity(viewHome)
        }


        btnValidarLogin.setOnClickListener {
            val getUsuario = usuario.text.trim().toString()
            val getPass = pass.text.trim().toString()
            if("Admin".equals(getUsuario) && "Admin".equals(getPass)){
                val viewPrincipal = Intent(this, HomeActivity::class.java)
                startActivity(viewPrincipal)
            }
            else{
                alerta()
            }

        }


        btnCloseAppLogin.setOnClickListener {
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

    fun alerta(){
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder
            .setTitle("Dato no valido")
            .setMessage("Ingrese un dato valido")
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}
