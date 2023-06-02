package ru.malkov.easybottesttask.services;

import org.springframework.stereotype.Service;
import ru.malkov.easybottesttask.entities.Laptop;
import ru.malkov.easybottesttask.repositories.LaptopRepository;

import java.util.List;

@Service
public class LaptopService implements ProductService<Laptop>{
    private final LaptopRepository repository;

    public LaptopService(LaptopRepository repository) {
        this.repository = repository;
    }

    @Override
    public Laptop addProduct(Laptop product) {
        return repository.save(product);
    }

    @Override
    public Laptop updateProduct(Long id, Laptop source) {
        Laptop pcToUpdate = repository.getReferenceById(id);
        updateProduct(pcToUpdate, source);
        return repository.save(pcToUpdate);
    }

    @Override
    public List<Laptop> getAllProducts() {
        return repository.findAllByOrderBySerialNumberAsc();
    }

    @Override
    public Laptop getProductById(Long id) {
        return repository.getReferenceById(id);
    }

    private void updateProduct(Laptop target, Laptop source) {
        ProductService.super.updateProduct(target, source);
        if(source.getSize() != null){
            target.setSize(source.getSize());
        }
    }
}