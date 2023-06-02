package ru.malkov.easybottesttask.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.malkov.easybottesttask.entities.Laptop;
import ru.malkov.easybottesttask.entities.PersonalComputer;
import ru.malkov.easybottesttask.repositories.LaptopRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class LaptopServiceTest {
    private LaptopService service;
    private LaptopRepository repository;

    @BeforeEach
    void setUp() {
        repository = mock(LaptopRepository.class);
        service = new LaptopService(repository);
    }


    @Test
    @DisplayName("Should save the laptop and return the saved object")
    void addPersonalComputerAndReturnsSavedObject() {
        Laptop laptop = new Laptop(
                123456L, "Dell", 1000.0f, 10, Laptop.LaptopSize.FIFTEEN_INCHES);

        when(repository.save(laptop)).thenReturn(laptop);

        Laptop savedLaptop = service.addProduct(laptop);

        verify(repository, times(1)).save(laptop);
        assertEquals(laptop, savedLaptop);
    }

    @Test
    @DisplayName("Should update the existing object, save and return it")
    void updatePersonalComputerAndReturnsIt() {
        Laptop target = new Laptop(
                123456L, "Dell", 1000.0f, 10, Laptop.LaptopSize.FIFTEEN_INCHES);
        Laptop source = new Laptop(
                null, "HP", null, null, null);

        when(repository.getReferenceById(123456L)).thenReturn(target);

        service.updateProduct(123456L, source);

        assertEquals("HP", target.getManufacturer());
        assertNotNull(target.getProductType());
    }

    @Test
    @DisplayName("Should return a list of all laptops stored in the DB")
    void getAllPersonalComputers() {
        List<Laptop> mock = new ArrayList<>();
        mock.add(new Laptop(
                123456L, "Dell", 1000.0f, 10, Laptop.LaptopSize.FIFTEEN_INCHES));

        when(repository.findAllByOrderBySerialNumberAsc()).thenReturn(mock);

        List<Laptop> result = service.getAllProducts();

        verify(repository, times(1)).findAllByOrderBySerialNumberAsc();
        assertEquals(mock, result);
    }

    @Test
    @DisplayName("Should return a PC with given id")
    void getPersonalComputerById() {
        Laptop laptop = new Laptop(
                123456L, "Dell", 1000.0f, 10, Laptop.LaptopSize.FIFTEEN_INCHES);

        when(repository.getReferenceById(123456L)).thenReturn(laptop);

        Laptop result = service.getProductById(123456L);

        assertEquals(laptop, result);
    }
}