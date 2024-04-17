package com.marismadev.proyecto1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CreditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_credit)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Obtener el nombre del usuario
        val userName = intent.getStringExtra("USER_NAME")

        // Mostrar el mensaje en la parte superior
        val welcomeMessage = "Hola $userName, estás usando la versión 1.0 de 2Cinema"
        findViewById<TextView>(R.id.version_text).text = welcomeMessage

        // Configurar el botón de contacto
        findViewById<Button>(R.id.btnContactar).setOnClickListener {
            // Crear un Intent para enviar correo electrónico
            val emailIntent = Intent(Intent.ACTION_SEND)
            emailIntent.type = "plain/text"
            emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("correocontacto@2cinema.es"))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Consulta de la app ${getString(R.string.app_name)}")

            // Comprobar si hay aplicaciones que puedan manejar el Intent
            if (emailIntent.resolveActivity(packageManager) != null) {
                startActivity(emailIntent)
            } else {
                Toast.makeText(this, "No hay aplicaciones de correo electrónico instaladas", Toast.LENGTH_SHORT).show()
            }
        }
    }
}