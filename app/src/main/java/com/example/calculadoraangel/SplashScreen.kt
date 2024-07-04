package com.example.calculadoraangel

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.delay
// Pantalla de inicio de la aplicación que se muestra al iniciar
class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Establece el diseño de la pantalla de inicio
        setContentView(R.layout.activity_splash_screen)
        // Llama al método para cambiar a la nueva actividad después de un retraso
        irNuevaActivity()
    }

    // Método para cambiar a la actividad principal después de un retraso de 3 segundos
    private fun irNuevaActivity(){
        val handler=Handler().postDelayed({
            startActivity(Intent(this,MainActivity::class.java)) // Inicia la MainActivity
            finish() // Finaliza la SplashScreen para que no sea accesible desde la pila de actividades
        },3000) // Retraso de 3 segundos antes de cambiar de actividad
    }
}