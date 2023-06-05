package ru.malkov.easybottesttask.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.malkov.easybottesttask.abstractClasses.Product;
import ru.malkov.easybottesttask.entities.HardDrive;
import ru.malkov.easybottesttask.entities.PersonalComputer;
import ru.malkov.easybottesttask.exceptions.ProductTypeCastException;
import ru.malkov.easybottesttask.repositories.ProductRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    @Mock
    private ProductRepository<Product> productRepository;

    @InjectMocks
    private ProductService<Product> productService;

    @Test
    @DisplayName("Should save the product and return the saved product")
    void addProductAndReturnSavedProduct() {
        Product product = new PersonalComputer(123L, "Dell", 9.99f, 10, PersonalComputer.PCFormFactor.NETTOP);
        when(productRepository.save(product)).thenReturn(product);

        Product savedProduct = productService.addProduct(product);

        assertNotNull(savedProduct);
        assertEquals(product, savedProduct);
        verify(productRepository, times(1)).save(product);
    }

    @Test
    @DisplayName("Should update the product and return new version.")
    void updateProductAndReturnNewVersion() throws ProductTypeCastException {
        Product target = new PersonalComputer(123L, "Dell", 9.99f, 10, PersonalComputer.PCFormFactor.NETTOP);
        Product source = new PersonalComputer(null, "HP", null, null, null);
        when(productRepository.getReferenceById(123L)).thenReturn(target);

        productService.updateProduct(123L, source);

        assertEquals("HP", target.getManufacturer());
        verify(productRepository, times(1)).save(target);
    }

    @Test
    @DisplayName("Should invoke repository's delete method")
    void deleteProduct(){
        productService.deleteById(123L);

        verify(productRepository, times(1)).deleteById(123L);
    }
}