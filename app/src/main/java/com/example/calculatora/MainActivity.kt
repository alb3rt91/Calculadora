package com.example.calculatora

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var display: EditText
    private val calculator = Calculator() // Instancia de la clase Calculator

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

        findViewById<Button>(R.id.buttonPlus).setOnClickListener { appendText("+") }
        findViewById<Button>(R.id.buttonMinus).setOnClickListener { appendText("-") }
        findViewById<Button>(R.id.buttonMultiply).setOnClickListener { appendText("*") }
        findViewById<Button>(R.id.buttonmDivide).setOnClickListener { appendText("/") }

        findViewById<Button>(R.id.buttonClear).setOnClickListener { clearText() }
        findViewById<Button>(R.id.buttonEqual).setOnClickListener { evaluateExpression() }
    }

    private fun appendText(text: String) {
        display.setText(display.text.toString() + text)
    }

    private fun clearText() {
        display.setText("")
    }

    private fun evaluateExpression() {
        val expression = display.text.toString()
        val result = calculator.calculate(expression) // Usa Calculator para calcular
        display.setText(result.toString())
    }
}
