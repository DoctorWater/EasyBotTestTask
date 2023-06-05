package ru.malkov.easybottesttask.services;

import org.springframework.stereotype.Service;
import ru.malkov.easybottesttask.abstractClasses.Product;
import ru.malkov.easybottesttask.entities.HardDrive;
import ru.malkov.easybottesttask.entities.Laptop;
import ru.malkov.easybottesttask.entities.Monitor;
import ru.malkov.easybottesttask.entities.PersonalComputer;
import ru.malkov.easybottesttask.exceptions.ProductTypeCastException;
import ru.malkov.easybottesttask.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService<T extends Product> {
    private final ProductRepository<T> repository;

    public ProductService(ProductRepository<T> repository) {
        this.repository = repository;
    }

    public T addProduct(T product){
        return repository.save(product);
    }

    public T updateProduct(Long id, T source) throws ProductTypeCastException {
        T pcToUpdate = repository.getReferenceById(id);
        pcToUpdate.update(source);
        return repository.save(pcToUpdate);
    }

    public List<T> getAllProducts(){
        return repository.findAllByOrderBySerialNumberAsc();
    }

    public T getProductById(Long id){
        return repository.getReferenceById(id);
    }
}