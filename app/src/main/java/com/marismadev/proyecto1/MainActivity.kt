package com.marismadev.proyecto1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    // Declarar una variable para almacenar la referencia al EditText
    private lateinit var userTextBox: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar la variable userTextBox
        userTextBox = findViewById<EditText>(R.id.userTextBox)

    }


    // Creamos una función para ir a la actividad de creditos
    fun abrirCreditos(view: View){
        // Obtener el nombre del usuario desde el EditText
        val userName = userTextBox.text.toString()

        val intent = Intent(this, CreditActivity::class.java).apply {
            // Pasar el nombre del usuario a la CreditActivity
            putExtra("USER_NAME", userName)
        }

        // Iniciamos la actividad(CreditActivity)
        startActivity(intent)
    }
}
