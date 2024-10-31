package com.example.calculatora;

/**
 * Clase Calculator que realiza operaciones matemáticas en expresiones.
 * Incluye métodos para realizar suma, resta, multiplicación y división.
 *
 * <p>
 * Esta clase no maneja errores de sintaxis en la expresión. En caso de que la expresión sea
 * incorrecta o contenga una división por cero, se devuelve -1 como resultado.
 * </p>
 *
 * @author Albert
 * @version 1.0
 * @since 2024-10-31
 */
public class Calculator {

    /**
     * Método principal para calcular la expresión.
     *
     * @param input la expresión matemática como cadena.
     * @return el resultado del cálculo o -1 si ocurre un error.
     */
    public int calculate(String input) {
        input = input.replaceAll("\\s+", ""); // Eliminar espacios en blanco

        // Manejar casos de números negativos al inicio de la expresión
        if (input.startsWith("-")) {
            return calculate("0" + input); // Añadir un 0 delante para que interprete el negativo correctamente
        }

        // Caso base: si no hay operadores aritméticos
        if (!input.contains("+") && !input.contains("-") && !input.contains("*") && !input.contains("/")) {
            try {
                return Integer.parseInt(input); // Devuelve el número si no hay operadores
            } catch (NumberFormatException e) {
                return -1; // Si no es un número válido, devuelve -1
            }
        }

        // Prioridad de los operadores (de izquierda a derecha): +, -, *, /
        if (input.contains("+")) {
            int plusIndex = input.lastIndexOf("+");
            String left = input.substring(0, plusIndex);
            String right = input.substring(plusIndex + 1);
            return calculate(left) + calculate(right);
        } else if (input.contains("-")) {
            // Evitar confundir el operador "-" con un número negativo
            int minusIndex = findMinusOperator(input);
            if (minusIndex != -1) {
                String left = input.substring(0, minusIndex);
                String right = input.substring(minusIndex + 1);
                return calculate(left) - calculate(right);
            }
        } else if (input.contains("*")) {
            int multiplyIndex = input.lastIndexOf("*");
            String left = input.substring(0, multiplyIndex);
            String right = input.substring(multiplyIndex + 1);
            return calculate(left) * calculate(right);
        } else if (input.contains("/")) {
            int divideIndex = input.lastIndexOf("/");
            String left = input.substring(0, divideIndex);
            String right = input.substring(divideIndex + 1);
            try {
                return calculate(left) / calculate(right); // División
            } catch (ArithmeticException e) {
                return -1; // Error por división entre cero
            }
        }

        return -1; // Si ocurre algún error, devuelve -1
    }

    /**
     * Encuentra el índice del operador "-" que no representa un número negativo.
     *
     * @param input la expresión matemática como cadena.
     * @return el índice del operador "-" o -1 si no se encuentra.
     */
    private int findMinusOperator(String input) {
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == '-' && (input.charAt(i - 1) != '*' && input.charAt(i - 1) != '/'
                    && input.charAt(i - 1) != '+' && input.charAt(i - 1) != '-')) {
                return i;
            }
        }
        return -1;
    }
}
