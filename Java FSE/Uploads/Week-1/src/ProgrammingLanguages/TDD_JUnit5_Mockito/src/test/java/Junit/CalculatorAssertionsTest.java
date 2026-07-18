package Junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorAssertionsTest {

    Calculator calculator = new Calculator();

    @Test
    void testAdd() {
        assertEquals(10, calculator.add(5, 5));
    }

    @Test
    void testSubtract() {
        assertNotEquals(3, calculator.subtract(10, 5));
    }

    @Test
    void testPositive() {
        assertTrue(calculator.isPositive(10));
        assertFalse(calculator.isPositive(-5));
    }

    @Test
    void testNull() {
        String value = null;
        assertNull(value);
    }
    @Test
    void testNotNull() {
        Object obj = new Object();
        assertNotNull(obj);
    }
}