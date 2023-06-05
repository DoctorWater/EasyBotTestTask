package ru.malkov.easybottesttask.entities;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.malkov.easybottesttask.exceptions.ProductTypeCastException;

import static org.junit.jupiter.api.Assertions.*;

class PersonalComputerTest {
    @Test
    @DisplayName("Should update two fields")
    void updateTwoFields() throws ProductTypeCastException {
        PersonalComputer target = new PersonalComputer(123L, "Dell", 9.99f, 10, PersonalComputer.PCFormFactor.NETTOP);
        PersonalComputer source = new PersonalComputer(null, null, 8888f, 12, null);
        PersonalComputer result = new PersonalComputer(123L, "Dell", 8888f, 12, PersonalComputer.PCFormFactor.NETTOP);

        target.update(source);

        assertEquals(result, target);
    }
}