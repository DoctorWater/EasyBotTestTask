package ru.malkov.easybottesttask.entities;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.malkov.easybottesttask.exceptions.ProductTypeCastException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LaptopTest {
    @Test
    @DisplayName("Should update two fields")
    void updateTwoFields() throws ProductTypeCastException {
        Laptop target = new Laptop(123L, "Dell", 9.99f, 10, Laptop.LaptopSize.SEVENTEEN_INCHES);
        Laptop source = new Laptop(null, null, 8888f, null, Laptop.LaptopSize.FOURTEEN_INCHES);
        Laptop result = new Laptop(123L, "Dell", 8888f, 10, Laptop.LaptopSize.FOURTEEN_INCHES);

        target.update(source);

        assertEquals(result, target);
    }
}