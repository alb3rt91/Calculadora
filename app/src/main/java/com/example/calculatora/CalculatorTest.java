package com.example.calculatora;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * Clase de pruebas unitarias para la clase Calculator.
 * Verifica la funcionalidad de las operaciones matemáticas básicas.
 *
 * @author Albert
 * @version 1.0
 * @since 2024-10-31
 */
public class CalculatorTest {

    private Calculator calc;

    /**
     * Configuración inicial para los tests.
     * Este método se ejecuta antes de cada test para crear una nueva instancia de Calculator.
     */
    @Before
    public void setUp() {
        calc = new Calculator();
    }

    /**
     * Verifica la suma de dos operandos.
     */
    @Test
    public void testAdd2Operands() {
        int total = calc.calculate("5+3");
        assertEquals("X + Y operations not working correctly", 8, total);
    }

    /**
     * Verifica la suma de múltiples operandos.
     */
    @Test
    public void testAddMultipleOperands() {
        int total = calc.calculate("4+3+1");
        assertEquals("X+Y+Z operations not working correctly", 8, total);
    }

    /**
     * Verifica la multiplicación de dos operandos.
     */
    @Test
    public void testMult2Operands() {
        int total = calc.calculate("4*2");
        assertEquals("X*Y operations not working correctly", 8, total);
    }

    /**
     * Verifica la multiplicación de múltiples operandos.
     */
    @Test
    public void testMultMultipleOperands() {
        int total = calc.calculate("2*3");
        assertEquals("2 * 3 = 6 operation not working correctly", 6, total);

        total = calc.calculate("1*2*8");
        assertEquals("1 * 2 * 8 = 16 operation not working correctly", 16, total);
    }

    /**
     * Verifica la combinación de suma y multiplicación.
     */
    @Test
    public void testAddAndMultiplyCombination() {
        int total = calc.calculate("2*2+3");
        assertEquals("2 * 2 + 3 = 7 operation not working correctly", 7, total);

        total = calc.calculate("3+2*2");
        assertEquals("3 + 2 * 2 = 7 operation not working correctly", 7, total);

        total = calc.calculate("3+2*2+4");
        assertEquals("3 + 2 * 2 + 4 = 11 operation not working correctly", 11, total);
    }

    /**
     * Verifica casos con números negativos en la suma.
     */
    @Test
    public void testNegativeAddition() {
        int total = calc.calculate("5+-3");
        assertEquals("5 + (-3) = 2 operation not working correctly", 2, total);

        total = calc.calculate("-2+3");
        assertEquals("-2 + 3 = 1 operation not working correctly", 1, total);
    }

    /**
     * Verifica que se maneje correctamente la división.
     */
    @Test
    public void testDivision() {
        int total = calc.calculate("8/2");
        assertEquals("8 / 2 = 4 operation not working correctly", 4, total);

        total = calc.calculate("9/3");
        assertEquals("9 / 3 = 3 operation not working correctly", 3, total);
    }
}
