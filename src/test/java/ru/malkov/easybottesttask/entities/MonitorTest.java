package ru.malkov.easybottesttask.entities;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.malkov.easybottesttask.exceptions.ProductTypeCastException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MonitorTest {
    @Test
    @DisplayName("Should update two fields")
    void updateTwoFields() throws ProductTypeCastException {
        Monitor target = new Monitor(123L, "Dell", 9.99f, 10, 40.1f);
        Monitor source = new Monitor(null, null, 8888f, null, 45.1f);
        Monitor result = new Monitor(123L, "Dell", 8888f, 10, 45.1f);

        target.update(source);

        assertEquals(result, target);
    }
}