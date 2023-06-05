package ru.malkov.easybottesttask.entities;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.malkov.easybottesttask.exceptions.ProductTypeCastException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HardDriveTest {
    @Test
    @DisplayName("Should update two fields")
    void updateTwoFields() throws ProductTypeCastException {
        HardDrive target = new HardDrive(123L, "Dell", 9.99f, 10, 100);
        HardDrive source = new HardDrive(null, null, 8888f, null, 300);
        HardDrive result = new HardDrive(123L, "Dell", 8888f, 10, 300);

        target.update(source);

        assertEquals(result, target);
    }
}