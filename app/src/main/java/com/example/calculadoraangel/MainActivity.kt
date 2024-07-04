package com.example.calculadoraangel

import android.os.Bundle
import android.text.TextUtils
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadoraangel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: CalculadorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configuración del botón de activación de la calculadora
        binding.activarCalculadora.setOnCheckedChangeListener { _, isChecked ->
            binding.botonCalcular.isEnabled = isChecked
        }

        // Configuración del botón de calcular
        binding.botonCalcular.setOnClickListener {
            // Valida la entrada del usuario antes de realizar el cálculo
            if (validateInput()) {
                val num1 = binding.num1.text.toString().toDouble()
                val num2 = binding.num2.text.toString().toDouble()
                val operacion = when {
                    binding.suma.isChecked -> "Suma"
                    binding.resta.isChecked -> "Resta"
                    binding.multiplicacion.isChecked -> "Multiplicacion"
                    binding.division.isChecked -> "Division"
                    binding.modulo.isChecked -> "Modulo"
                    else -> ""
                }
                // Llama al método calculate del ViewModel para realizar la operación
                viewModel.calculate(num1, num2, operacion)
            }
        }

        // Observa el LiveData result del ViewModel para actualizar la UI con el resultado
        viewModel.result.observe(this) { result ->
            binding.resultado.text = result
        }
    }

    // Valida que los campos de entrada no estén vacíos
    private fun validateInput(): Boolean {
        return when {
            TextUtils.isEmpty(binding.num1.text) -> {
                binding.num1.error = "Ingrese un numero"
                false
            }
            TextUtils.isEmpty(binding.num2.text) -> {
                binding.num2.error = "Ingrese un numero"
                false
            }
            else -> true
        }
    }
}
