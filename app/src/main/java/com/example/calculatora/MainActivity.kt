package com.example.calculatora

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var display: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        display = findViewById(R.id.textViewDisplay)

        // Vinculamos cada botón con su acción correspondiente
        findViewById<Button>(R.id.button0).setOnClickListener { appendText("0") }
        findViewById<Button>(R.id.button1).setOnClickListener { appendText("1") }
        findViewById<Button>(R.id.button2).setOnClickListener { appendText("2") }
        findViewById<Button>(R.id.button3).setOnClickListener { appendText("3") }
        findViewById<Button>(R.id.button4).setOnClickListener { appendText("4") }
        findViewById<Button>(R.id.button5).setOnClickListener { appendText("5") }
        findViewById<Button>(R.id.button6).setOnClickListener { appendText("6") }
        findViewById<Button>(R.id.button7).setOnClickListener { appendText("7") }
        findViewById<Button>(R.id.button8).setOnClickListener { appendText("8") }
        findViewById<Button>(R.id.button9).setOnClickListener { appendText("9") }

        // El botón "+" añade el símbolo "+"
        findViewById<Button>(R.id.buttonPlus).setOnClickListener { appendText("+") }

        // El botón "-" añade el símbolo "-"
        findViewById<Button>(R.id.buttonMinus).setOnClickListener { appendText("-") }

        // El botón "*" añade el símbolo "*"
        findViewById<Button>(R.id.buttonMultiply).setOnClickListener { appendText("*") }

        // El botón "/" añade el símbolo "/"
        findViewById<Button>(R.id.buttonmDivide).setOnClickListener { appendText("/") }

        // El botón "C" borra todo el cuadro de texto
        findViewById<Button>(R.id.buttonClear).setOnClickListener { clearText() }

        // El botón "=" evalúa la expresión llamando a la función calculate
        findViewById<Button>(R.id.buttonEqual).setOnClickListener { evaluateExpression() }
    }

    // Método para añadir texto al cuadro de texto
    private fun appendText(text: String) {
        display.setText(display.text.toString() + text)
    }

    // Método para borrar el cuadro de texto
    private fun clearText() {
        display.setText("")
    }

    // Método para evaluar la expresión
    private fun evaluateExpression() {
        val expression = display.text.toString()
        val result = calculate(expression) // Aquí llamamos a la función recursiva
        display.setText(result.toString())
    }

    // Función recursiva calculate en Kotlin
    private fun calculate(input: String): Int {
        // Caso base: si no hay operadores aritméticos
        if (!input.contains("+") && !input.contains("-") && !input.contains("*") && !input.contains(
                "/"
            )
        ) {
            return try {
                input.toInt() // Devuelve el número si no hay operadores
            } catch (e: NumberFormatException) {
                -1 // Si no es un número válido, devuelve -1
            }
        }

        // Prioridad de los operadores (de izquierda a derecha): +, -, *, /
        when {
            input.contains("+") -> {
                val plusIndex = input.lastIndexOf("+")
                val left = input.substring(0, plusIndex)
                val right = input.substring(plusIndex + 1)
                return calculate(left) + calculate(right)
            }

            input.contains("-") -> {
                val minusIndex = input.lastIndexOf("-")
                val left = input.substring(0, minusIndex)
                val right = input.substring(minusIndex + 1)
                return calculate(left) - calculate(right)
            }

            input.contains("*") -> {
                val multiplyIndex = input.lastIndexOf("*")
                val left = input.substring(0, multiplyIndex)
                val right = input.substring(multiplyIndex + 1)
                return calculate(left) * calculate(right)
            }

            input.contains("/") -> {
                val divideIndex = input.lastIndexOf("/")
                val left = input.substring(0, divideIndex)
                val right = input.substring(divideIndex + 1)
                return try {
                    calculate(left) / calculate(right) // División
                } catch (e: ArithmeticException) {
                    -1 // Error por división entre cero
                }
            }

            else -> return -1 // Si ocurre algún error, devuelve -1
        }
    }
    }
