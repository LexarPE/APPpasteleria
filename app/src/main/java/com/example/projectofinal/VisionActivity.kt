package com.example.projectofinal


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class VisionActivity : AppCompatActivity()  {

    lateinit var btnReturnVision : ImageButton
    lateinit var btnReturnMenu : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.vision)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        btnReturnVision = findViewById(R.id.btnReturnVision)
        btnReturnMenu = findViewById(R.id.btnMenuVision)

        btnReturnVision.setOnClickListener {
            val viewPrincipal = Intent(this, HomeActivity::class.java)
            startActivity(viewPrincipal)
        }

        btnReturnMenu.setOnClickListener {
            val viewMenu = Intent(this, PanelActivity::class.java)
            startActivity(viewMenu)
        }
    }
}