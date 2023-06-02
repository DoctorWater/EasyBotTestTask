package ru.malkov.easybottesttask.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.malkov.easybottesttask.entities.PersonalComputer;
import ru.malkov.easybottesttask.repositories.PersonalComputerRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class PersonalComputerServiceTest {
    private PersonalComputerService service;
    private PersonalComputerRepository repository;

    @BeforeEach
    void setUp() {
        repository = mock(PersonalComputerRepository.class);
        service = new PersonalComputerService(repository);
    }


    @Test
    @DisplayName("Should save the personal computer and return the saved object")
    void addPersonalComputerAndReturnsSavedObject() {
        PersonalComputer pc = new PersonalComputer(
                123456L, "Dell", 1000.0f, 10, PersonalComputer.PCFormFactor.DESKTOP);

        when(repository.save(pc)).thenReturn(pc);

        PersonalComputer savedPc = service.addProduct(pc);

        verify(repository, times(1)).save(pc);
        assertEquals(pc, savedPc);
    }

    @Test
    @DisplayName("Should update the existing object, save and return it")
    void updatePersonalComputerAndReturnsIt() {
        PersonalComputer target = new PersonalComputer(
                123456L, "Dell", 1000.0f, 10, PersonalComputer.PCFormFactor.DESKTOP);
        PersonalComputer source = new PersonalComputer(
                null, "HP", null, null, PersonalComputer.PCFormFactor.DESKTOP);

        when(repository.getReferenceById(123456L)).thenReturn(target);

        service.updateProduct(123456L, source);

        assertEquals("HP", target.getManufacturer());
        assertNotNull(target.getProductType());
    }

    @Test
    @DisplayName("Should return a list of all PCs stored in the DB")
    void getAllPersonalComputers() {
        List<PersonalComputer> mock = new ArrayList<>();
        mock.add(new PersonalComputer(
                123456L, "Dell", 1000.0f, 10, PersonalComputer.PCFormFactor.DESKTOP));
        when(repository.findAllByOrderBySerialNumberAsc()).thenReturn(mock);

        List<PersonalComputer> result = service.getAllProducts();

        verify(repository, times(1)).findAllByOrderBySerialNumberAsc();
        assertEquals(mock, result);
    }

    @Test
    @DisplayName("Should return a PC with given id")
    void getPersonalComputerById() {
        PersonalComputer pc = new PersonalComputer(
                123456L, "Dell", 1000.0f, 10, PersonalComputer.PCFormFactor.DESKTOP);

        when(repository.getReferenceById(123456L)).thenReturn(pc);

        PersonalComputer result = service.getProductById(123456L);

        assertEquals(pc, result);
    }
}