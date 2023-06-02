package ru.malkov.easybottesttask.services;

import org.springframework.stereotype.Service;
import ru.malkov.easybottesttask.abstractClasses.Product;

import java.util.List;

@Service
public interface ProductService<T extends Product> {
    T addProduct(T product);

    T updateProduct(Long id, T product);

    List<T> getAllProducts();

    T getProductById(Long id);

    default void updateProduct(Product target, Product source) {
        if (source.getSerialNumber() != null) {
            target.setSerialNumber(source.getSerialNumber());
        }
        if (source.getPrice() != null) {
            target.setPrice(source.getPrice());
        }
        if (source.getManufacturer() != null) {
            target.setManufacturer(source.getManufacturer());
        }
        if (source.getLeftNumber() != null) {
            target.setLeftNumber(source.getLeftNumber());
        }
        if (source.getProductType() != null) {
            target.setProductType(source.getProductType());
        }
    }
}