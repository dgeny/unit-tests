package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private static Car car;

    @BeforeAll
    static void CreateInstance(){
        car = new Car("TestCompany", "TestModel", 1900);
    }

    @AfterAll
    static void DestroyInstance(){
        car = null;
    }

    @Test
    void CarIsVehicle(){
        assertInstanceOf(Vehicle.class, car);
    }

    @Test
    void testDrive() {
        car.testDrive();
        assertEquals(60, car.getSpeed());
    }

    @Test
    void park() {
        car.testDrive();
        car.park();
        assertEquals(0, car.getSpeed());
    }

    @Test
    void getNumWheels() {
        assertEquals(4, car.getNumWheels());
    }
}