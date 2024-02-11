package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calc;
    @BeforeEach
    void setUp() {
        calc = new Calculator();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void evenOddNumber() {
        assertTrue(calc.evenOddNumber(2));
        assertFalse(calc.evenOddNumber(3));
    }

    @Test
    void numberInInterval() {
        assertTrue(calc.numberInInterval(25));
        assertTrue(calc.numberInInterval(100));
        assertFalse(calc.numberInInterval(24));
        assertFalse(calc.numberInInterval(101));
    }
}