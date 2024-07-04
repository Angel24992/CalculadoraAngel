package com.example.calculadoraangel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// ViewModel para la lógica de la calculadora
class CalculadorViewModel : ViewModel() {

    // LiveData mutable para almacenar el resultado de las operaciones
    private val _result = MutableLiveData<String>()
    val result: LiveData<String>
        get() = _result

    // Método para calcular el resultado basado en los números y la operación proporcionada
    fun calculate(num1: Double, num2: Double, operacion: String) {
        _result.value = when (operacion) {
            "Suma" -> (num1 + num2).toString()
            "Resta" -> (num1 - num2).toString()
            "Multiplicacion" -> (num1 * num2).toString()
            "Division" -> if (num2 != 0.0) (num1 / num2).toString() else "No puede dividir para cero"
            "Modulo" -> (num1 % num2).toString()
            else -> "Operacion Invalida"
        }
    }
}

