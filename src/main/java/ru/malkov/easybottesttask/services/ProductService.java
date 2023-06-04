package ru.malkov.easybottesttask.services;

import org.springframework.stereotype.Service;
import ru.malkov.easybottesttask.abstractClasses.Product;
import ru.malkov.easybottesttask.entities.HardDrive;
import ru.malkov.easybottesttask.entities.Laptop;
import ru.malkov.easybottesttask.entities.Monitor;
import ru.malkov.easybottesttask.entities.PersonalComputer;
import ru.malkov.easybottesttask.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService<T extends Product> {
    ProductRepository<T> repository;

    public ProductService(ProductRepository<T> repository) {
        this.repository = repository;
    }

    T addProduct(T product){
        return repository.save(product);
    }

    T updateProduct(Long id, T source){
        T pcToUpdate = repository.getReferenceById(id);
        updateProduct(pcToUpdate, source);
        return repository.save(pcToUpdate);
    }

    List<T> getAllProducts(){
        return repository.findAllByOrderBySerialNumberAsc();
    }

    T getProductById(Long id){
        return repository.getReferenceById(id);
    }

    private void updateProduct(Product target, Product source) {
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