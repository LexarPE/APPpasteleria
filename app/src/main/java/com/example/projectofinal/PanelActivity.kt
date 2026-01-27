package com.example.projectofinal


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class PanelActivity : AppCompatActivity()  {

    lateinit var btnReturnHomePanel : ImageButton
    lateinit var btnSearchPanel : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.panel_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        btnReturnHomePanel = findViewById(R.id.btnReturnHomePanel)


        btnReturnHomePanel.setOnClickListener {
            val viewPenel = Intent(this, HomeActivity::class.java)
            startActivity(viewPenel)
        }

        btnSearchPanel.setOnClickListener {

        }
    }
}