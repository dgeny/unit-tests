package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MotorcycleTest {

    private static Motorcycle moto;

    @BeforeEach
    void setUp() {
        moto = new Motorcycle("TestCompany", "TestModel", 1900);
    }

    @AfterEach
    void tearDown() {
        moto = null;
    }

    @Test
    void testDrive() {
        moto.testDrive();
        assertEquals(75, moto.getSpeed());
    }

    @Test
    void park() {
        moto.testDrive();
        moto.park();
        assertEquals(0, moto.getSpeed());
    }

    @Test
    void getNumWheels() {
        assertEquals(2, moto.getNumWheels());
    }
}